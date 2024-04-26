package com.estivman.physics_proyect.physics_simulator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // Under here fourth endpoint

}
