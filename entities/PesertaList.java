package entities;

import jdk.jfr.Event;

public class PesertaList {
    private String nama;
    private String nim;
    private EventList eventpilih;

    public PesertaList(String nama, String nim, EventList eventpilih) {
        this.nama = nama;
        this.nim = nim;
        this.eventpilih = eventpilih;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public EventList getEventpilih() {
        return eventpilih;
    }

    public void tampilDetailPeserta() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Event diikuti: " + eventpilih.getNameEvent());
    }
}
