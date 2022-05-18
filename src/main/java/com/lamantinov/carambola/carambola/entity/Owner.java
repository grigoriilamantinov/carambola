package com.lamantinov.carambola.carambola.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("car")
    @OneToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public Owner(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Owner{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName;
    }
}
