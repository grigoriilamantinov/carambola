package com.lamantinov.carambola.carambola.service;

import com.lamantinov.carambola.carambola.dao.OwnerRepository;
import com.lamantinov.carambola.carambola.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public Owner getById(int id) {
        return ownerRepository.getById(id);
    }

    @Override
    public void delete(int id) {
        ownerRepository.deleteById(id);
    }
}
