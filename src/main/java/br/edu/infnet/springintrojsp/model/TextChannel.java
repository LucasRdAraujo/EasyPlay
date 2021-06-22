package br.edu.infnet.springintrojsp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_textchannels")
public class TextChannel {

    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("messages")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ch_id", referencedColumnName = "id")
    private Collection<Message> messages = new ArrayList<>();

    public TextChannel() {
    }

    public TextChannel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }

}
