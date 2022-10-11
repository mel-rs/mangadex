package org.apache.struts.mangadex.model.manga;

/**
 * Model class that stores a message.
 * @author Bruce Phillips
 *
 */
public class MessageStore {
    
    private String message;
    
    public MessageStore() {
        message = "Hello Struts User";
    }

    public String getMessage() {
        return message;
    }

}
