import repositories.EventRepositoryDbImpl;
import services.EventService;
import services.EventServiceImpl;
import views.EventViewImpl;

public class Main {
    public static void main(String[] args) {
        EventRepositoryDbImpl eventRepository = new EventRepositoryDbImpl();
        EventService eventService = new EventServiceImpl(eventRepository);
        EventViewImpl terminalView = new EventViewImpl(eventService);
        terminalView.displayMenu();
    }
}
