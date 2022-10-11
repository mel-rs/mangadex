package org.apache.struts.helloworld.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.struts.helloworld.model.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

    private Response manga;

    public String execute() throws Exception {

        manga = new Response();
        URL url = new URL("https://api.mangadex.org/manga");
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
            manga = mapper.readValue(output, Response.class);
        }
        br.close();
        conn.disconnect();

        // close the connection
        conn.disconnect();
        return SUCCESS;
    }

    public Response getManga() {
        return manga;
    }

    public void setManga(Response manga) {
        this.manga = manga;
    }

}
