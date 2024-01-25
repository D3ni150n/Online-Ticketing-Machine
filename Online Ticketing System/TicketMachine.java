import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TicketMachine {

    private List<Customer> customers = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private Map<Customer, Event> bookedTickets = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.println("Enter customer ID:");
        int customerID = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer address:");
        String address = scanner.nextLine();
        System.out.println("Enter customer email:");
        String email = scanner.nextLine();
        System.out.println("Enter customer password:");
        String password = scanner.nextLine();

        Customer newCustomer = new Customer(customerID, name, address, email, password);
        customers.add(newCustomer);
        System.out.println("Account created for customer with ID: " + customerID);
    }

    public void createEvent() {
        System.out.println("Enter event ID:");
        int eventID = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();

        Event newEvent = new Event(eventID, eventName, this);  // Pass TicketMachine reference
        events.add(newEvent);
        System.out.println("Event created with ID: " + eventID);
    }
    
    public void selectEvent() {
        System.out.println("Enter customer ID:");
        int customerID = scanner.nextInt();
        System.out.println("Enter event ID:");
        int eventID = scanner.nextInt();

        Customer customer = findCustomerByID(customerID);
        Event event = findEventByID(eventID);

        if (customer != null && event != null) {
            customer.setSelectedEvent(event);
            System.out.println("Event selected for customer with ID " + customerID + ": " + event.getEventName());
            printCustomerDetails(customer);
        } else {
            System.out.println("Customer or event not found.");
        }
    }

    public void bookTicket() {
        System.out.println("Enter customer ID:");
        int customerID = scanner.nextInt();

        Customer customer = findCustomerByID(customerID);

        if (customer != null) {
            Event selectedEvent = customer.getSelectedEvent();

            if (selectedEvent != null) {
                bookedTickets.put(customer, selectedEvent);
                System.out.println("Ticket booked for customer with ID " + customerID + " for event: " +
                        selectedEvent.getEventName() + ". Total cost: £10");
                printCustomerDetails(customer);
            } else {
                System.out.println("No event selected for customer with ID " + customerID);
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    private Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    private Event findEventByID(int eventID) {
        for (Event event : events) {
            if (event.getEventID() == eventID) {
                return event;
            }
        }
        return null;
    }

    private void printCustomerDetails(Customer customer) {
        System.out.println("Customer Details:");
        System.out.println("Customer ID: " + customer.getID());
        System.out.println("Customer Name: " + customer.getName());

        Event selectedEvent = customer.getSelectedEvent();
        if (selectedEvent != null) {
            System.out.println("Selected Event: " + selectedEvent.getEventName());
            System.out.println("Ticket Booked: Yes");
            System.out.println("Ticket Price: £10");
        } else {
            System.out.println("Selected Event: None");
            System.out.println("Ticket Booked: No");
        }
        System.out.println("-----------------------");
    }
}







