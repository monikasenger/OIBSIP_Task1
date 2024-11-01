package OnlineReservationSystem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineReservationSystem {
static Scanner sc=new Scanner(System.in);
  static OnlineReservation res=new OnlineReservation();
     static char ans;

        public static void main(String[] args) {
            
        	//login id check method
            if (!(res.login())) {
                System.out.println("\nUnauthorized access."+ "\nTry again later");
                System.out.println("Thank You For Coming :) ");

                return;
            }

            int choice;
            do {
                System.out.println("\n--- Online Reservation System ---");
                System.out.println("1. Book a Ticket");
                System.out.println("2. Cancel a Ticket");
                System.out.println("3. View a Ticket");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        res.bookTicket();
                        break;
                    case 2:
                        res.cancelTicket();
                        break;
                    case 3:
                    	res.viewReservations();
                    	break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            	System.out.println("\nDo you want to do more Reservation:  Y/N"); //if we use  want the more reservation 
       		 ans = sc.next().charAt(0); 
       		}while(ans == 'y'|| ans =='Y');
       		
       		System.out.println("Thank You For Coming :) ");

            sc.close();
        }
    }