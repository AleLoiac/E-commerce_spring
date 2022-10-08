package com.example.demo;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DemoRepository {

    private ConnectionHandler connectionHandler;

    public DemoRepository() throws ClassNotFoundException {
        connectionHandler = new ConnectionHandler(
                ConnectionHandler.DB_URL, "ecommerce", "public", "postgres", "password78");
    }

    public void aggiungiProdotto(int id, String nome, String descrizione, int quantita, double prezzo) throws SQLException {
        PreparedStatement ps = connectionHandler.prepareStatement("insert into prodotto (id, nome, descrizione, quantita, prezzo) values (?, ?, ?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, nome);
        ps.setString(3, descrizione);
        ps.setInt(4, quantita);
        ps.setDouble(5, prezzo);
        int rowsAffected = ps.executeUpdate();
    }

    public void rimuoviProdotto(int id) throws SQLException {
        PreparedStatement ps = connectionHandler.prepareStatement("delete from prodotto where id = ?");
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate();
    }
}
