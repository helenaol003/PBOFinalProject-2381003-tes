package services;

import entities.EventList;
import entities.PesertaList;
import repositories.PesertaRepository;

import java.util.ArrayList;

public class PesertaServiceImpl implements PesertaService {
    private final PesertaRepository pesertaRepository;

    public PesertaServiceImpl(PesertaRepository pesertaRepository) {
        this.pesertaRepository = pesertaRepository;
    }

    @Override
    public void addPeserta(String nama, String nim, EventList event) {
        if (nama == null || nim == null || event == null) {
            throw new IllegalArgumentException("Nama, NIM, atau Event tidak boleh kosong");
        }

        PesertaList peserta = new PesertaList(nama, nim, event);
        pesertaRepository.addPeserta(peserta);
        event.addPeserta(peserta);
        System.out.println("Peserta berhasil ditambahkan ke event: " + event.getNameEvent());
    }

    @Override
    public void removePeserta(String nim) {
        PesertaList peserta = pesertaRepository.getPesertaByNim(nim);
        if (peserta != null) {
            peserta.getEventpilih().removePeserta(peserta);
            pesertaRepository.removePeserta(peserta);
            System.out.println("Peserta dengan NIM " + nim + " berhasil dihapus");
        } else {
            System.out.println("Peserta dengan NIM " + nim + " tidak ditemukan");
        }
    }

    @Override
    public ArrayList<PesertaList> getAllPeserta() {
        return pesertaRepository.getAllPeserta();
    }

    @Override
    public PesertaList findPesertaByNim(String nim) {
        PesertaList peserta = pesertaRepository.getPesertaByNim(nim);
        if (peserta == null) {
            System.out.println("Peserta dengan NIM " + nim + " tidak ditemukan");
        }
        return peserta;
    }

    @Override
    public ArrayList<PesertaList> findPesertaByEvent(EventList event) {
        if (event == null) {
            throw new IllegalArgumentException("Event tidak boleh kosong");
        }
        return pesertaRepository.getPesertaByEvent(event);
    }

    @Override
    public void displayPesertaDetails(String nim) {
        PesertaList peserta = pesertaRepository.getPesertaByNim(nim);
        if (peserta != null) {
            System.out.println("=== Detail Peserta ===");
            System.out.println("Nama: " + peserta.getNama());
            System.out.println("NIM: " + peserta.getNim());
            System.out.println("Event yang Diikuti: " + peserta.getEventpilih().getNameEvent());
            System.out.println("======================");
        }
    }
}
