package org.apache.struts.mangadex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.struts.mangadex.model.cover.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Cover {
    
    String uploadUrl = "uploads.mangadex.org/covers/";
    String baseUrl = "api.mangadex.org/cover/";
    Response response;

    public String getCover(String mangaId, String fileName, int size) {
        return uploadUrl + mangaId + "/" + fileName + "." + size + ".jgp";
    }

    public String getFileName(String coverArt) {
        try {
            URL url = new URL(baseUrl + coverArt);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
 
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
 
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                response = mapper.readValue(output, Response.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getData().getAttributes().getFileName();
    }
}
