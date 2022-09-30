package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

    private ConnectionHandler connectionHandler;

    public DemoRepository() throws ClassNotFoundException {
        connectionHandler = new ConnectionHandler(
                ConnectionHandler.DB_URL, "ecommerce", "public", "postgres", "password78");
    }
}
