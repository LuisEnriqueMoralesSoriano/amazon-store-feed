package mx.com.fahorro.apiamzstorefeed.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.fahorro.apiamzstorefeed.model.dto.*;

import java.io.IOException;
import java.util.ArrayList;

public class UtilJson {


    public static ResponseFeedDto transformToResponseFeedDto(String response) {
        ResponseFeedDto responseFeedDto     = null;
        ObjectMapper mapper                 = new ObjectMapper();

        try {
         responseFeedDto = mapper.readValue(response, ResponseFeedDto.class);
    } catch (IOException e) {
        e.printStackTrace();
    }
        return responseFeedDto;
    }


    public static ResponseDocumentDto transformToResponseDocumentDto(String response) {
        ResponseDocumentDto responseDocumentDto     = null;
        ObjectMapper mapper                         = new ObjectMapper();

        try {
            responseDocumentDto = mapper.readValue(response, ResponseDocumentDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseDocumentDto;
    }

    public static ResponseBranchListDto transformToBranchListDto(String response){
        ResponseBranchListDto responseBranchListDto = new ResponseBranchListDto();

        ObjectMapper mapper = new ObjectMapper();

        try {
            responseBranchListDto = mapper.readValue(response, ResponseBranchListDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBranchListDto;
    }

    public static AccesPointResponseDto transformToAccespointDto(String response) {
        AccesPointResponseDto accespointDto     = null;
        ObjectMapper mapper                         = new ObjectMapper();

        try {
            accespointDto = mapper.readValue(response, AccesPointResponseDto.class);
            String direccion = accespointDto.getAccessPoints().get(0).getAddress().getAddressFieldOne() + " Colonia " +
                    accespointDto.getAccessPoints().get(0).getAddress().getAddressFieldTwo() + " " +
                    accespointDto.getAccessPoints().get(0).getAddress().getCity() + " " +
                    accespointDto.getAccessPoints().get(0).getAddress().getRegion();

            accespointDto.getAccessPoints().get(0).getAddress().setAddressFieldOne(direccion);
            accespointDto.getAccessPoints().get(0).getAddress().setAddressFieldTwo(null);
            accespointDto.getAccessPoints().get(0).getAddress().setCity(null);
            accespointDto.getAccessPoints().get(0).getAddress().setRegion(null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return accespointDto;
    }



    public static String transformAccespointDtoToJson(AccesPointResponseDto accespointDto ){
        ObjectMapper mapper                         = new ObjectMapper();
        String response = "";

        try {
            response = mapper.writeValueAsString(accespointDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;

    }

    public static String transformAccPointDtoToJson(ArrayList<AccespointDto> accesspointsDto){

        AccesPointResponseDto accesPointResponseDtos = new AccesPointResponseDto();
        accesPointResponseDtos.setAccessPoints(accesspointsDto);

        ObjectMapper mapper                         = new ObjectMapper();
        String response = "";

        try {
            response = mapper.writeValueAsString(accesPointResponseDtos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }
}
