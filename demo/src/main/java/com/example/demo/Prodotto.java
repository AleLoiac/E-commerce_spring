package com.example.demo;

public class Prodotto {

    private int id;
    private String nome;
    private String descrizione;
    private int quantita;
    private double prezzo;

    public Prodotto(int id, String nome, String descrizione, int quantita, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getDescrizione() {return descrizione;}
    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
    public int getQuantita() {return quantita;}
    public void setQuantita(int quantita) {this.quantita = quantita;}
    public double getPrezzo() {return prezzo;}
    public void setPrezzo(double prezzo) {this.prezzo = prezzo;}
}
