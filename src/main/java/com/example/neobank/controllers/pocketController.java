package com.example.neobank.controllers;

import com.example.neobank.models.Pocket;
import com.example.neobank.services.PocketService;
import com.example.neobank.util.CastVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pocket")
@CrossOrigin("*")
public class pocketController {
    @Autowired
    PocketService pocketService;

    @GetMapping()
    Pocket getPocket(@RequestParam(name = "id") UUID id){
        return pocketService.getPocketById(id);
    }

    @PostMapping("/create")
    Pocket createPocket(@RequestBody Pocket pocket){
        return pocketService.createPocket(pocket);
    }

    @PutMapping("/update")
    Pocket updatePocket(@RequestBody Pocket pocket){
        return pocketService.updatePocket(pocket);
    }

    @GetMapping("/getPocketBalance")
    Pocket getPocketBalance(@RequestParam("pocket_id") String pocket_id, @RequestParam(name = "balance_id") String balance_id){
        return pocketService.getPocketInBalance(pocket_id,balance_id);
    }

}
