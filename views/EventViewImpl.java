package views;

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
            System.out.println("====== Menu Event ======");
            System.out.println("1. Tambah Event");
            System.out.println("2. Hapus Event");
            System.out.println("3. Lihat Semua Event");
            System.out.println("4. Update Event");
            System.out.println("0. Keluar");
            System.out.println("========================");
            System.out.print("Masukkan Pilihan Menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEvent();
                case 2 -> removeEvent();
                case 3 -> listAllEvents();
                case 4 -> updateEvent();
                case 0 -> {
                    System.out.println("Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    @Override
    private void addEvent() {
        System.out.print("Nama Event: ");
        String name = scanner.nextLine();
        System.out.print("Tanggal Event: ");
        String date = scanner.nextLine();
        System.out.print("Lokasi Event: ");
        String location = scanner.nextLine();
        eventService.addEvent(name, date, location);
    }

    @Override
    private void removeEvent() {
        System.out.print("Masukkan Index Event untuk dihapus: ");
        String name = scanner.nextLine();
        eventService.removeEvent(name);
//        int index = scanner.nextInt();
//        scanner.nextLine();
//        eventService.removeEvent(index - 1);
    }

    @Override
    public void updateEvent(){
        System.out.print("Nama Event yang akan diupdate: ");
        String name = scanner.nextLine();
        System.out.print("Tanggal Event Baru: ");
        String date = scanner.nextLine();
        System.out.print("Lokasi Event Baru: ");
        String location = scanner.nextLine();
        eventService.updateEvent(name, date, location);
    }

    @Override
    private void listAllEvents() {
        eventService.getAllEvents().forEach(event -> {
            System.out.println("Nama Event: " + event.getNameEvent());
            System.out.println("Tanggal: " + event.getDateEvent());
            System.out.println("Lokasi: " + event.getEventLocation());
        });
    }
}
