package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Owner;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerWithoutCarsDTO {
    private int id;
    private String firstName;
    private String lastName;

    public static OwnerWithoutCarsDTO of(Owner owner) {
        return new OwnerWithoutCarsDTO(
            owner.getId(),
            owner.getFirstName(),
            owner.getLastName()
        );
    }
}
