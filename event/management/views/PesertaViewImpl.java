package event.management.views;

import event.management.entities.EventList;
import event.management.entities.PesertaList;
import event.management.services.EventService;
import event.management.services.PesertaService;

import java.util.Scanner;

public class PesertaViewImpl implements PesertaView {
    private final PesertaService pesertaService;
    private final EventService eventService;
    private final Scanner scanner = new Scanner(System.in);

    public PesertaViewImpl(PesertaService pesertaService, EventService eventService) {
        this.pesertaService = pesertaService;
        this.eventService = eventService;
    }

    @Override
    public void displayMenu() {
        while (true) {
            clearScreen();
            System.out.println("\n=== Peserta Management ===");
            System.out.println("1. Add Peserta");
            System.out.println("2. Remove Peserta");
            System.out.println("3. List All Peserta");
            System.out.println("4. Display Peserta Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 : addPeserta();
                        break;
                case 2 : removePeserta();
                        break;
                case 3 : listAllPeserta();
                        break;
                case 4 : displayPesertaDetails();
                        break;
                case 5 : {
                    System.out.println("Exiting Peserta Management...");
                    return;
                }
                default : System.out.println("Invalid choice. Please try again.");
                        break;
            }
        }
    }

    @Override
    public void addPeserta() {
        System.out.println("\n=== Add Peserta ===");
        System.out.print("Enter Peserta Name: ");
        String nama = scanner.nextLine();
        System.out.print("Enter Peserta NIM: ");
        String nim = scanner.nextLine();

        System.out.println("Available Events:");
        for (EventList event : eventService.getAllEvents()) {
            System.out.println("- " + event.getNameEvent());
        }

        System.out.print("Enter Event Name for Peserta: ");
        String eventName = scanner.nextLine();
        EventList event = eventService.findEventByName(eventName);

        if (event == null) {
            System.out.println("Event not found!");
            return;
        }

        pesertaService.addPeserta(nama, nim, event);
        System.out.println("Peserta added successfully!");
    }

    @Override
    public void removePeserta() {
        System.out.println("\n=== Remove Peserta ===");
        System.out.print("Enter Peserta NIM to Remove: ");
        String nim = scanner.nextLine();

        pesertaService.removePeserta(nim);
    }

    @Override
    public void listAllPeserta() {
        System.out.println("\n=== List All Peserta ===");
        for (PesertaList peserta : pesertaService.getAllPeserta()) {
            System.out.println("Name: " + peserta.getNama());
            System.out.println("NIM: " + peserta.getNim());
            System.out.println("Event: " + peserta.getEventpilih().getNameEvent());
            System.out.println("----------------------------");
        }
    }

    @Override
    public void displayPesertaDetails() {
        System.out.println("\n=== Peserta Details ===");
        System.out.print("Enter Peserta NIM: ");
        String nim = scanner.nextLine();

        pesertaService.displayPesertaDetails(nim);
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
