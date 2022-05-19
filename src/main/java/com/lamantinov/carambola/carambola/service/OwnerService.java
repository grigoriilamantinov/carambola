package com.lamantinov.carambola.carambola.service;

import com.lamantinov.carambola.carambola.dao.OwnerRepository;
import com.lamantinov.carambola.carambola.dto.OwnersCarDTO;
import com.lamantinov.carambola.carambola.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService implements ServiceInterface<Owner> {

    private final OwnerRepository ownerRepository;

    public OwnerService(
        @Autowired OwnerRepository ownerRepository
    ) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public List<OwnerWithoutCarsDTO> getAllWithoutCarsInfo() {
        return ownerRepository.findAll().stream()
            .map(owner -> OwnerWithoutCarsDTO.of(owner))
            .collect(Collectors.toList());
    }

    public OwnersCarDTO getOwnersCarById(int ownerId) {
        Owner owner = ownerRepository.getById(ownerId);
        return OwnersCarDTO.of(owner);
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.saveAndFlush(owner);
    }

    @Override
    public Owner getById(int ownerId) {
        return ownerRepository.getById(ownerId);
    }

    public OwnerWithoutCarsDTO getByIdWithoutCar(int ownerId) {
        Owner owner = ownerRepository.getById(ownerId);
        return OwnerWithoutCarsDTO.of(owner);
    }

    @Override
    public void delete(int ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
