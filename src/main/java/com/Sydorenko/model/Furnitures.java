package com.Sydorenko.model;

import javax.persistence.*;
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
@Table(name = "furnitures", schema = "store")
public class Furnitures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Categories categories;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "furnitures")

    private List<OrderItems> orderItems;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice ( int price ) {
        this.price = price;
    }

    public Categories getCategories () {
        return categories;
    }

    public void setCategories ( Categories categories ) {
        this.categories = categories;
    }

    public List<OrderItems> getOrderItems () {
        return orderItems;
    }

    public void setOrderItems ( List<OrderItems> orderItems ) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString () {
        return "Furnitures{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
