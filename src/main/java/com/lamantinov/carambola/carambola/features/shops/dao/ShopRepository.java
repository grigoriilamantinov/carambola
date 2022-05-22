package com.lamantinov.carambola.carambola.features.shops.dao;

import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
