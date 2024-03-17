package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    @Override
    public Model add(Model model) {
        return this.modelRepository.save(model);
    }

    @Override
    public Model update(int id, Model model) {
        Model updatedModel = modelRepository.findById(id).get();

        if (updatedModel != null){

            updatedModel.setName(model.getName());
            updatedModel.setUpdatedDate(LocalDateTime.now());

        }
        return this.modelRepository.save(updatedModel);
    }

    @Override
    public List<Model> getAll() {
        return this.modelRepository.findAll();
    }

    @Override
    public void delete(int id) {

        this.modelRepository.deleteById(id);
    }
}
