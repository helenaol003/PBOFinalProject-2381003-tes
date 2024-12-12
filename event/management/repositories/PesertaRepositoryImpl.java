package event.management.repositories;

import event.management.config.Database;
import event.management.entities.EventList;
import event.management.entities.PesertaList;

import java.util.ArrayList;


public class PesertaRepositoryImpl implements PesertaRepository {
    @Override
    public ArrayList<PesertaList> getPesertaByEvent(EventList event) {
        return null;
    }

    @Override
    public void addPeserta(PesertaList peserta) {
        Database.pesertaList.add(peserta);
    }

    @Override
    public void removePeserta(PesertaList peserta) {
        Database.pesertaList.remove(peserta);
    }

    @Override
    public PesertaList getPesertaByNim(String nim) {
        for (PesertaList peserta : Database.pesertaList) {
            if (peserta.getNim().equalsIgnoreCase(nim)) {
                return peserta;
            }
        }
        return null;
    }

    @Override
    public ArrayList<PesertaList> getAllPeserta() {
        return Database.pesertaList;
    }
}
