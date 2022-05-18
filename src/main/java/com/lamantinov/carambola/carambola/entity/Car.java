package com.lamantinov.carambola.carambola.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year_of_produce")
    private int yearOfProduce;

    @Column(name = "net_worth")
    private int netWorth;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "cars_shops",
        joinColumns = @JoinColumn(name = "car_id"),
        inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private List<Shop> shops;

    public Car(int id, String brand, int yearOfProduce, int netWorth) {
        this.id = id;
        this.brand = brand;
        this.yearOfProduce = yearOfProduce;
        this.netWorth = netWorth;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", yearOfProduce=" + yearOfProduce +
            ", netWorth=" + netWorth +
            '}';
    }
}
