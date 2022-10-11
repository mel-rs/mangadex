package org.apache.struts.mangadex.model.manga;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Title {
    String en;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
    
}
