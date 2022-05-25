package com.lamantinov.carambola.carambola.features.cars.dto;

import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarIntoShopsDTO {
    private int id;
    private String brand;
    private List<ShopWithoutCarsDTO> shopWithoutCarsDTO;

    public static CarIntoShopsDTO of(final Car car) {

        final CarIntoShopsDTO carIntoShopsDTO = new CarIntoShopsDTO();
        carIntoShopsDTO.setId(car.getId());
        carIntoShopsDTO.setBrand(car.getBrand());
        List<ShopWithoutCarsDTO> shopPojoList = car.getShops().stream()
            .map(shop -> ShopWithoutCarsDTO.of(shop))
            .collect(Collectors.toList());

        carIntoShopsDTO.setShopWithoutCarsDTO(shopPojoList);
        return carIntoShopsDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarIntoShopsDTO that = (CarIntoShopsDTO) o;
        return id == that.id && Objects.equals(brand, that.brand) && Objects.equals(shopWithoutCarsDTO, that.shopWithoutCarsDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, shopWithoutCarsDTO);
    }
}
