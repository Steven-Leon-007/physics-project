package com.estivman.physics_proyect.physics_simulator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estivman.physics_proyect.physics_simulator.models.Material;
import com.estivman.physics_proyect.physics_simulator.services.ThermalExpansionService;

@RestController
@RequestMapping("/")
public class SimulatorController {

    @Autowired
    private ThermalExpansionService thermalExpansionService;

    @GetMapping()
    public String test() {
        return "test";
    }

    /*
     * Under this line you can add needed endpoints, be careful, I'll let spaces to
     * let you add them, so there's no branch collition, even though better ask
     * before add a new endpoint, I think we just need 4 endpoints (ignoring the
     * load one).
     */

    // Under here first endpoint

    // Under here second endpoint

    // Under here third endpoint
   
    @PostMapping("/calculateCompositeSystem")
    public String[] calculateCompositeSystemExpansion(@RequestBody String solidMaterialName,
            double solidInitialTemperature,
            double solidFinalTemperature, double solidInitialDimension,
            String liquidMaterialName, double liquidInitialTemperature, double liquidFinalTemperature,
            double liquidInitialDimension) {

        // The position 0 in the array equals to the liquid expansion
        // The position 1 in the array equals to the solid expansion
        return thermalExpansionService.calculateCompositeSystemExpansion(solidMaterialName, solidInitialTemperature,
                solidFinalTemperature, solidInitialDimension, liquidMaterialName, liquidInitialTemperature,
                liquidFinalTemperature, liquidInitialDimension);

    }

    @GetMapping("/getSolidMaterials")
    public List<Material> getSolidMaterials() {
        return thermalExpansionService.getSolidMaterialsList();
    }

    @GetMapping("/getLiquidMaterials")
    public List<Material> getLiquidMaterials() {
        return thermalExpansionService.getLiquidMaterialsList();
    }

}
