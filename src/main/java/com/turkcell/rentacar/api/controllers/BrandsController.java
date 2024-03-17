package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand add(Brand brand){

        return brandService.add(brand);

    }

}
