package com.lamantinov.carambola.carambola.features.owners.services;

import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnersCarDTO;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import com.lamantinov.carambola.carambola.features.common.CarambolaCRUD;

import java.util.List;

public interface OwnerService extends CarambolaCRUD<Owner> {
    List<OwnerWithoutCarsDTO> getAllWithoutCarsInfo();

    OwnersCarDTO getOwnersCarById(int ownerId);

    OwnerWithoutCarsDTO getByIdWithoutCar(int ownerId);
}
