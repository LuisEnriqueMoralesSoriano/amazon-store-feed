package mx.com.fahorro.apiamzstorefeed.util;

import mx.com.fahorro.apiamzstorefeed.entity.BranchEntity;
import mx.com.fahorro.apiamzstorefeed.model.dto.RequestBranchDto;
import mx.com.fahorro.apiamzstorefeed.model.dto.ScheduleDto;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class UtilRequest {


    public static String createMessageToken(){

        final String message    = "{\n" +
                "\t\"client_id\": \"amzn1.application-oa2-client.a0f22e6aa435497fad209b54f43525aa\",\n" +
                "\t\"client_secret\": \"9f7d341bc563d7ee20e0ad1f874afb566c3a8a393613416f0cf5706dc74e5470\",\n" +
                "\t\"grant_type\": \"client_credentials\",\n" +
                "\t\"scope\": \"accesspoints::accesspoint:readwrite\"\n" +
                "}";

        return message;
    }


    public static String createMessageRegister(RequestBranchDto requestBranchDto, BranchEntity branch){
        String result   = "";

        result = "{\n" +
                "\t\"accessPoints\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"accessPointId\": \"" + requestBranchDto.getAccessPointId() + "\",\n" +
                "\t\t\t\"accessPointName\": \""+ requestBranchDto.getName() +"\",\n" +
                "\t\t\t\"isActive\": "+ requestBranchDto.getActive().toLowerCase()+",\n" +
                "\t\t\t\"timeZone\": \"America/Mexico_City\",\n" +
                "\t\t\t\"capacity\": {\n" +
                "\t\t\t\t\"threshold\":"+ requestBranchDto.getCapacity()+" \n" +
                "\t\t\t\t},\n" +
                "\t\t\t\"address\": {\n" +
                "\t\t\t\t\"addressFieldOne\": \""+ branch.getStreet() +"\",\n" +
                "\t\t\t\t\"addressFieldTwo\": \""+ branch.getSuburb() +"\",\n" +
                "\t\t\t\t\"city\": \""+ branch.getTown()+"\",\n" +
                "\t\t\t\t\"region\": \""+ branch.getState()+"\",\n" +
                "\t\t\t\t\"postalCode\": \""+ branch.getPostalCode()+ "\",\n" +
                "\t\t\t\t\"countryCode\": \"MX\",\n" +
                "\t\t\t\t\"latitude\": \""+ branch.getLatitude() +"\",\n" +
                "\t\t\t\t\"longitude\": \""+ branch.getLength()+"\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"terminationDate\": \"2199-12-31\",\n" +
                "\t\t\t\"capabilities\": [\n" +
                "\t\t\t\t\"PICK_UP\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"standardHours\": [\n" +
                createMessageStandardHours(requestBranchDto.getScheduleList()) +
                "\n\t\t\t],\t\t\t\n" +
                "\t\t\t\"communicationDetails\": {\n" +
                "\t\t\t\t\"phoneNumber\": \"123456789\",\n" +
                "\t\t\t\t\"emailId\": \""+ branch.getEmail()+"\"\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";



        return result;

    }


    public static String createMessageStandardHours(List<ScheduleDto> scheduleList){
            String response = "";

            for(ScheduleDto scheduleDto: scheduleList){
                response   +=  "\t\t\t\t{\n" +
                        "\t\t\t\t\t\"day\": \""+ scheduleDto.getDay()+"\",\n" +
                        "\t\t\t\t\t\"openingTime\": \""+ scheduleDto.getOpeningTime() +"\",\n" +
                        "\t\t\t\t\t\"closingTime\": \""+ scheduleDto.getClosingTime() +"\"\n" +
                        "\t\t\t\t},\n";
            }

        response = removeLastCharacter(response);



        return response;
    }

    public static String removeLastCharacter(String str) {
        String result = StringUtils.substring(str, 0, str.length() - 2);
        return result;
    }
}
