package com.Sydorenko.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
/** This class is the entry point of the application.
 * Aside from it defines the application run method
 * it also provides means for additional application
 * configuration. The annotation describes the class
 * as the one can be automatically configured by
 * Spring Boot and enables automatic components
 * scanning for registering them in the Spring
 * application context. The components should be marked
 * with the appropriate annotations.
 * @author Oleksandr Sydorenko
 */

@Entity
@Table(name = "orders", schema = "store")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String address;
    @Column
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private List<OrderItems> orderItems;

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public User getUser () {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public Date getDate () {
        return date;
    }

    public void setDate ( Date date ) {
        this.date = date;
    }

    public List<OrderItems> getOrderItems () {
        return orderItems;
    }

    public void setOrderItems ( List<OrderItems> orderItems ) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString () {
        return "Orders{" +
                "id=" + id +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}
