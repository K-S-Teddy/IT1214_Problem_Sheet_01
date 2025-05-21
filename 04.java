class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String toString() {
        return "Ticket#: " + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
    }
}


class BookingSystem {
    private Ticket[] tickets = new Ticket[10]; // max 10 seats
    private int count = 0;

    public void bookTicket(Ticket ticket) {

        for (int i = 0; i < count; i++) {
            if (tickets[i].getSeatNumber() == ticket.getSeatNumber()) {
                System.out.println("Seat " + ticket.getSeatNumber() + " is already booked.");
                return;
            }
        }

        if (count < tickets.length) {
            tickets[count++] = ticket;
            System.out.println("Ticket booked successfully for seat " + ticket.getSeatNumber());
        } else {
            System.out.println("All seats are booked. Booking failed.");
        }
    }

    public void cancelTicket(int ticketNumber) {
        for (int i = 0; i < count; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                for (int j = i; j < count - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--count] = null;
                System.out.println("Ticket #" + ticketNumber + " cancelled successfully.");
                return;
            }
        }
        System.out.println("Ticket number not found.");
    }

    public void displayAllBookings() {
        if (count == 0) {
            System.out.println("No tickets booked.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }
}

 class BookingMain {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(new Ticket(1, "Alice",1));
         system.bookTicket(new Ticket(2, "Bob", 2));
        system.bookTicket(new Ticket(3, "Charlie", 3));

        system.cancelTicket(2);
        system.bookTicket(new Ticket(4, "David", 2));
        system.displayAllBookings();
    }
}
