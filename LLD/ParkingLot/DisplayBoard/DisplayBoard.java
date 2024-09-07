package LLD.ParkingLot.DisplayBoard;

import java.util.List;
import java.util.Map;

import LLD.ParkingLot.ParkingSpots.ParkingSpot;

public class DisplayBoard {
	private int id;
	private Map<String, List<ParkingSpot>> parkingSpots;
	public DisplayBoard(int id, Map<String, List<ParkingSpot>> parkingSpots) {
		super();
		this.id = id;
		this.parkingSpots = parkingSpots;
	}
	
	public void addParkingSpot(String spotType, List<ParkingSpot> spots);
	public void showFreeSlot();
	
	
}
