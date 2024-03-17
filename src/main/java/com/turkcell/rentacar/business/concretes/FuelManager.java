package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelManager implements FuelService {
    private final FuelRepository fuelRepository;
    @Override
    public Fuel add(Fuel fuel) {
        return this.fuelRepository.save(fuel);
    }

    @Override
    public Fuel update(int id, Fuel fuel) {
        Fuel updatedFuel = fuelRepository.findById(id).get();

        if (updatedFuel != null){

            updatedFuel.setName(fuel.getName());
            updatedFuel.setUpdatedDate(LocalDateTime.now());

        }
        return this.fuelRepository.save(updatedFuel);

    }

    @Override
    public List<Fuel> getAll() {
        return this.fuelRepository.findAll();
    }

    @Override
    public void delete(int id) {

        this.fuelRepository.deleteById(id);
    }
}
