package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {

    private final ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Model add(@RequestBody Model model){

        return modelService.add(model);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Model> getAll(){

        return modelService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){

        modelService.delete(id);
    }

    @PostMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Model update(@PathVariable int id, @RequestBody Model model){

        return this.modelService.update(id,model);

    }


}
