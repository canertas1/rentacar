package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandBusinessRules {
    private final  BrandRepository brandRepository;


    public void brandNameCanNotBeDublicated(String name){

        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(name);

        if (brand.isPresent()){
            throw new RuntimeException("Brand is exist");
        }


    }

    public void brandIdCanNotFound(int id){
        Optional<Brand> brand = brandRepository.findById(id);
        if(!brand.isPresent()){
            throw new BusinessException("BrandNotExists");
        }
    }






}
