package LLD.ParkingLot.Payment;

import java.util.Date;

import LLD.ParkingLot.Enums.PaymentStatus;

public abstract class Payment {
	private double amount;
	private PaymentStatus status;
	private Date timestamp;
	
	public abstract boolean initiateTransaction();
}

public class Cash extends Payment {
	public boolean initiateTransaction() {
		
	}
}

public class CreditCard extends Payment {
	public boolean initiateTransaction() {
		
	}
}
