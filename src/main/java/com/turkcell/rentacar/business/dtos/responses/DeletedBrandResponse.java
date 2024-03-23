package com.turkcell.rentacar.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedBrandResponse {

    private int id;
    private String name;
}
