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
	
	public void updateDate(Date chekin, Date chekout) {
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
