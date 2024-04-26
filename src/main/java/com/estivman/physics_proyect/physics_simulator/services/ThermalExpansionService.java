package com.estivman.physics_proyect.physics_simulator.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.estivman.physics_proyect.physics_simulator.models.Material;
import com.estivman.physics_proyect.physics_simulator.utils.ExpansionTypeEnum;

@Service
public class ThermalExpansionService implements IThermalExpansionService {
    private List<Material> materialsList = new ArrayList<Material>();

    @Override
    public Material searchElement(String materialName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchElement'");
    }

    @Override
    public String calcExpansion(String materialName, ExpansionTypeEnum expansionType, double initialTemperature,
            double finalTemperature, double initialDimension, double finalDimension) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcExpansion'");
    }
}
