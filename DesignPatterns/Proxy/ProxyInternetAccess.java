package DesignPatterns.Proxy;

public class ProxyInternetAccess implements OfficeInternetAccess{

    private String employeeName;

    private RealInternetAccess realInternetAccess;

    public ProxyInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess() {
      if(getRole(employeeName) > 4){
        realInternetAccess = new RealInternetAccess(employeeName);
        realInternetAccess.grantInternetAccess();
      }
      else {
        System.out.println("Not granted");
      }
    }

    public int getRole(String emplName){
        //checl from db
        return 9;
    }
    
}
