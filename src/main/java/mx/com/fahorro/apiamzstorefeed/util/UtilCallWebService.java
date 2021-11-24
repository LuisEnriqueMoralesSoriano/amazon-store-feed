package mx.com.fahorro.apiamzstorefeed.util;

import mx.com.fahorro.apiamzstorefeed.exception.ExceptionConnectionWebService;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UtilCallWebService {

    protected static final Logger LOG = Logger.getLogger(UtilCallWebService.class.getName());


    public static String POSTRequestAccesToken(String url) throws IOException, ExceptionConnectionWebService {
        String result = "";
        String message = UtilRequest.createMessageToken();

        System.out.println(message);
        URL obj = new URL(url);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");

        System.out.println("<--------------------------------------------->");
        System.out.println("url" + url);

        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(message.getBytes());
        os.flush();
        os.close();

        int responseCode = postConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            JSONObject myResponse = new JSONObject(response.toString());
            //System.out.println("<--------------------------------------------->");
            //System.out.println("access_token- "+myResponse.getString("access_token"));
            result = myResponse.getString("access_token");

        } else {
            //System.out.println("POSTRequestAccesToken NOT WORKED");
            throw new ExceptionConnectionWebService("POSTRequestAccesToken NOT WORKED");
        }

        return result;
    }


    public static String POSTRequestRegistryBranch(String url, String authorization, String message) throws IOException, ExceptionConnectionWebService {
        String result = "";

        URL obj = new URL(url);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");

        postConnection.setRequestProperty("Authorization", "Bearer " + authorization);
        postConnection.setRequestProperty("Accept", "application/json");
        postConnection.setRequestProperty("Content-Type", "application/json");

//        System.out.println("<--------------------------------------------->");
//        System.out.println("url" + url);

        LOG.info("<--------------------------------------------->");
        LOG.info("url" + url);

        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(message.getBytes());
        os.flush();
        os.close();

        int responseCode = postConnection.getResponseCode();
//        System.out.println("responseCode--> " + responseCode);
        LOG.info("responseCode--> " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject myResponse = new JSONObject(response.toString());
            result = myResponse.getString("feedId");

        } else {
            //System.out.println("POSTRequestRegistryBranch NOT WORKED");
            throw new ExceptionConnectionWebService("POSTRequestRegistryBranch NOT WORKED");
        }

        return result;
    }

    public static String GETRequest(String url, String authorization) throws Exception {

        StringBuilder response = null;

        try {

            HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();


            httpClient.setRequestMethod("GET");
            httpClient.setRequestProperty("Authorization", "Bearer " + authorization);

            int responseCode = httpClient.getResponseCode();
//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
            LOG.info("\nSending 'GET' request to URL : " + url);
            LOG.info("Response Code : " + responseCode);

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {

                response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                //print result
//                System.out.println(response.toString());
                LOG.info(response.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }


//    public static String GETRequestFeedInfo(RequestStatusDto requestStatusDto, String url, String authorization) throws Exception {
//
//        String urlComplete = url+ requestStatusDto.getFeedId();
//
//        HttpURLConnection httpClient = (HttpURLConnection) new URL(urlComplete).openConnection();
//
//        httpClient.setRequestMethod("GET");
//        httpClient.setRequestProperty("Authorization", "Bearer "+ authorization);
//
//        int responseCode = httpClient.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + urlComplete);
//        System.out.println("Response Code : " + responseCode);
//
//        try (BufferedReader in = new BufferedReader(
//                new InputStreamReader(httpClient.getInputStream()))) {
//
//            StringBuilder response = new StringBuilder();
//            String line;
//
//            while ((line = in.readLine()) != null) {
//                response.append(line);
//            }
//
//            //print result
//            System.out.println(response.toString());
//            ResponseFeedDto dto =UtilJson.transformToResponseFeedDto(response.toString());
//
//        }
//            return "vemos";
//    }


}
