package com.estivman.physics_proyect.physics_simulator.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estivman.physics_proyect.physics_simulator.models.Material;
import com.estivman.physics_proyect.physics_simulator.utils.ExpansionTypeEnum;
import com.estivman.physics_proyect.physics_simulator.utils.MaterialJsonReader;
import com.estivman.physics_proyect.physics_simulator.utils.SearchElement;

@Service
public class ThermalExpansionService implements IThermalExpansionService {
    private List<Material> solidMaterialsList;
    private List<Material> liquidMaterialsList;

    public ThermalExpansionService() {
        MaterialJsonReader materialJsonReader = new MaterialJsonReader();
        this.solidMaterialsList = materialJsonReader.loadSolidMaterials();
        this.liquidMaterialsList = materialJsonReader.loadLiquidMaterials();
    }

    @Override
    public Material searchSolidElement(String solidMaterialName) {
       return SearchElement.searchElement(solidMaterialName, solidMaterialsList);
    }

    @Override
    public Material searchLiquidElement(String liquidMaterialName) {
               return SearchElement.searchElement(liquidMaterialName, solidMaterialsList);
    }


    @Override
    public String calcExpansion(String materialName, ExpansionTypeEnum expansionType, double initialTemperature,
            double finalTemperature, double initialDimension) {
        String expansionResult = searchSolidElement(materialName).calculateExpansion(expansionType, initialTemperature,
                finalTemperature, initialDimension);
        return expansionResult;
    }

    @Override
    public String[] calculateCompositeSystemExpansion(String solidMaterialName, double solidInitialTemperature,
            double solidFinalTemperature, double solidInitialDimension,
            String liquidMaterialName, double liquidInitialTemperature, double liquidFinalTemperature,
            double liquidInitialDimension) {

        String[] expansionResults = new String[3];
        // Liquid expansion, at String[0].
        expansionResults[0] = searchLiquidElement(liquidMaterialName).calculateExpansion(ExpansionTypeEnum.VOLUMETRIC,liquidInitialTemperature,liquidFinalTemperature,liquidInitialDimension);
        // Solid expansion, at String[1].
        expansionResults[1] = calcExpansion(solidMaterialName, ExpansionTypeEnum.VOLUMETRIC, solidInitialTemperature,
                solidFinalTemperature, solidInitialDimension);
        // Liquid spilled, at String[2].
        expansionResults[3] = Integer.parseInt(expansionResults[0])+liquidInitialDimension > Integer.parseInt(expansionResults[1])+solidInitialDimension ? (""+ (Integer.parseInt(expansionResults[0])+liquidInitialDimension - Integer.parseInt(expansionResults[1])+solidInitialDimension)): "0";
        return expansionResults;
    }

    public List<Material> getSolidMaterialsList() {
        return solidMaterialsList;
    }

    public List <Material> getLiquidMaterialsList() {
        return liquidMaterialsList;
    }
}
