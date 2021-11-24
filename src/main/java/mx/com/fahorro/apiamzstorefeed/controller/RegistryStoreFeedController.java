package mx.com.fahorro.apiamzstorefeed.controller;

import mx.com.fahorro.apiamzstorefeed.business.RegistryStoreFeedBusiness;
import mx.com.fahorro.apiamzstorefeed.entity.BranchEntity;
import mx.com.fahorro.apiamzstorefeed.exception.EntityExceptionHandler;
import mx.com.fahorro.apiamzstorefeed.exception.ExceptionConnectionWebService;
import mx.com.fahorro.apiamzstorefeed.model.dto.*;
import mx.com.fahorro.apiamzstorefeed.util.UtilCallWebService;
import mx.com.fahorro.apiamzstorefeed.util.UtilJson;
import mx.com.fahorro.apiamzstorefeed.util.UtilTransformObject;
import mx.com.fahorro.apiamzstorefeed.util.UtilValidation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

@RestController
@RequestMapping("register/")
public class RegistryStoreFeedController {

    protected static final Logger LOG = Logger.getLogger(RegistryStoreFeedController.class.getName());

    @Autowired
    private RegistryStoreFeedBusiness registryStoreFeedBusiness;

    @Value("${ws.amazon.urltoken}")
    public String servicetUrlToken;

    @Value("${ws.amazon.urlregistry}")
    public String serviceUrlRegistry;

    @Value("${ws.amazon.urlFeedInfo}")
    public String serviceUrlFeedInfo;

    private static ResponseBranchListDto responseBranchListDto;

    private static BranchEntity branchEntity;

    private static ArrayList<AccespointDto> listAccessPointDto;

    private static ResponseDocumentDto outputDocument;

    private static AccespointDto accespointDto;

    private static AccesPointResponseDto accesPointResponseDto;

    private static ResponseFeedDto responseFeedDto;

    private static ResponseDocumentDto responseDocumentDto;

