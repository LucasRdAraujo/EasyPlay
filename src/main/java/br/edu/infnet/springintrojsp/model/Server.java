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

@Entity
@Table(name = "tbl_servers")
public class Server {

    @Id
    private String id;
    
    private String name;

    private String ownerId;

    private String serverBanner;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sv_id", referencedColumnName = "id")
    private Collection<Code> inviteCodes = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "servers")
    private Collection<User> members = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sv_id", referencedColumnName = "id")
    private Collection<Category> categories = new ArrayList<>();

    public Server(){
    }

    public Server(String id, String name) {
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
    
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Collection<User> getMembers() {
        return members;
    }
    
    public void setMembers(Collection<User> members) {
        this.members = members;
    }

    public Collection<Code> getInviteCodes() {
        return inviteCodes;
    }

    public void setInviteCodes(Collection<Code> inviteCodes) {
        this.inviteCodes = inviteCodes;
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
