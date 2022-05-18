package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.entity.Shop;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopWithCarsDTO {
    private int id;
    private String shopName;
    private List<CarWithoutShopsDTO> carWithoutShopsDTO;

    public static ShopWithCarsDTO of(Shop shop) {
        ShopWithCarsDTO shopWithCarsDTO = new ShopWithCarsDTO();
        shopWithCarsDTO.setId(shop.getId());
        shopWithCarsDTO.setShopName(shop.getShopName());
        var carPojoList = shop.getCars().stream()
            .map(car -> CarWithoutShopsDTO.of(car))
            .collect(Collectors.toList());

        shopWithCarsDTO.setCarWithoutShopsDTO(carPojoList);
        return shopWithCarsDTO;
    }
}
