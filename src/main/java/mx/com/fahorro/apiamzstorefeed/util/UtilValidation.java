package mx.com.fahorro.apiamzstorefeed.util;

import mx.com.fahorro.apiamzstorefeed.exception.ExceptionInvalidRequest;
import mx.com.fahorro.apiamzstorefeed.model.dto.RequestBranchDto;
import mx.com.fahorro.apiamzstorefeed.model.dto.RequestBranchListDto;

public class UtilValidation {


    public static void validRequest(RequestBranchDto requestBranchDto) throws ExceptionInvalidRequest {

        if(requestBranchDto.getId().isEmpty() || requestBranchDto.getId() == null){
            throw new ExceptionInvalidRequest("Parametro 'id' invalido");
        }

        if(requestBranchDto.getAccessPointId().isEmpty() || requestBranchDto.getAccessPointId() == null){
            throw new ExceptionInvalidRequest("Parametro 'AccessPointId' invalido");
        }

        if(requestBranchDto.getActive().isEmpty() || requestBranchDto.getActive() == null){
            throw new ExceptionInvalidRequest("Parametro 'active' invalido");
        }

        if(requestBranchDto.getName().isEmpty() || requestBranchDto.getName() == null){
            throw new ExceptionInvalidRequest("Parametro 'name' invalido");
        }

        if(requestBranchDto.getCapacity().isEmpty() || requestBranchDto.getCapacity() == null){
            throw new ExceptionInvalidRequest("Parametro 'Capacity' invalido");
        }

        if(requestBranchDto.getScheduleList().isEmpty() ){
            throw new ExceptionInvalidRequest("Parametro 'ScheduleList' invalido");
        }

    }

    public static void validRequest(RequestBranchListDto requestListBranchDto) throws ExceptionInvalidRequest {

        for(RequestBranchDto requestBranchDto : requestListBranchDto.getFeeds()){

            if(requestBranchDto.getAccessPointId().isEmpty() || requestBranchDto.getAccessPointId() == null
                || requestBranchDto.getAccessPointId().length() != 7 || !requestBranchDto.getAccessPointId().contains("FA")){
                throw new ExceptionInvalidRequest("Parámetro 'AccessPointId' inválido");
            }
        }

    }
}
