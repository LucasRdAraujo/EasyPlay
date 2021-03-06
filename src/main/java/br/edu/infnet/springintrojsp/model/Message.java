package br.edu.infnet.springintrojsp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_messages")
public class Message {

    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("senderid")
    private String senderid;

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("content")
    private String content;

    public Message() {
    }

    public Message(String id, String senderid, String sender, String content) {
        this.id = id;
        this.senderid = senderid;
        this.sender = sender;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}
