package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedBrandResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @PostMapping("/add")
    public ResponseEntity<CreatedBrandResponse> add(@Valid @RequestBody CreateBrandRequest createBrandRequest){

        return new ResponseEntity<>(this.brandService.add(createBrandRequest),HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GotBrandResponse>> getAll(){

        return new ResponseEntity<>(this.brandService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeletedBrandResponse> delete(@PathVariable int id){

        return new ResponseEntity<>(this.brandService.delete(id),HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UpdatedBrandResponse> update(@RequestBody UpdateBrandRequest updateBrandRequest){

        return new ResponseEntity<>(this.brandService.update(updateBrandRequest),HttpStatus.OK);


    }


}
