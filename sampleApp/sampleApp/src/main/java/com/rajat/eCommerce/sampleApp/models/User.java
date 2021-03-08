package com.rajat.eCommerce.sampleApp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();
    
    public User() {
    	
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
