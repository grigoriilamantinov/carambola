package com.lamantinov.carambola.carambola.features.owners.dto;

import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OwnersCarDTO {
    private String firstName;
    private String lastName;
    private CarWithoutShopsDTO carWithoutShopsDTO;

    public static OwnersCarDTO of(final Owner owner) {
        return new OwnersCarDTO(
            owner.getFirstName(),
            owner.getLastName(),
            CarWithoutShopsDTO.of(owner.getCar())
        );
    }
}
