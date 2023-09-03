package com.example.airfrance.services.impl;

import com.example.airfrance.domain.Vehicule;
import com.example.airfrance.repositories.VehicleRepository;
import com.example.airfrance.services.VehicleService;

public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Iterable<Vehicule> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehicleRepository.create(vehicule);
    }

    @Override
    public Vehicule update(int index, Vehicule vehicule) {
        return vehicleRepository.update(index, vehicule);
    }

    @Override
    public void delete(int index) {
        vehicleRepository.delete(index);
    }
}
