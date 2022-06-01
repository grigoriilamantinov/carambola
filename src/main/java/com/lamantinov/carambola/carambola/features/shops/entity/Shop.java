package com.lamantinov.carambola.carambola.features.shops.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Shop(int id, String shopName, String address, String phone, String email) {
        this.id = id;
        this.shopName = shopName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @ManyToMany(
        cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
        },
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "cars_shops",
        joinColumns = @JoinColumn(name = "shop_id"),
        inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars;

    @Override
    public String toString() {
        return "id=" + id +
            ", shopName='" + shopName + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
