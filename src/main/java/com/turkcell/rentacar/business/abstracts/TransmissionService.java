package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Transmission;

import java.util.List;

public interface TransmissionService {

    Transmission add(Transmission transmission);

    Transmission update(int id,Transmission transmission);
    List<Transmission> getAll();
    void delete(int id);
}
