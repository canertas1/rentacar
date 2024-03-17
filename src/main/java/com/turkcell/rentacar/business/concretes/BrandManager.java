package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

   private final BrandRepository brandRepository;
    @Override
    public Brand add(Brand brand) {
        Brand createdBrand = brandRepository.save(brand);
        return createdBrand;

    }
}
