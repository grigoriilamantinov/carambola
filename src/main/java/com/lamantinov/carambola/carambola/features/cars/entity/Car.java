package com.lamantinov.carambola.carambola.features.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@EqualsAndHashCode
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.REFRESH})
    @JoinTable(
        name = "cars_shops",
        joinColumns = @JoinColumn(name = "car_id"),
        inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private List<Shop> shops;

    @OneToOne(
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
        }
    )
    @JoinColumn(name = "id", referencedColumnName = "car_id")
    private Owner owner;

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
