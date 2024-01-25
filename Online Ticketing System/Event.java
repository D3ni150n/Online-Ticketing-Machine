public class Event {

    private final int eventID;
    private final String eventName;
    private TicketMachine ticketMachine;  // Reference to TicketMachine

    public Event(int eventID, String eventName, TicketMachine ticketMachine) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.ticketMachine = ticketMachine;
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public TicketMachine getTicketMachine() {
        return ticketMachine;
    }
}



