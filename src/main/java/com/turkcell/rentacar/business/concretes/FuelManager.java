package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.*;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelManager implements FuelService {
    private final FuelRepository fuelRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {

        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        Fuel createdFuel =  fuelRepository.save(fuel);
        CreatedFuelResponse createdFuelResponse =
                this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);
        return createdFuelResponse;
    }

    @Override
    public UpdatedFuelResponse update(int id, UpdateFuelRequest updateFuelRequest) {
        Fuel updatedFuel = fuelRepository.findById(id).get();

        if (updatedFuel != null){

            updatedFuel.setName(updateFuelRequest.getName());
            updatedFuel.setUpdatedDate(LocalDateTime.now());
            this.fuelRepository.save(updatedFuel);

        }
        UpdatedFuelResponse updatedFuelResponse =
                this.modelMapperService.forResponse().map(updatedFuel,UpdatedFuelResponse.class);


        return updatedFuelResponse;

    }

    @Override
    public List<GotFuelResponse> getAll() {

        List<Fuel> fuels = this.fuelRepository.findAll();


        return fuels.stream().map(fuel -> this.
                modelMapperService.forResponse().map(fuel,GotFuelResponse.class)).
                collect(Collectors.toList());
    }

    @Override
    public DeletedFuelResponse delete(int id) {
        Fuel deletedFuel = this.fuelRepository.findById(id).get();
        DeletedFuelResponse deletedFuelResponse =
                this.modelMapperService.forResponse().map(deletedFuel, DeletedFuelResponse.class);
        this.fuelRepository.delete(deletedFuel);

        return  deletedFuelResponse;
    }
}