    @PostMapping(value = "/verifyRequest", consumes = "application/json", produces = "application/json")
    public ResponseFeedDto verifyRequest(@RequestBody RequestStatusDto requestStatusDto) {

        /**
         * Inicializamos variables globales
         */
        init();

        String authorization = "";
        String urlGetFeed = "";

        try {

            LOG.info("Fecha y hora: " + LocalDate.now() + " " + LocalTime.now());
            LOG.info("FEED ID: " + requestStatusDto.getFeedId());

            authorization = UtilCallWebService.POSTRequestAccesToken(this.servicetUrlToken);
            urlGetFeed = this.serviceUrlFeedInfo + requestStatusDto.getFeedId();
            responseFeedDto = UtilJson.transformToResponseFeedDto(UtilCallWebService.GETRequest(urlGetFeed, authorization));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionConnectionWebService exceptionConnectionWebService) {
            exceptionConnectionWebService.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseFeedDto;
    }

    @PostMapping(value = "/verifyResponse", consumes = "application/json", produces = "application/json")
    public ResponseDocumentDto verifyResponse(@RequestBody RequestStatusDto requestStatusDto) {

        /**
         * Inicializamos variables globales
         */
        init();

        String authorization = "";
        String urlGetFeed = "";
        String urlGetDocument = "";

        try {

            LOG.info("Fecha y hora: " + LocalDate.now() + " " + LocalTime.now());
            LOG.info("FEED ID: " + requestStatusDto.getFeedId());

            authorization = UtilCallWebService.POSTRequestAccesToken(this.servicetUrlToken);
            urlGetFeed = this.serviceUrlFeedInfo + requestStatusDto.getFeedId();
            responseFeedDto = UtilJson.transformToResponseFeedDto(UtilCallWebService.GETRequest(urlGetFeed, authorization));
            urlGetDocument = urlGetFeed + "/documents/" + responseFeedDto.getOutputDocuments()[0].getDocumentId();
            responseDocumentDto = UtilJson.transformToResponseDocumentDto(UtilCallWebService.GETRequest(urlGetDocument, authorization));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExceptionConnectionWebService exceptionConnectionWebService) {
            exceptionConnectionWebService.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDocumentDto;
    }

    /**
     * Método principal para crear o actualizar los datos del feed para las sucursales
     *
     * @param feeds
     * @return
     * @throws Exception
     */

    @PostMapping(value = "/createUpdateFeeds", consumes = "application/json", produces = "application/json")
    public ResponseBranchListDto createUpdateFeeds(@RequestBody RequestBranchListDto feeds) throws Exception {

        /**
         * Inicializamos variables globales
         */

        init();

        String authorization = "";
        String requestRegistry = "";
        String feedId = "";
        String urlGetFeed = "";
        String urlGetInputDocument = "";
        String urlGetOutputDocument = "";

        LOG.info("-------Authorization-------");

        authorization = UtilCallWebService.POSTRequestAccesToken(this.servicetUrlToken);

        try {
            LOG.info("Fecha y hora: " + LocalDate.now() + " " + LocalTime.now());

            if (authorization == null) {
                throw new EntityExceptionHandler("ERROR: ", ExceptionConnectionWebService.CODE,
                        "No se pudo obtener el token");
            }

            /**
             * Obtenemos los datos de cada sucursal
             */

            for (RequestBranchDto request : feeds.getFeeds()) {

                LOG.info(request.toString());

                String[] splitId = request.getAccessPointId().split("-");
                request.setId(splitId[1]);

                UtilValidation.validRequest(request);
                branchEntity = registryStoreFeedBusiness.findById(request.getId());

                accespointDto = UtilTransformObject.transformListRequest(request, branchEntity);
                listAccessPointDto.add(accespointDto);
            }

            /**
             * Transformamos el objecto a una lista de AccesspointDto
             */

            requestRegistry = UtilJson.transformAccPointDtoToJson(listAccessPointDto);

            /**
             * Obtenemos el feedId
             */

            feedId = UtilCallWebService.POSTRequestRegistryBranch(this.serviceUrlRegistry, authorization, requestRegistry);

            if (feedId == null) {
                LOG.error("No se pudo obtener el id del servicio");
                throw new EntityExceptionHandler("ERROR: ", ExceptionConnectionWebService.CODE,
                        "No se pudo obtener el id del servicio");
            }

            /**
             * Solicitamos si las sucursales se crearon correctamente
             */

            urlGetFeed = this.serviceUrlFeedInfo + feedId;
            responseFeedDto = UtilJson.transformToResponseFeedDto(UtilCallWebService.GETRequest(urlGetFeed, authorization));

            urlGetInputDocument = urlGetFeed + "/documents/" + responseFeedDto.getInputDocuments()[0].getDocumentId();
            accesPointResponseDto = UtilJson.transformToAccespointDto(UtilCallWebService.GETRequest(urlGetInputDocument, authorization));

            if (responseFeedDto.getStatus().equals("Completed")) {

                urlGetOutputDocument = urlGetFeed + "/documents/" + responseFeedDto.getOutputDocuments()[0].getDocumentId();
                outputDocument = UtilJson.transformToResponseDocumentDto(UtilCallWebService.GETRequest(urlGetOutputDocument, authorization));

                responseBranchListDto.setFeedId(responseFeedDto.getFeedId());
                responseBranchListDto.setFeeds(accesPointResponseDto);
                responseBranchListDto.setStatusTransaction(responseFeedDto.getStatus());
                responseBranchListDto.setFeedsResponse(outputDocument);
            } else {
                responseBranchListDto.setFeedId(responseFeedDto.getFeedId());
                responseBranchListDto.setFeeds(accesPointResponseDto);
                responseBranchListDto.setStatusTransaction(responseFeedDto.getStatus());
            }


        } catch (Exception aioe) {
            LOG.error(aioe.getMessage());
            throw new EntityExceptionHandler("ERROR", Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    "Error al momento de obtener la respuesta del servicio: " + aioe.toString());
        }

        return responseBranchListDto;

    }

    /**
     * Método para iniciarlizar variables globales
     */
    public void init() {
        this.responseBranchListDto = new ResponseBranchListDto();
        this.branchEntity = new BranchEntity();
        this.listAccessPointDto = new ArrayList<>();
        this.outputDocument = new ResponseDocumentDto();
        this.accespointDto = new AccespointDto();
        this.accesPointResponseDto = new AccesPointResponseDto();
        this.responseDocumentDto = new ResponseDocumentDto();
        this.responseFeedDto = new ResponseFeedDto();
    }
}
