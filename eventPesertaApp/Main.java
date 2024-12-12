package eventPesertaApp;

import eventPesertaApp.repositories.EventRepositoryImpl;
import eventPesertaApp.repositories.PesertaRepositoryImpl;
import eventPesertaApp.services.EventService;
import eventPesertaApp.services.EventServiceImpl;
import eventPesertaApp.services.PesertaService;
import eventPesertaApp.services.PesertaServiceImpl;
import eventPesertaApp.views.EventView;
import eventPesertaApp.views.EventViewImpl;
import eventPesertaApp.views.PesertaView;
import eventPesertaApp.views.PesertaViewImpl;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@ComponentScan(basePackages = "eventPesertaApp")
public class Main {
    public static void main(String[] args) {
        // Instantiate repositories
        EventRepositoryImpl eventRepository = new EventRepositoryImpl();
        PesertaRepositoryImpl pesertaRepository = new PesertaRepositoryImpl();

        // Instantiate services
        EventService eventService = new EventServiceImpl(eventRepository);
        PesertaService pesertaService = new PesertaServiceImpl(pesertaRepository);

        // Instantiate views
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