package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionManager implements TransmissionService {

    private final TransmissionRepository transmissionRepository;

    @Override
    public Transmission add(Transmission transmission) {
        return this.transmissionRepository.save(transmission);
    }

    @Override
    public Transmission update(int id, Transmission transmission) {

        Transmission updatedTransmission = transmissionRepository.findById(id).get();

        if (updatedTransmission != null){

            updatedTransmission.setName(transmission.getName());
            updatedTransmission.setUpdatedDate(LocalDateTime.now());

        }
        return this.transmissionRepository.save(updatedTransmission);
    }

    @Override
    public List<Transmission> getAll() {
        return this.transmissionRepository.findAll();
    }

    @Override
    public void delete(int id) {

        this.transmissionRepository.deleteById(id);
    }

}
