package com.Sydorenko.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", schema = "store")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String address;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",schema = "store",joinColumns =@JoinColumn(name = "user_id") )
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Orders> orders;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public Set<Role> getRoles () {
        return roles;
    }

    public void setRoles ( Set<Role> roles ) {
        this.roles = roles;
    }

    public List<Orders> getOrders () {
        return orders;
    }

    public void setOrders ( List<Orders> orders ) {
        this.orders = orders;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", roles=" + roles +
                ", orders=" + orders +
                '}';
    }
}
