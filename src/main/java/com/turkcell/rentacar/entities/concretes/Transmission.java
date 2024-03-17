package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transmissions")
public class Transmission extends BaseEntity {
    private String name;
}
