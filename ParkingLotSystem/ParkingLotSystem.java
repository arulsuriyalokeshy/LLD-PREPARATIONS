
import java.util.*;

public class ParkingLotSystem {

    static class Vehicle {
        String number;
        String type;

        Vehicle(String number, String type) {
            this.number = number;
            this.type = type;
        }
    }

    static class ParkingSpot {
        int spotId;
        String supportedType;
        Vehicle vehicle;

        ParkingSpot(int spotId, String supportedType) {
            this.spotId = spotId;
            this.supportedType = supportedType;
        }

        boolean isAvailable() {
            return vehicle == null;
        }
    }

    static class Ticket {
        int ticketId;
        Vehicle vehicle;
        int spotId;
        long entryTime;

        Ticket(int ticketId, Vehicle vehicle, int spotId) {
            this.ticketId = ticketId;
            this.vehicle = vehicle;
            this.spotId = spotId;
            this.entryTime = System.currentTimeMillis();
        }
    }

    static class ParkingLot {
        ArrayList<ParkingSpot> spots = new ArrayList<>();
        HashMap<String, Ticket> activeTickets = new HashMap<>();
        int nextTicketId = 1;

        ParkingLot() {
            spots.add(new ParkingSpot(1, "BIKE"));
            spots.add(new ParkingSpot(2, "BIKE"));
            spots.add(new ParkingSpot(3, "CAR"));
            spots.add(new ParkingSpot(4, "CAR"));
            spots.add(new ParkingSpot(5, "TRUCK"));
        }

        void parkVehicle(String number, String type) {

            if (activeTickets.containsKey(number)) {
                System.out.println("Vehicle already parked!");
                return;
            }

            for (ParkingSpot spot : spots) {

                if (spot.isAvailable() &&
                    spot.supportedType.equals(type)) {

                    Vehicle vehicle = new Vehicle(number, type);
                    spot.vehicle = vehicle;

                    Ticket ticket = new Ticket(
                        nextTicketId++, vehicle, spot.spotId
                    );

                    activeTickets.put(number, ticket);

                    System.out.println("Vehicle parked successfully!");
                    System.out.println("Spot ID: " + spot.spotId);
                    System.out.println("Ticket ID: " + ticket.ticketId);
                    return;
                }
            }

            System.out.println("No available spot for " + type);
        }

        void removeVehicle(String number) {

            Ticket ticket = activeTickets.get(number);

            if (ticket == null) {
                System.out.println("Vehicle not found!");
                return;
            }

            long exitTime = System.currentTimeMillis();

            long duration = Math.max(
                1,
                (exitTime - ticket.entryTime) / 60000
            );

            int fee = calculateFee(ticket.vehicle.type, duration);

            for (ParkingSpot spot : spots) {
                if (spot.spotId == ticket.spotId) {
                    spot.vehicle = null;
                    break;
                }
            }

            activeTickets.remove(number);

            System.out.println("Vehicle exited successfully!");
            System.out.println("Parking duration: " + duration + " minute(s)");
            System.out.println("Parking fee: Rs." + fee);
        }

        int calculateFee(String type, long duration) {

            int rate = 0;

            switch (type) {
                case "BIKE": rate = 10; break;
                case "CAR": rate = 20; break;
                case "TRUCK": rate = 30; break;
            }

            return (int) (rate * duration);
        }

        void displaySpots() {

            System.out.println("\n--- PARKING STATUS ---");

            for (ParkingSpot spot : spots) {

                System.out.println(
                    "Spot " + spot.spotId +
                    " | Type: " + spot.supportedType +
                    " | Status: " +
                    (spot.isAvailable() ? "AVAILABLE" :
                    "OCCUPIED (" + spot.vehicle.number + ")")
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        while (true) {

            System.out.println("\n===== PARKING LOT SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Parking Spots");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {

                case "1":
                    System.out.print("Enter vehicle number: ");
                    String number = sc.nextLine().trim().toUpperCase();

                    if (number.isEmpty()) {
                        System.out.println("Vehicle number cannot be empty.");
                        break;
                    }

                    System.out.print("Enter type (BIKE/CAR/TRUCK): ");
                    String type = sc.nextLine().trim().toUpperCase();

                    if (!type.equals("BIKE") &&
                        !type.equals("CAR") &&
                        !type.equals("TRUCK")) {
                        System.out.println("Invalid vehicle type!");
                        break;
                    }

                    parkingLot.parkVehicle(number, type);
                    break;

                case "2":
                    System.out.print("Enter vehicle number: ");
                    String exitNumber = sc.nextLine().trim().toUpperCase();
                    parkingLot.removeVehicle(exitNumber);
                    break;

                case "3":
                    parkingLot.displaySpots();
                    break;

                case "4":
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
