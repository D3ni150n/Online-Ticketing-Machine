public class Customer {

    private final int ID;
    private final String name;
    private final String address;
    private final String email;
    private final String password;
    private Event selectedEvent;

    public Customer(int ID, String name, String address, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }
}

