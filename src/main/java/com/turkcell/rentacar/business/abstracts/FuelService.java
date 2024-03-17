package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Fuel;

import java.util.List;

public interface FuelService {

    Fuel add(Fuel fuel);

    Fuel update(int id,Fuel fuel);

    List<Fuel> getAll();

    void delete(int id);

}
