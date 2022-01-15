package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExeption;

public class Reservation {
	private Integer rooNumber;
	private Date chakin;
	private Date chakout;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer rooNumber, Date chakin, Date chakout) throws DomainExeption {
		if(! chakout.after(chakin)) {
			throw new DomainExeption("Check-out date must be after check-in date");
		}
		
		this.rooNumber = rooNumber;
		this.chakin = chakin;
		this.chakout = chakout;
	}

	public Integer getRooNumber() {
		return rooNumber;
	}

	public void setRooNumber(Integer rooNumber) {
		this.rooNumber = rooNumber;
	}

	public Date getChakin() {
		return chakin;
	}

	public Date getChakout() {
		return chakout;
	}
	
	public long duration() {
		long diff = chakout.getTime() - chakin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date chekin, Date chekout) throws DomainExeption {
		Date now = new Date();
		if(chekin.before(now) || chekout.before(now)) {
			throw new DomainExeption("Reservation dates for update must be future dates");
		}
		if(! chekout.after(chekin)) {
			throw new DomainExeption("Check-out date must be after check-in date");
		}
		chakin = chekin;
		chakout = chekout;
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ rooNumber
				+", check-In: "
				+ sdf.format(chakin)
				+",  check-Out: "
				+ sdf.format(chakout)
				+ ", "
				+duration()
				+" nights";
	}

	
	

}
