package br.edu.infnet.easyplayapi.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categories")
public class Category {
    @Id
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Collection<TextChannel> textchannels = new ArrayList<>();

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

    public void setTextchannels(Collection<TextChannel> textchannels) {
        this.textchannels = textchannels;
    }
    
}
