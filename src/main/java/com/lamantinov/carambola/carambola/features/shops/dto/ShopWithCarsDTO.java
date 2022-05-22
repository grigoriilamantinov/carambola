package com.lamantinov.carambola.carambola.features.shops.dto;

import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class ShopWithCarsDTO {
    private int id;
    private String shopName;
    private List<CarWithoutShopsDTO> carWithoutShopsDTO;

    public static ShopWithCarsDTO of(final Shop shop) {
        final ShopWithCarsDTO shopWithCarsDTO = new ShopWithCarsDTO();
        shopWithCarsDTO.setId(shop.getId());
        shopWithCarsDTO.setShopName(shop.getShopName());
        var carPojoList = shop.getCars().stream()
            .map(car -> CarWithoutShopsDTO.of(car))
            .collect(Collectors.toList());

        shopWithCarsDTO.setCarWithoutShopsDTO(carPojoList);
        return shopWithCarsDTO;
    }
}
