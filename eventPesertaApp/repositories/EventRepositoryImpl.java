package eventPesertaApp.repositories;
import eventPesertaApp.entities.EventList;
import eventPesertaApp.config.Database;

import java.util.ArrayList;

public class EventRepositoryImpl implements EventRepository {
    @Override
    public void addEvent(EventList event) {
        Database.eventList.add(event);
    }

    @Override
    public void removeEvent(EventList event) {
        Database.eventList.remove(event);
    }

    @Override
    public EventList getEventByName(String nameEvent) {
        for (EventList event : Database.eventList) {
            if (event.getNameEvent().equalsIgnoreCase(nameEvent)) {
                return event;
            }
        }

        return null;
    }

    @Override
    public ArrayList<EventList> getAllEvents() {
        return Database.eventList;
    }
}
