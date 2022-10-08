package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DemoService {

    private DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public boolean aggiungiProdotto(int id, String nome, String descrizione, int quantita, double prezzo) {
    try {
        demoRepository.aggiungiProdotto(id, nome, descrizione, quantita, prezzo);
    } catch (SQLException e) {
        System.out.println("Prodotto già esistente");
        return false;
    }
        return true;
    }

    public boolean rimuoviProdotto(int id) {
        try {
            demoRepository.rimuoviProdotto(id);
        } catch (SQLException e) {
            System.out.println("Prodotto non esistente");
            return false;
        }
        return true;
    }
}


