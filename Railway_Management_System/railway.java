// Importing all the neccessary collections. 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// Making a Train class that has various methods to store train information.

class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String departureTime;
    private int maxSeats;
    private int availableSeats;

    public Train(int trainNumber, String trainName, String source, String destination, String departureTime,
            int maxSeats) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.maxSeats = maxSeats;
        this.availableSeats = maxSeats;

    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true; // Seat booked successfully
        }
        return false; // No available seats
    }

}

// Ticket that contains all the logic and information about ticket.

class Ticket {
    private static int ticketCounter = 1;
    private int ticketNumber;
    private String passengerName;
    private int seatNumber;
    private int trainNumber;

    public Ticket(String passengerName, int seatNumber, int trainNumber) {

        this.ticketNumber = ticketCounter++;
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.trainNumber = trainNumber;

    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getTrainNumber() {
        return trainNumber;
    }
}

// Making a class Reservation that contains all the logic to book seats and
// displaying information

class ReservationSystem {
    private List<Train> trains;
    private List<Ticket> tickets;
    private Map<Integer, List<Integer>> reservedSeats;

    public ReservationSystem() {
        trains = new ArrayList<>();
        tickets = new ArrayList<>();
        reservedSeats = new HashMap<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    // Displaying information on the screen

    public void displayTrainInformation(String source, String destination) {

        List<Train> availableTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)) {
                availableTrains.add(train);
            }
        }

        if (availableTrains.isEmpty()) {
            System.out.println("\n\nNo trains available between " + source + " to " + destination + "...............");
        } else {
            System.out.println("\n------------------- Available Trains: ---------------------\n");

            for (Train train : availableTrains) {
                System.out.println("Train Name          :          " + train.getTrainName()
                        + "\nSource              :          " + train.getSource() + "\nDestination         :          "
                        + train.getDestination() + "\nDeparture_Time      :          " + train.getDepartureTime()
                        + "\nSeats               :          " + train.getAvailableSeats()
                        + "\nTrain Number        :          " + train.getTrainNumber());
                System.out.println("---------------------------------------------");
            }
        }

    }

    // Method to book ticket

    public boolean bookTicket(String passengerName, int seatNumber, int trainNumber) {
        try {
            Train selectedTrain = null;
            for (Train train : trains) {
                if (train.getTrainNumber() == trainNumber) {
                    selectedTrain = train;
                    break;
                }
            }

            if (selectedTrain == null) {
                throw new IllegalArgumentException("Invalid train number");
            }

            if (seatNumber > 50) {
                throw new IllegalArgumentException("Invalid seat number");
            }

            if (reservedSeats.containsKey(trainNumber) && reservedSeats.get(trainNumber).contains(seatNumber)) {
                throw new RuntimeException("Seat " + seatNumber + " is already booked for train " + trainNumber);
            }

            if (selectedTrain.bookSeat()) {
                Ticket ticket = new Ticket(passengerName, seatNumber, trainNumber);
                tickets.add(ticket);
                reservedSeats.computeIfAbsent(trainNumber, k -> new ArrayList<>()).add(seatNumber);
                System.out.println("Ticket booked successfully for passenger " + passengerName + " Seat number "
                        + seatNumber + " and train number " + trainNumber);
                return true;
            } else {
                throw new RuntimeException("No available seats for the selected train.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
}

// Making a class railway that is the main class

public class railway {

    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        Train train1 = new Train(1010, "Mumbai Superfast", "Mumbai", "Delhi", "13:05", 50);
        Train train2 = new Train(2013, "Delhi SuperFast", "Delhi", "Jaipur", "7:00", 50);
        Train train3 = new Train(3045, "Prayagraj EXP", "Prayagraj", "Delhi", "10:00", 50);
        Train train4 = new Train(13244, "Intercity EXP", "Rafiganj", "Gaya", "06:00", 50);
        Train train5 = new Train(6510, "Rajdhani Express", "Mumbai", "Delhi", "11:05", 50);

        // Adding the predefined trains to the reservation system
        reservationSystem.addTrain(train1);
        reservationSystem.addTrain(train2);
        reservationSystem.addTrain(train3);
        reservationSystem.addTrain(train4);
        reservationSystem.addTrain(train5);

        // Implement user interface and application logic here
        while (true) {
            System.out.println("\n-------------- RAILWAY MANAGEMENT SYSTEM (Avinash Kumar Singh) -----------\n");
            System.out.println("1. Search trains between stations");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Exit");
            System.out.print("Choose an option : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("\nEnter source station: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination station: ");
                    String destination = scanner.nextLine();
                    reservationSystem.displayTrainInformation(source, destination);
                    break;
                case 2:
                    System.out.print("\nEnter passenger name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    System.out.print("Enter train number: ");
                    int trainNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    reservationSystem.bookTicket(passengerName, seatNumber, trainNumber);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}