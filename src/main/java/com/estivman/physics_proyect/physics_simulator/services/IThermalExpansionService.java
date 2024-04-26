package com.estivman.physics_proyect.physics_simulator.services;

import com.estivman.physics_proyect.physics_simulator.models.Material;
import com.estivman.physics_proyect.physics_simulator.utils.ExpansionTypeEnum;

public interface IThermalExpansionService {
    public Material searchElement(String materialName);

    public String calcExpansion(String materialName, ExpansionTypeEnum expansionType, double initialTemperature,
            double finalTemperature, double initialDimension, double finalDimension);

    // Here should be the method for composed systems, but I'll let that to the
    // person who must do it :D
}
