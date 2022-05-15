package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.entity.Owner;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnersWithoutCarsDTO {
    private int id;
    private String firstName;
    private String lastName;

    public static OwnersWithoutCarsDTO of(Owner owner) {
        return new OwnersWithoutCarsDTO(
            owner.getId(),
            owner.getFirstName(),
            owner.getLastName()
        );
    }
}
