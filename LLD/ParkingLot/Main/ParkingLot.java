package LLD.ParkingLot.Main;

import java.util.HashMap;

import LLD.ParkingLot.DisplayBoard.Entrance;
import LLD.ParkingLot.DisplayBoard.Exit;
import LLD.ParkingLot.DisplayBoard.ParkingRate;
import LLD.ParkingLot.DisplayBoard.ParkingTicket;
import LLD.ParkingLot.ParkingSpots.ParkingSpot;

public class ParkingLot {
	private int id;
	private String name;
	private String address;
	private ParkingRate parkingRate;
	
	private HashMap<String, Entrance> entrance;
	private HashMap<String, Exit> exit;
	
	private HashMap<String, ParkingTicket> tickets;
	
	private static ParkingLot parkingLot = null;

	private ParkingLot() {
		super();
	}
	
	public static ParkingLot getInstance() {
		if(parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		
		return parkingLot;
	}
	
	public boolean addEntrance(Entrance entrance) {}
	public boolean addExit(Exit exit) {}
	
	public ParkingTicket getParkingTicket(Vehicle vehicle) {}
	
	public boolean isFull(ParkingSpot type) {}
	
	
	
}