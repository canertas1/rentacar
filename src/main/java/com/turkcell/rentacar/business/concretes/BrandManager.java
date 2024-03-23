package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

   private final BrandRepository brandRepository;
   private final ModelMapperService modelMapperService;
   private final BrandBusinessRules brandBusinessRules;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDublicated(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand = this.brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse =
                this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);

        return createdBrandResponse;

    }

    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest){

        brandBusinessRules.brandNameCanNotBeDublicated(updateBrandRequest.getName());
        brandBusinessRules.brandIdCanNotFound(updateBrandRequest.getId());

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brand.setUpdatedDate(LocalDateTime.now());
        brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand,UpdatedBrandResponse.class);
    }

    public List<GotBrandResponse> getAll(){

        List<Brand> brands = brandRepository.findAll();

       return brands.stream()
               .map(brand -> modelMapperService.forResponse().
                       map(brand,GotBrandResponse.class)).collect(Collectors.toList());

    }

    public DeletedBrandResponse delete(int id){

        brandBusinessRules.brandIdCanNotFound(id);

        Brand deletedBrand = this.brandRepository.findById(id).get();
        this.brandRepository.deleteById(id);

        DeletedBrandResponse deletedBrandResponse = this.modelMapperService
                .forResponse().map(deletedBrand,DeletedBrandResponse.class);

        return deletedBrandResponse;
    }






}
