package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Shop;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopWithoutCarsDTO {
    private int id;
    private String shopName;
    private String address;
    private String phone;
    private String email;

    public static ShopWithoutCarsDTO of(Shop shop) {
        return new ShopWithoutCarsDTO(
            shop.getId(),
            shop.getShopName(),
            shop.getAddress(),
            shop.getPhone(),
            shop.getEmail()
        );
    }
}
