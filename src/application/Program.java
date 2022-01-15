package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExeption;

public class Program {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int rooNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date chakIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date chakOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(rooNumber, chakIn, chakOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			chakIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			chakOut = sdf.parse(sc.next());			
			
			reservation.updateDate(chakIn, chakOut);		
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainExeption e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
				
		sc.close();	
		}

	
	}


