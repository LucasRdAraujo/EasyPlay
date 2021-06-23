package br.edu.infnet.springintrojsp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_servers")
public class Server {
    @JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ownerId")
    private String ownerId;

    @JsonProperty("serverBanner")
    private String serverBanner;

    @JsonProperty("members")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "server_id", referencedColumnName = "id")
    private Collection<Member> members = new ArrayList<>();

    @JsonProperty("categories")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "server_id", referencedColumnName = "id")
    private Collection<Category> categories = new ArrayList<>();

    public Server() {
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Collection<Member> getMembers() {
        return members;
    }

    public void setMembers(Collection<Member> members) {
        this.members = members;
    }

    public Boolean memberExists(String id) {
        return members.stream().anyMatch(m -> m.getId().equals(id));
    }

    public TextChannel getTextChannelById(String id) {
        for (Category category : categories) {
            TextChannel txtchannel = category.getTextChannelById(id);
            if (txtchannel != null)
                return txtchannel;
        }
        return null;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public String getServerBanner() {
        return serverBanner;
    }

    public void setServerBanner(String serverBanner) {
        this.serverBanner = serverBanner;
    }

}
