package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {

    Model add(Model model);

    Model update(int id,Model model);

    List<Model> getAll();

    void delete(int id);
}
