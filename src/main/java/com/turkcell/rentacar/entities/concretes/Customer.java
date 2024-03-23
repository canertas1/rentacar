package com.turkcell.rentacar.entities.concretes;


import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private double findexScore;
    private String phoneNumber;
    private String eMail;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;


}