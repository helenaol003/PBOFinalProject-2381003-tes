package views;

import entities.EventList;
import services.EventService;

import java.util.Scanner;

public class EventViewImpl implements EventView {
    private final EventService eventService;
    private final Scanner scanner = new Scanner(System.in);

    public EventViewImpl(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void displayMenu() {
        while (true) {
            clearScreen();
            System.out.println("\n=== Event Management ===");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Update Event");
            System.out.println("4. List All Events");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 : addEvent();
                        break;
                case 2 : removeEvent();
                        break;
                case 3 : updateEvent();
                        break;
                case 4 : listAllEvents();
                        break;
                case 5 : {
                    System.out.println("Exiting Event Management...");
                    return;
                }
                default : System.out.println("Invalid choice. Please try again.");
                        break;
            }
        }
    }

    @Override
    public void addEvent() {
        System.out.println("\n=== Add Event ===");
        System.out.print("Enter Event Name: ");
        String nameEvent = scanner.nextLine();
        System.out.print("Enter Event Date: ");
        String dateEvent = scanner.nextLine();
        System.out.print("Enter Event Location: ");
        String eventLocation = scanner.nextLine();

        eventService.addEvent(nameEvent, dateEvent, eventLocation);
        System.out.println("Event added successfully!");
    }

    @Override
    public void removeEvent() {
        System.out.println("\n=== Remove Event ===");
        System.out.print("Enter Event Name to Remove: ");
        String nameEvent = scanner.nextLine();

        eventService.removeEvent(nameEvent);
        System.out.println("Event removed successfully!");
    }

    @Override
    public void updateEvent() {
        System.out.println("\n=== Update Event ===");
        System.out.print("Enter Event Name to Update: ");
        String nameEvent = scanner.nextLine();
        System.out.print("Enter New Date: ");
        String dateEvent = scanner.nextLine();
        System.out.print("Enter New Location: ");
        String eventLocation = scanner.nextLine();

        eventService.updateEvent(nameEvent, dateEvent, eventLocation);
        System.out.println("Event updated successfully!");
    }

    @Override
    public void listAllEvents() {
        System.out.println("\n=== List All Events ===");
        for (EventList event : eventService.getAllEvents()) {
            System.out.println("Name: " + event.getNameEvent());
            System.out.println("Date: " + event.getDateEvent());
            System.out.println("Location: " + event.getEventLocation());
            System.out.println("----------------------------");
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
