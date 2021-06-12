package br.edu.infnet.springintrojsp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_messages")
public class Message {

    @Id
    private String id;

    private String content;

    public Message() {
    }

    public Message(String id, String content) {
        super();
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
