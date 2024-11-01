package OnlineReservationSystem;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Reservation {
	static int counter = 1001; // PNR counter
    int pnrNumber;
    String name;
    String trainNumber;
    String trainName;
    String classType;
    String dateOfJourney;
    String from;
    String to;

    Reservation(String name, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.pnrNumber = counter++;
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return " PNR: " + pnrNumber + "\n Name: " + name + "\n Train Name: " + trainName + " \n Train Number:" + trainNumber + "\n Class: " + classType +
                "\n Date: " + dateOfJourney + "\n From: " + from + "\n To: " + to +"\n\n";
    }
}