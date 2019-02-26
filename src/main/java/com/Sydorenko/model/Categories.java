package com.Sydorenko.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories", schema = "store")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Furnitures> furnitures;

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory ( String category ) {
        this.category = category;
    }

    public List<Furnitures> getFurnitures () {
        return furnitures;
    }

    public void setFurnitures ( List<Furnitures> furnitures ) {
        this.furnitures = furnitures;
    }

    @Override
    public String toString () {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
