package repositories;

import config.Database;
import entities.EventList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EventRepositoryDbImpl {
    private final Database database;

    public EventRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addEvent(EventList event) {
        String sql = "INSERT INTO events(name_event, date_event, event_location) VALUES(?, ?, ?)";
        Connection conn = database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, event.getNameEvent());
            stmt.setString(2, event.getDateEvent());
            stmt.setString(3, event.getEventLocation());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Event successfully added!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeEvent(EventList event) {
        String sql = "DELETE FROM events WHERE name_event = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, event.getNameEvent());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Event successfully removed!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public EventList getEventByName(String nameEvent) {
        String sql = "SELECT * FROM events WHERE name_event = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nameEvent);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new EventList(
                        rs.getString("name_event"),
                        rs.getString("date_event"),
                        rs.getString("event_location")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<EventList> getAllEvents() {
        String sql = "SELECT * FROM events";
        Connection conn = database.getConnection();
        ArrayList<EventList> events = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                events.add(new EventList(
                        rs.getString("name_event"),
                        rs.getString("date_event"),
                        rs.getString("event_location")
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return events;
    }
}
