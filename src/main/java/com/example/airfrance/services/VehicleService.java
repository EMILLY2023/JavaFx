package com.example.airfrance.services;

import com.example.airfrance.domain.Vehicule;

public interface VehicleService {
    public Iterable<Vehicule> findAll();
    public Vehicule create(Vehicule vehicule);
    public Vehicule update(int index, Vehicule vehicule);
    public void delete(int index);
}
