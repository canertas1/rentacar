package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedBrandResponse;

import java.util.List;


public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);

    UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);

    List<GotBrandResponse> getAll();

    DeletedBrandResponse delete(int id);
}
