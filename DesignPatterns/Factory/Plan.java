package DesignPatterns.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan {
    protected double rate;
    abstract void getRate();

    public void calculateBills(int units){
        System.out.println(units * rate);
    }
}

class DomesticPlan extends Plan {

    @Override
    void getRate() {
       rate = 4.50;
    }

}

class CommercialPlan extends Plan {

    @Override
    void getRate() {
       rate = 7.50;
    }
    
}

class InstitutionalPlan extends Plan {

    @Override
    void getRate() {
       rate = 4.50;
    }

}

class GetPlanFactory {
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }

        if(planType.equalsIgnoreCase("DOMESTIC-PLAN")){
            return new DomesticPlan();
        }

        else if(planType.equalsIgnoreCase("COMMERCIAL-PLAN")){
            return new CommercialPlan();
        }

        else if(planType.equalsIgnoreCase("INSTITUTIONAL-PLAN")){
            return new InstitutionalPlan();
        }

        return null;
    }
}

class GenerateBill {
    public static void main(String[] args) throws IOException {
        GetPlanFactory factory = new GetPlanFactory();
        System.out.println("Enter name of plan");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planName = reader.readLine();
        System.out.println("Enter number of units");
        int units = Integer.parseInt(reader.readLine());
        Plan p1 = factory.getPlan(planName);
        p1.getRate();
        p1.calculateBills(units);
    }
}