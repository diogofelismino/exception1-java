package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int rooNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date chakIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date chakOut = sdf.parse(sc.next());
		
		if(! chakOut.after(chakIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(rooNumber, chakIn, chakOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			chakIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			chakOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(chakIn.before(now) || chakOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else if(! chakOut.after(chakIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				reservation.updateDate(chakIn, chakOut);
				System.out.println("Reservation: " + reservation);
			}
			
			
			
		}


	}

}
