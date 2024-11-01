package OnlineReservationSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservation {
	
	static Scanner sc=new Scanner(System.in);
	static HashMap<String, User> users = new HashMap<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

	   static {
           // Default users (for demonstration)
           users.put("mona123", new User("monika123", "monika"));
       }
	   
	   //login method
	public static boolean login() {
        System.out.println("--- Login Account ---");
        boolean isAuthenticated = false;
        int attempts = 3;

        while (attempts > 0 && !isAuthenticated) {
            System.out.println("\nEnter Login ID: ");
            String loginId = sc.nextLine();
            System.out.println("Enter Password: ");
            String password = sc.nextLine();

            User user = users.get(loginId);
            if (user != null && user.password.equals(password)) {
                System.out.println("Login successful!");
                isAuthenticated = true;
            } else {
                attempts--;
                System.out.println("Invalid login ID or password. Attempts remaining: " + attempts);
            }
        }

        return isAuthenticated;
    }

	//ticket book method
    public static void bookTicket() {
        System.out.println("\n--- Book a Ticket ---");
      
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
      
        System.out.print("Enter Train Number: ");
        String trainNumber = sc.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName =  sc.nextLine();

        System.out.print("Enter Class Type (e.g., Sleeper, AC): ");
        String classType = sc.nextLine();
       
        System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
        String dateOfJourney = sc.nextLine();
       
        System.out.print("Enter From (Place): ");
        String from = sc.nextLine();
       
        System.out.print("Enter To (Destination): ");
        String to = sc.nextLine();

        Reservation reservation = new Reservation(name, trainNumber, trainName, classType, dateOfJourney, from, to);
        reservations.add(reservation);
        System.out.println("Reservation successful! PNR Number: " + reservation.pnrNumber);
    }

    //cancel a ticket method
    public static void cancelTicket() {
        System.out.println("\n--- Cancel a Ticket ---");
        System.out.print("Enter PNR Number: ");
        int pnrNumber = sc.nextInt();

        Reservation reservation = null;
        for (Reservation res : reservations) {
            if (res.pnrNumber == pnrNumber) {
                reservation = res;
                break;
            }
        }

        if (reservation != null) {
            System.out.println("Reservation found: " + reservation);
            System.out.print("Do you want to confirm cancellation? (yes/no): ");
            String confirm = sc.next();

            if (confirm.equalsIgnoreCase("yes")) {
                reservations.remove(reservation);
                System.out.println("Cancellation successful for PNR Number: " + pnrNumber);
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Reservation with PNR Number " + pnrNumber + " not found.");
        }
    }
    
    //view reservation method
    public void viewReservations() {
        System.out.println("\nAll Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}