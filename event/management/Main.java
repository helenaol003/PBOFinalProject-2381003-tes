package event.management;

import event.management.repositories.EventRepositoryImpl;
import event.management.repositories.PesertaRepositoryImpl;
import event.management.services.EventService;
import event.management.services.EventServiceImpl;
import event.management.services.PesertaService;
import event.management.services.PesertaServiceImpl;
import event.management.views.EventView;
import event.management.views.EventViewImpl;
import event.management.views.PesertaView;
import event.management.views.PesertaViewImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instantiate event.management.repositories
        EventRepositoryImpl eventRepository = new EventRepositoryImpl();
        PesertaRepositoryImpl pesertaRepository = new PesertaRepositoryImpl();

        // Instantiate event.management.services
        EventService eventService = new EventServiceImpl(eventRepository);
        PesertaService pesertaService = new PesertaServiceImpl(pesertaRepository);

        // Instantiate event.management.views
        EventView eventView = new EventViewImpl(eventService);
        PesertaView pesertaView = new PesertaViewImpl(pesertaService, eventService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearScreen();
            System.out.println("\n=== Event and Peserta Management ===");
            System.out.println("1. Manage Events");
            System.out.println("2. Manage Peserta");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    eventView.displayMenu();
                    break;
                case 2:
                    pesertaView.displayMenu();
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
