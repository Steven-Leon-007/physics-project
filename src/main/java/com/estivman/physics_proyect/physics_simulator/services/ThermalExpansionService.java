package com.estivman.physics_proyect.physics_simulator.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.estivman.physics_proyect.physics_simulator.models.Material;
import com.estivman.physics_proyect.physics_simulator.utils.ExpansionTypeEnum;

@Service
public class ThermalExpansionService implements IThermalExpansionService {
    private List<Material> materialsList;

    public ThermalExpansionService() {
        //Here should be the logic of loading the list of materials from JSON Files. 
        materialsList = new ArrayList<Material>();
    }

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

    @Override
    public String[] calculateCompositeSystemExpansion(String solidMaterialName, double solidInitialTemperature,
            double solidFinalTemperature, double solidInitialDimension,
            String liquidMaterialName, double liquidInitialTemperature, double liquidFinalTemperature,
            double liquidInitialDimension) {

                String [] expansionResults = new String[2];
                //Liquid expansion, at String[0].
                expansionResults[0] = calcExpansion(liquidMaterialName, ExpansionTypeEnum.VOLUMETRIC, liquidInitialTemperature, liquidFinalTemperature, liquidInitialDimension, liquidFinalDimension);
                //Solid expansion, at String[1].
                expansionResults[1] = calcExpansion(solidMaterialName, ExpansionTypeEnum.VOLUMETRIC, solidInitialTemperature, solidFinalTemperature, solidInitialDimension, solidFinalDimension);
                return expansionResults;
            }

    
}
