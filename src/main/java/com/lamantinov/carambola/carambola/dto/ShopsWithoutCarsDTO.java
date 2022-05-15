package com.lamantinov.carambola.carambola.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lamantinov.carambola.carambola.entity.Shop;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopsWithoutCarsDTO {
    private int id;
    private String shopName;
    private String address;
    private String phone;
    private String email;

    public static ShopsWithoutCarsDTO of(Shop shop) {
        return new ShopsWithoutCarsDTO(
            shop.getId(),
            shop.getShopName(),
            shop.getAddress(),
            shop.getPhone(),
            shop.getEmail()
        );
    }
}
