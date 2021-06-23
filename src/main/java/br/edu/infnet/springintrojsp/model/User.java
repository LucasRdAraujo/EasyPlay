package br.edu.infnet.springintrojsp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePicture;

<<<<<<< HEAD
<<<<<<< HEAD
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
=======
    @ManyToMany(fetch = FetchType.EAGER)
>>>>>>> parent of 661f2b4 (Corrigindo erros)
=======
    @ManyToMany(fetch = FetchType.EAGER)
>>>>>>> parent of 661f2b4 (Corrigindo erros)
    private Collection<Server> servers = new ArrayList<>();

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Collection<Server> getServers() {
        return servers;
    }

    public void setServers(Collection<Server> servers) {
        this.servers = servers;
    }
    
}

// package br.edu.infnet.springintrojsp.model;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Set;

// import javax.persistence.CascadeType;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// import javax.persistence.Table;
// import javax.persistence.UniqueConstraint;

// import com.fasterxml.jackson.annotation.JsonProperty;

// @Entity
// @Table(name = "tbl_users", uniqueConstraints = @UniqueConstraint(columnNames
// = "email"))
// public class User {

// @JsonProperty("id")
// @Id
// private String id;

// @JsonProperty("username")
// private String username;

// @JsonProperty("email")
// private String email;

// @JsonProperty("password")
// private String password;

// @JsonProperty("phoneNumber")
// private String phoneNumber;

// @JsonProperty("profilePicture")
// private String profilePicture;

// @JsonProperty("servers")
// @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
// @JoinTable(name = "user_server", joinColumns = @JoinColumn(name = "user_id"),
// inverseJoinColumns = @JoinColumn(name = "server_id"))
// private Collection<Server> servers = new ArrayList<>();

// // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
// // @JoinTable(name = "requester_receiver", joinColumns = @JoinColumn(name =
// "requester_id"), inverseJoinColumns = @JoinColumn(name = "receiver_id"))
// // private Collection<User> friends = new ArrayList<>();

// // @OneToMany(mappedBy = "requester")
// // private Collection<Friendship> requests = new ArrayList<>();

// // @OneToMany(mappedBy = "receiver")
// // private Collection<Friendship> friends = new ArrayList<>();

// public User() {
// }

// public User(String id, String username, String email, String password) {
// this.id = id;
// this.username = username;
// this.email = email;
// this.password = password;
// }

// public String getId() {
// return id;
// }

// public void setId(String id) {
// this.id = id;
// }

// public String getUsername() {
// return username;
// }

// public void setUsername(String username) {
// this.username = username;
// }

// public String getEmail() {
// return email;
// }

// public void setEmail(String email) {
// this.email = email;
// }

// public String getPassword() {
// return password;
// }

// public void setPassword(String password) {
// this.password = password;
// }

// public String getPhoneNumber() {
// return phoneNumber;
// }

// public void setPhoneNumber(String phoneNumber) {
// this.phoneNumber = phoneNumber;
// }

// public String getProfilePicture() {
// return profilePicture;
// }

// public void setProfilePicture(String profilePicture) {
// this.profilePicture = profilePicture;
// }

// public Collection<Server> getServers() {
// return servers;
// }

// public Server getServerById(String id) {
// return servers.stream().filter(s ->
// s.getId().equals(id)).findAny().orElse(null);
// }

// public void setServers(Set<Server> servers) {
// this.servers = servers;
// }

// }
