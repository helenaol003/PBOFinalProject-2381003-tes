package services;

import entities.EventList;
import entities.PesertaList;

import java.util.ArrayList;

public interface PesertaService {
    void addPeserta(String nama, String nim, EventList event);
    void removePeserta(String nim);
    ArrayList<PesertaList> getAllPeserta();
    PesertaList findPesertaByNim(String nim);
    ArrayList<PesertaList> findPesertaByEvent(EventList event);
    void displayPesertaDetails(String nim);
}
