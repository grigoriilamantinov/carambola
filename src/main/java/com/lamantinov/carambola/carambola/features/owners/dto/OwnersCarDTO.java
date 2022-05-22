package com.lamantinov.carambola.carambola.features.owners.dto;

import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OwnersCarDTO {
    private Car car;

    public static OwnersCarDTO of(final Owner owner) {
        return new OwnersCarDTO(
            owner.getCar()
        );
    }
}
