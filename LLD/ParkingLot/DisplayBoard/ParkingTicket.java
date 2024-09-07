package LLD.ParkingLot.DisplayBoard;

import java.util.Date;
import LLD.ParkingLot.ParkingSpots.Vehicle;

public class ParkingTicket {
	private int ticketNo;
	private Date timestamp;
	private Date exit;
	private double amount;
	private boolean status;
	
	private Vehicle vehicle;
	private Payment payment;
	private Entrance entrance;
	private Exit exitIns;
}
