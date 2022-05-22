package com.lamantinov.carambola.carambola.features.owners.dto;

import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OwnerWithoutCarsDTO {
    private int id;
    private String firstName;
    private String lastName;

    public static OwnerWithoutCarsDTO of(final Owner owner) {
        return new OwnerWithoutCarsDTO(
            owner.getId(),
            owner.getFirstName(),
            owner.getLastName()
        );
    }
}
