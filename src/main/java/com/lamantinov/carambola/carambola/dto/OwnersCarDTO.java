package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.entity.Owner;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnersCarDTO {
    private Car car;

    public static OwnersCarDTO of(Owner owner) {
        return new OwnersCarDTO(
            owner.getCar()
        );
    }
}
