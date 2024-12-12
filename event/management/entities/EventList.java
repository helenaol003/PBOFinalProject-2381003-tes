package event.management.entities;
import java.util.ArrayList;

public class EventList {
    private String nameEvent;
    private String dateEvent;
    private String eventLocation;
    private ArrayList<PesertaList> pesertaList = new ArrayList<>();

    public EventList(String nameEvent, String dateEvent, String eventLocation) {
        this.nameEvent = nameEvent;
        this.dateEvent = dateEvent;
        this.eventLocation = eventLocation;
        this.pesertaList = new ArrayList<>();
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent =dateEvent;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public ArrayList<PesertaList> getPesertaList() {
        return pesertaList;
    }

    public void addPeserta(PesertaList peserta) {
        pesertaList.add(peserta);
    }

    public void removePeserta(PesertaList peserta) {
        pesertaList.remove(peserta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventList eventList = (EventList) o;
        return nameEvent.equals(eventList.nameEvent); // Perbandingan berdasarkan nama event
    }

    @Override
    public int hashCode() {
        return nameEvent.hashCode(); // Hash berdasarkan nama event
    }
}

