package org.apache.struts.mangadex.model.manga;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Data {
    String id;
    String type;
    Attributes attributes;
    ArrayList<Relationships> relationships;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Attributes getAttributes() {
        return attributes;
    }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    public ArrayList<Relationships> getRelationships() {
        return relationships;
    }
    public void setRelationships(ArrayList<Relationships> relationships) {
        this.relationships = relationships;
    }
    
    
}
