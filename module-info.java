module EventPesertaManagement {
    requires spring.context;
    requires spring.beans;
    requires java.sql;
    requires org.slf4j;
    requires javafx.fxml;
    requires javafx.controls;
    requires jdk.jfr;

    opens entities;
    opens repositories;
    opens services;
    opens views;
    opens config;
}