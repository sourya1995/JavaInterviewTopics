package LLD.ParkingLot.Account;

import LLD.ParkingLot.Enums.Person;
import LLD.ParkingLot.Enums.AccountStatus;

public abstract class Account {
	private String username;
	private String password;
	private Person person;
	private AccountStatus status;
	
	public abstract boolean resetPassword();
}

public class Admin extends Account {
	
	public boolean addParkingSpot(ParkingSpot spot);
	public boolean addDisplayBoard(DisplayBoard displayBoard);
	public boolean addEntrance(Entrance entrance);
	public boolean addExit(Exit exit);

	@Override
	public boolean resetPassword() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

public class ParkingAttendant extends Account {
	public boolean processTicket(String ticketNumber);

	@Override
	public boolean resetPassword() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
