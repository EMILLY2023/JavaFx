package com.example.airfrance.repositories;

import com.example.airfrance.domain.Vehicule;

public interface VehicleRepository {
    public Iterable<Vehicule> findAll();
    public Vehicule create(Vehicule vehicule);
    public Vehicule update(int index, Vehicule vehicule);
    public void delete(int index);
}
