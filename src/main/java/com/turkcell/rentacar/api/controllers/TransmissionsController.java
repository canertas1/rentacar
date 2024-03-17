package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {
    private final TransmissionService transmissionService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Transmission add(@RequestBody Transmission transmission){

        return transmissionService.add(transmission);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Transmission> getAll(){

        return transmissionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){

        transmissionService.delete(id);
    }

    @PostMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transmission update(@PathVariable int id, @RequestBody Transmission transmission){

        return this.transmissionService.update(id,transmission);

    }


}
