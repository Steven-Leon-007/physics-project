package com.estivman.physics_proyect.physics_simulator.models;

import com.estivman.physics_proyect.physics_simulator.utils.ExpansionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Material implements IMaterial{
    private String name;
    private String thermalExpansionCoefficient;
    private String texturePath;
    private String materialImagePath;

    
    @Override
    public String calculateExpansion(ExpansionTypeEnum ExpansionType, double initialTemperature,
            double finalTemperature, double initialDimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateExpansion'");
    }
}
