package eventPesertaApp.services;

import eventPesertaApp.entities.EventList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import eventPesertaApp.repositories.EventRepository;

import java.util.ArrayList;

@Component
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void addEvent(String nameEvent, String dateEvent, String eventLocation) {
        EventList event = new EventList(nameEvent, dateEvent, eventLocation);
        eventRepository.addEvent(event);
    }

    @Override
    public void removeEvent(String nameEvent) {
        EventList event = eventRepository.getEventByName(nameEvent);
        if (event != null) {
            eventRepository.removeEvent(event);
        }
    }

    @Override
    public void updateEvent(String nameEvent, String dateEvent, String eventLocation) {
        EventList event = eventRepository.getEventByName(nameEvent);
        if (event != null) {
            event.setNameEvent(nameEvent);
            event.setDateEvent(dateEvent);
            event.setEventLocation(eventLocation);
        }
    }

    @Override
    public EventList findEventByName(String nameEvent) {
        return eventRepository.getEventByName(nameEvent);
    }

    @Override
    public ArrayList<EventList> getAllEvents() {
        return eventRepository.getAllEvents();
    }
}
