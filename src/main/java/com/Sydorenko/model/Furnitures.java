package com.Sydorenko.model;

import javax.persistence.*;
import java.util.List;

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
