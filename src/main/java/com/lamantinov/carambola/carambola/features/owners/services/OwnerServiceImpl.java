package com.lamantinov.carambola.carambola.features.owners.services;

import com.lamantinov.carambola.carambola.features.owners.dao.OwnerRepository;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnersCarDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(
        @Autowired OwnerRepository ownerRepository
    ) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public List<OwnerWithoutCarsDTO> getAllWithoutCarsInfo() {
        return ownerRepository.findAll().stream()
            .map(owner -> OwnerWithoutCarsDTO.of(owner))
            .collect(Collectors.toList());
    }

    @Override
    public OwnersCarDTO getOwnersCarById(final int ownerId) {
        final Owner owner = ownerRepository.getById(ownerId);
        return OwnersCarDTO.of(owner);
    }

    @Override
    public void save(final Owner owner) {
        ownerRepository.saveAndFlush(owner);
    }

    @Override
    public Owner getById(final int ownerId) {
        return ownerRepository.getById(ownerId);
    }

    @Override
    public OwnerWithoutCarsDTO getByIdWithoutCar(final int ownerId) {
        final Owner owner = ownerRepository.getById(ownerId);
        return OwnerWithoutCarsDTO.of(owner);
    }

    @Override
    public void delete(final int ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
