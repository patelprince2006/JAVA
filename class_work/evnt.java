import java.util.ArrayList;

// Base Class
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

    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
    }
}

// Interface
interface Registrable {
    void registerParticipant(String name);
    void showParticipants();
}

// Coding Event
class CodingEvent extends Event implements Registrable {
    int maxTeamSize;
    ArrayList<String> participants = new ArrayList<>();

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
        System.out.println("Coding Event Participants:");
        for (String p : participants) {
            System.out.println("- " + p);
        }
    }
}

// Robotics Event
class RoboticsEvent extends Event implements Registrable {
    String theme;
    ArrayList<String> participants = new ArrayList<>();

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
        System.out.println("Robotics Event Participants:");
        for (String p : participants) {
            System.out.println("- " + p);
        }
    }
}

// Hackathon Event
class HackathonEvent extends Event implements Registrable {
    int duration;
    ArrayList<String> participants = new ArrayList<>();

    public HackathonEvent(int eventId, String eventName, String date, String venue, int duration) {
        super(eventId, eventName, date, venue);
        this.duration = duration;
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Duration: " + duration + " hours");
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
    }

    @Override
    public void showParticipants() {
        System.out.println("Hackathon Event Participants:");
        for (String p : participants) {
            System.out.println("- " + p);
        }
    }
}

// Main Class
public class TechFestMain {
    public static void main(String[] args) {
        Event[] events = new Event[3];
        Registrable[] registrables = new Registrable[3];

        events[0] = new CodingEvent(101, "CodeSprint", "2025-08-21", "Lab A", 3);
        events[1] = new RoboticsEvent(102, "RoboRace", "2025-08-22", "Auditorium", "AI Navigation");
        events[2] = new HackathonEvent(103, "HackTheFuture", "2025-08-23", "Innovation Hub", 24);

        registrables[0] = (Registrable) events[0];
        registrables[1] = (Registrable) events[1];
        registrables[2] = (Registrable) events[2];

        // Register participants
        registrables[0].registerParticipant("Alice");
        registrables[0].registerParticipant("Bob");

        registrables[1].registerParticipant("Charlie");
        registrables[1].registerParticipant("Diana");

        registrables[2].registerParticipant("Eve");
        registrables[2].registerParticipant("Frank");

        // Display event details and participants
        for (int i = 0; i < events.length; i++) {
            System.out.println("\n--- Event " + (i + 1) + " Details ---");
            events[i].displayEventDetails();
            registrables[i].showParticipants();
        }
    }
}
