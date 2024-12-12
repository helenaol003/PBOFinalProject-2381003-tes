module EventPesertaManagement {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;
    requires javafx.fxml;
    requires javafx.controls;

    opens eventPesertaApp.entities;
    opens eventPesertaApp.repositories;
    opens eventPesertaApp.services;
    opens eventPesertaApp.views;
    opens eventPesertaApp;
    opens eventPesertaApp.config;
}