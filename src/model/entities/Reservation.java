package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer rooNumber;
	private Date chakin;
	private Date chakout;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {	
	}

	public Reservation(Integer rooNumber, Date chakin, Date chakout) {
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
	
	public String updateDate(Date chekin, Date chekout) {
		Date now = new Date();
		if(chekin.before(now) || chekout.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if(! chekout.after(chekin)) {
			return "Check-out date must be after check-in date";
		}
		chakin = chekin;
		chakout = chekout;
		return null;
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
