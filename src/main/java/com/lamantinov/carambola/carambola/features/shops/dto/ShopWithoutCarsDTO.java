package com.lamantinov.carambola.carambola.features.shops.dto;

import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
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

    public static ShopWithoutCarsDTO of(final Shop shop) {
        return new ShopWithoutCarsDTO(
            shop.getId(),
            shop.getShopName(),
            shop.getAddress(),
            shop.getPhone(),
            shop.getEmail()
        );
    }
}
