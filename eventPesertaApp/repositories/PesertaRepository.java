package eventPesertaApp.repositories;

import eventPesertaApp.entities.EventList;
import eventPesertaApp.entities.PesertaList;

import java.util.ArrayList;

public interface PesertaRepository {
    void addPeserta(PesertaList peserta);
    void removePeserta(PesertaList peserta);
    PesertaList getPesertaByNim(String nim);
    ArrayList<PesertaList> getAllPeserta();
    ArrayList<PesertaList> getPesertaByEvent(EventList event);
}
