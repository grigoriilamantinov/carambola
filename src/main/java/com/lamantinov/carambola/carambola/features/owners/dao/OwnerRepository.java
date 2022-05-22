package com.lamantinov.carambola.carambola.features.owners.dao;

import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
