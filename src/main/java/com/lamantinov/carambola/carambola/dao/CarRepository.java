package com.lamantinov.carambola.carambola.dao;

import com.lamantinov.carambola.carambola.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Repository
public interface CarRepository extends JpaRepository <Car, Integer> {
}
