package LLD.ParkingLot.ParkingSpots;

public abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    private Vehicle vehicle;

    public boolean getIsFree();
    public abstract boolean assignVehicle(Vehicle vehicle);
    public boolean removeVehicle(){};
}

public class Handicapped extends ParkingSpot {

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignVehicle'");
    }
    
}

public class Compact extends ParkingSpot {

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignVehicle'");
    }
    
}

public class Large extends ParkingSpot {

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignVehicle'");
    }
    
}

public class Motorcycle extends ParkingSpot {

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignVehicle'");
    }
    
}








