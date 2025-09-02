import java.util.ArrayList;
import java.util.List;

class Event {
    int eventId;
    String eventName;
    String date;
    String venue;

    public Event(int eventId, String eventName, String date, String venue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
    }

    void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
    }
}

interface Registrable {
    void registerParticipant(String name);
    void showParticipants();
}

class CodingEvent extends Event implements Registrable {
    int maxTeamSize;
    List<String> participants = new ArrayList<>();

    public CodingEvent(int eventId, String eventName, String date, String venue, int maxTeamSize) {
        super(eventId, eventName, date, venue);
        this.maxTeamSize = maxTeamSize;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Max Team Size: " + maxTeamSize);
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
    }

    @Override
    public void showParticipants() {
        System.out.println("Coding Event Participants: " + participants);
    }
}

class RoboticsEvent extends Event implements Registrable {
    String theme;
    List<String> participants = new ArrayList<>();

    public RoboticsEvent(int eventId, String eventName, String date, String venue, String theme) {
        super(eventId, eventName, date, venue);
        this.theme = theme;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Theme: " + theme);
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
    }

    @Override
    public void showParticipants() {
        System.out.println("Robotics Event Participants: " + participants);
    }
}

class HackathonEvent extends Event implements Registrable {
    int duration;
    List<String> participants = new ArrayList<>();

    public HackathonEvent(int eventId, String eventName, String date, String venue, int duration) {
        super(eventId, eventName, date, venue);
        this.duration = duration;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Duration (hours): " + duration);
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
    }

    @Override
    public void showParticipants() {
        System.out.println("Hackathon Event Participants: " + participants);
    }
}

public class main {
    public static void main(String[] args) {
        Event[] events = new Event[3];
        Registrable[] registrables = new Registrable[3];

        events[0] = new CodingEvent(101, "CodeSprint", "2025-08-21", "Lab A", 3);
        events[1] = new RoboticsEvent(102, "RoboRace", "2025-08-22", "Auditorium", "AI Navigation");
        events[2] = new HackathonEvent(103, "HackTheFuture", "2025-08-23", "Lab B", 24);

        registrables[0] = (Registrable) events[0];
        registrables[1] = (Registrable) events[1];
        registrables[2] = (Registrable) events[2];

        registrables[0].registerParticipant("Prince");
        registrables[0].registerParticipant("deep");

        registrables[1].registerParticipant("vijay");
        registrables[1].registerParticipant("shrey");

        registrables[2].registerParticipant("shivam");
        registrables[2].registerParticipant("abhishek");

        for (int i = 0; i < events.length; i++) {
            System.out.println("\n--- Event Details ---");
            events[i].displayEventDetails();
            registrables[i].showParticipants();
        }
    }
}