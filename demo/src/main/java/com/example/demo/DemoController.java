package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/public")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping(value = "/aggiungiProdotto")
    public ResponseEntity<Boolean> aggiungiProdotto(
            @RequestParam int id,
            @RequestParam String nome,
            @RequestParam String descrizione,
            @RequestParam int quantita,
            @RequestParam double prezzo
    )
    {
        boolean success = demoService.aggiungiProdotto(id, nome, descrizione, quantita, prezzo);
        if(success)
            return ResponseEntity.ok(true);
        return ResponseEntity.badRequest().build();
    }
}
