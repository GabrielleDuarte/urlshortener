package com.logique.urlencrypter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    @NotBlank
    private String userName;
    
    @Column
    @NotBlank
    private String password;
    
    @Column
    private boolean active;
    
    @Column
    @NotBlank
    private String roles;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	private List<URL> createdURLs;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

	public List<URL> getCreatedURLs() {
		return createdURLs;
	}

	public void setCreatedURLs(List<URL> createdURLs) {
		this.createdURLs = createdURLs;
	}

}
