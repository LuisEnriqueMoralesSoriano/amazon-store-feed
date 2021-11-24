package mx.com.fahorro.apiamzstorefeed.util;

import mx.com.fahorro.apiamzstorefeed.entity.BranchEntity;
import mx.com.fahorro.apiamzstorefeed.model.dto.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilTransformObject {

    private static final String TIMEZONE_MX             = "America/Mexico_City";
    private static final String COUNTRY_CODE            = "MX";
    private static final String TERMINATION_DATE        = "2199-12-31";
    private static final String CAPABILITIES            = "PICK_UP";

    public static AccespointDto transformListRequest(RequestBranchDto requestBranchDto, BranchEntity branchEntity){

        AccespointDto accespointDto = new AccespointDto();
        ArrayList< AccespointDto > accessPoints = new ArrayList< AccespointDto >();
        CapacityDto capacityDto = new CapacityDto( Integer.parseInt(requestBranchDto.getCapacity()));

        accespointDto.setAccessPointId(requestBranchDto.getAccessPointId());
        accespointDto.setAccessPointName(requestBranchDto.getName());
        accespointDto.setIsActive(Boolean.parseBoolean(requestBranchDto.getActive()));
        accespointDto.setTimeZone(TIMEZONE_MX);
        accespointDto.setCapacity( capacityDto );
        accespointDto.setAddress( generateAddress(branchEntity) );
        accespointDto.setTerminationDate(TERMINATION_DATE );
        accespointDto.setCapabilities( generateCapabilities() );
        accespointDto.setStandardHours(generateStandarHours(requestBranchDto));
        accespointDto.setCommunicationDetails( generateCommunicationDetails(branchEntity, requestBranchDto.getPhoneNumber() ) );
        accespointDto.setClosureExceptionList(requestBranchDto.getClosureExceptionList());
        accespointDto.setLoginClaim(accespointDto.getCommunicationDetails().getEmailId());

        accessPoints.add(accespointDto);

        return accespointDto;
    }


    private static AddressDto  generateAddress( BranchEntity branch ){
        AddressDto address = new AddressDto();

        address.setAddressFieldOne( toCamelCase(branch.getStreet()) + " " + branch.getNumExt());
        address.setAddressFieldTwo(toCamelCase(branch.getSuburb()));
        address.setCity(toCamelCase(branch.getTown()));
        address.setRegion(toCamelCase(branch.getState()));
        address.setPostalCode( branch.getPostalCode());
        address.setCountryCode( COUNTRY_CODE);
        address.setLatitude( branch.getLatitude());
        address.setLongitude( branch.getLength() );

//        address.setAddressFieldOne("CALLE UNO 8");
//        address.setAddressFieldTwo("COLONIA 1");
//        address.setCity("CIUDAD");
//        address.setRegion("REGION");
//        address.setPostalCode("55555");
//        address.setCountryCode( COUNTRY_CODE);
//        address.setLatitude("0");
//        address.setLongitude("0");

        return address;

    }

    private static ArrayList< Object > generateCapabilities(){
        ArrayList< Object > response    = new ArrayList< Object >();

        response.add(CAPABILITIES);

        return response;
    }


    private static CommunicationDetailsDto generateCommunicationDetails( BranchEntity branch, String phoneNumber){
        CommunicationDetailsDto communicationDetails = new CommunicationDetailsDto();
        String telefono = "";

        if(phoneNumber == null || phoneNumber.equals("")){
            telefono = "898152400";
        }else if(!onlyDigits(phoneNumber)){
            telefono = "Invalid number " + phoneNumber;
        }else if(!phoneNumber.equals("") ){
            telefono = phoneNumber;
        }

        communicationDetails.setEmailId( branch.getEmail() );
//        communicationDetails.setEmailId("xxxx@fahorro.com");
        communicationDetails.setPhoneNumber(telefono);

        return communicationDetails;
    }


    private static ArrayList < StandardHoursDto > generateStandarHours( RequestBranchDto requestBranchDto){
        ArrayList < StandardHoursDto > standardHours    = new ArrayList < StandardHoursDto >();
        StandardHoursDto standardHoursDto               = null;

        for(ScheduleDto scheduleDto: requestBranchDto.getScheduleList()){
            standardHoursDto = new StandardHoursDto();
            standardHoursDto.setDay( scheduleDto.getDay());
            standardHoursDto.setOpeningTime( scheduleDto.getOpeningTime());
            standardHoursDto.setClosingTime( scheduleDto.getClosingTime());

            standardHours.add(standardHoursDto);

        }

        return standardHours;

    }

    private static String toCamelCase(final String cadena){
        if(cadena == null){
            return null;
        }

        final StringBuilder response = new StringBuilder(cadena.length());

        for(final String word : cadena.split(" ")){
            if(!word.isEmpty()){
                response.append(Character.toUpperCase(word.charAt(0)));
                response.append(word.substring(1).toLowerCase());
            }
            if(!(response.length() == cadena.length())){
                response.append(" ");
            }
        }

        return response.toString();
    }

    private static boolean onlyDigits(String number){
        String regex = "[0-9]+";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(number);

        return m.matches();

    }

    public static boolean isActive(String isActive){
        boolean getIsActive;

        getIsActive = Boolean.parseBoolean(isActive);

        return getIsActive;
    }
}
