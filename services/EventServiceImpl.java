package services;

import entities.EventList;
import repositories.EventRepository;

import java.util.ArrayList;

public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void addEvent(String nameEvent, String dateEvent, String eventLocation) {
        EventList event = new EventList(nameEvent, dateEvent, eventLocation);
        eventRepository.addEvent(event);
    }

    @Override
    public void removeEvent(int index) {
        ArrayList<EventList> events = eventRepository.getAllEvents();
        if (index >= 0 && index < events.size()) {
            eventRepository.removeEvent(events.get(index));
        }
    }

    @Override
    public ArrayList<EventList> getAllEvents() {
        return eventRepository.getAllEvents();
    }
}
