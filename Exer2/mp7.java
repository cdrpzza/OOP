package exer2;
import java.util.Scanner;

class Guest {
    private String guestId;
    private String fullName;

    public Guest(String guestId, String fullName) {
        this.guestId = guestId;
        this.fullName = fullName;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getFullName() {
        return fullName;
    }
}

class Room {
    private int roomNumber;
    private String roomType;
    private double nightlyRate;
    private boolean available;

    public Room(int roomNumber, String roomType, double nightlyRate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightlyRate = nightlyRate;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean reserve() {
        if (!available) {
            return false;
        }

        available = false;
        return true;
    }

    public void release() {
        available = true;
    }
}

class Reservation {
    private String reservationId;
    private Guest guest;
    private Room room;
    private int nights;

    public Reservation(String reservationId, Guest guest, Room room, int nights) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.nights = nights;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalCost() {
        return room.getNightlyRate() * nights;
    }
}

public class mp7 {

    public static Guest findGuest(Guest[] guests, String guestId) {
        for (int i = 0; i < guests.length; i++) {
            if (guests[i].getGuestId().equals(guestId)) {
                return guests[i];
            }
        }
        return null;
    }

    public static Room findRoom(Room[] rooms, int roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                return rooms[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of rooms: ");
        int roomCount = scanner.nextInt();
        scanner.nextLine();

        Room[] rooms = new Room[roomCount];

        for (int i = 0; i < roomCount; i++) {
            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Room type: ");
            String roomType = scanner.nextLine();

            System.out.print("Nightly rate: ");
            double nightlyRate = scanner.nextDouble();
            scanner.nextLine();

            rooms[i] = new Room(roomNumber, roomType, nightlyRate);
        }

        System.out.print("Number of guests: ");
        int guestCount = scanner.nextInt();
        scanner.nextLine();

        Guest[] guests = new Guest[guestCount];

        for (int i = 0; i < guestCount; i++) {
            System.out.print("Guest ID: ");
            String guestId = scanner.nextLine();

            System.out.print("Full name: ");
            String fullName = scanner.nextLine();

            guests[i] = new Guest(guestId, fullName);
        }

        System.out.print("Number of reservation requests: ");
        int requestCount = scanner.nextInt();
        scanner.nextLine();

        Reservation[] reservations = new Reservation[requestCount];
        int successfulReservations = 0;
        double totalRevenue = 0;

        for (int i = 0; i < requestCount; i++) {
            System.out.println("\nReservation Request " + (i + 1));

            System.out.print("Reservation ID: ");
            String reservationId = scanner.nextLine();

            System.out.print("Guest ID: ");
            String guestId = scanner.nextLine();

            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();

            System.out.print("Number of nights: ");
            int nights = scanner.nextInt();
            scanner.nextLine();

            Guest guest = findGuest(guests, guestId);
            Room room = findRoom(rooms, roomNumber);

            if (guest == null) {
                System.out.println("Reservation rejected: Unknown guest.");
            } else if (room == null) {
                System.out.println("Reservation rejected: Unknown room.");
            } else if (nights < 1) {
                System.out.println("Reservation rejected: Nights must be at least 1.");
            } else if (!room.reserve()) {
                System.out.println("Reservation rejected: Room is unavailable.");
            } else {
                Reservation reservation = new Reservation(reservationId, guest, room, nights);
                reservations[successfulReservations] = reservation;
                successfulReservations++;
                totalRevenue += reservation.getTotalCost();

                System.out.printf("Reservation accepted. Total cost: %.2f%n",
                        reservation.getTotalCost());
            }
        }

        System.out.println("\nReservation Summary");

        for (int i = 0; i < successfulReservations; i++) {
            Reservation reservation = reservations[i];

            System.out.printf("%s - Guest: %s, Room: %d, Nights: %d, Total: %.2f%n",
                    reservation.getReservationId(),
                    reservation.getGuest().getFullName(),
                    reservation.getRoom().getRoomNumber(),
                    reservation.getNights(),
                    reservation.getTotalCost());
        }

        System.out.printf("Total Expected Revenue: %.2f%n", totalRevenue);

        System.out.println("Available Rooms:");

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isAvailable()) {
                System.out.println(rooms[i].getRoomNumber() + " - "
                        + rooms[i].getRoomType());
            }
        }

        scanner.close();
    }
}