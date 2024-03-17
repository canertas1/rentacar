package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fuels")
@RequiredArgsConstructor
public class FuelsController {
    private final FuelService fuelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Fuel add(@RequestBody Fuel fuel){

        return fuelService.add(fuel);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Fuel> getAll(){

        return fuelService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){

        fuelService.delete(id);
    }

    @PostMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fuel update(@PathVariable int id, @RequestBody Fuel fuel){

        return this.fuelService.update(id,fuel);

    }
}
