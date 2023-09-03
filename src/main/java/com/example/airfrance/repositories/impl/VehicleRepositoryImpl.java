package com.example.airfrance.repositories.impl;

import com.example.airfrance.domain.Vehicule;
import com.example.airfrance.repositories.VehicleRepository;
;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {

    private final List<Vehicule> vehicles = new ArrayList<>();

    public VehicleRepositoryImpl() {
        Vehicule vehicle1 = new Vehicule("Toyota", "EJ-884-NF");
        Vehicule vehicle2 = new Vehicule("Honda Civic", "CD5678");
        Vehicule vehicle3 = new Vehicule("Ford Mustang", "EF9012");
        Vehicule vehicle4 = new Vehicule("Chevrolet Malibu", "GH3456");
        Vehicule vehicle5 = new Vehicule("Volkswagen Golf", "IJ7890");

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);


    }

    @Override
    public Iterable<Vehicule> findAll() {

     return vehicles;
    }

    @Override
    public Vehicule create(Vehicule vehicule) {
        vehicles.add(vehicule);
        return vehicule;
    }

    @Override
    public Vehicule update(int index, Vehicule vehicule) {
        vehicles.set(index,vehicule);
        return vehicule;
    }

    @Override
    public void delete(int index) {
    vehicles.remove(index);
    }
}
