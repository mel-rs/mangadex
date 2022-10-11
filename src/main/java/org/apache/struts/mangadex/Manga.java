package org.apache.struts.mangadex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.struts.mangadex.model.manga.Data;
import org.apache.struts.mangadex.model.manga.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Manga {
    
    public Response response;
    public String baseUrl = "api.mangadex.org/manga";

    public List<Data> getManga() {
        try {
            URL url = new URL(baseUrl);
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
        return response.getData();
    }
}
