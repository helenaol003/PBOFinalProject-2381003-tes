module EventPesertaManagement {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;
    requires javafx.fxml;
    requires javafx.controls;

    opens event.management.entities;
    opens event.management.repositories;
    opens event.management.services;
    opens event.management.views;
    opens event.management.config;
}