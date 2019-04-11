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
@Table(name = "categories", schema = "store")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Furnitures> furnitures;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
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
