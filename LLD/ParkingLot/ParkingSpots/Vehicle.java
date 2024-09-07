public abstract class Vehicle {
    private int licenseNumber;
    public abstract void assignTicket(ParkingTicket ticket);


}

public class Car extends Vehicle {

    @Override
    public void assignTicket(ParkingTicket ticket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignTicket'");
    }
    
}

public class Van extends Vehicle {

    @Override
    public void assignTicket(ParkingTicket ticket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignTicket'");
    }
    
}

public class Truck extends Vehicle {

    @Override
    public void assignTicket(ParkingTicket ticket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignTicket'");
    }
    
}

public class Motorcycle extends Vehicle {

	@Override
	public void assignTicket(ParkingTicket ticket) {
		// TODO Auto-generated method stub
		
	}
   
    
}