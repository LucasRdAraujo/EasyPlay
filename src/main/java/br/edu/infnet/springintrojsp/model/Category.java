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
@Table(name = "tbl_categories")
public class Category {

    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("textchannels")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Collection<TextChannel> textchannels = new ArrayList<>();

    public Category() {
    }

    public Category(String id, String name) {
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

    public Collection<TextChannel> getTextchannels() {
        return textchannels;
    }

    public TextChannel getTextChannelById(String id) {
        return textchannels.stream().filter(tc -> tc.getId().equals(id)).findAny().orElse(null);
    }

    public void setTextchannels(Collection<TextChannel> textchannels) {
        this.textchannels = textchannels;
    }

}
