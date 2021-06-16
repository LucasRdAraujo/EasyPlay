package br.edu.infnet.springintrojsp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_messages")
public class Message {

    @Id
    private String id;
    private String ch_id;
    private String content;
    private String sender;

    public Message() {
    }

    // public Message(String id, String content) {
    //     super();
    //     this.id = id;
    //     this.content = content;
    // }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCh_id() {
        return ch_id;
    }

    public void setCh_id(String ch_id) {
        this.ch_id = ch_id;
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
