package com.Sydorenko.model;

import javax.persistence.*;
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
@Table(name = "orders_item",schema = "store")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="order_id")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="furniture_id" )
    private Furnitures furnitures;

    @Column
    private int quantity;

    @Column
    private int price;

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public Orders getOrders () {
        return orders;
    }

    public void setOrders ( Orders orders ) {
        this.orders = orders;
    }

    public Furnitures getFurnitures () {
        return furnitures;
    }

    public void setFurnitures ( Furnitures furnitures ) {
        this.furnitures = furnitures;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity ( int quantity ) {
        this.quantity = quantity;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice ( int price ) {
        this.price = price;
    }

    @Override
    public String toString () {
        return "OrderItems{" +
                "id=" + id +
                ", orders=" + orders +
                ", furnitures=" + furnitures +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
