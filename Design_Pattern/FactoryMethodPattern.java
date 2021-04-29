import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class FactoryMethodPattern {

    //An abstract parent class 
    abstract class Plan {
        int rate;
        abstract void getRate();

        public void calculateBill(int units){
            System.out.println(units*this.rate);
        }
    }

    //Next 3 classes extending Abstract Class Plan
    class DomesticPlan extends Plan {

        void getRate(){
            super.rate = 10;
        }

    }

    class CommercialPlan extends Plan {

        void getRate(){
            super.rate = 20;
        }
    }

    class InstitutionalPlan extends Plan {

        void getRate(){
            super.rate = 30;
        }
    }

    class GetPlanFactory {

        public Plan getPlan(String planType){

            if(planType.isEmpty()){
                return null;
            } else if( planType.equalsIgnoreCase("COMMERCIAL")){
                return new CommercialPlan();
            } else if( planType.equalsIgnoreCase("DOMESTIC")){
                return new DomesticPlan();
            } else if( planType.equalsIgnoreCase("INSTITUTIONAL")){
                return new InstitutionalPlan();
            } 

            return null;
        }
    }

    public static void main(String[] args) {
        FactoryMethodPattern fmp = new FactoryMethodPattern();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Type of Meter ?");
        String type = sc.nextLine();

        System.out.println("Enter the number of units");
        int quantity = sc.nextInt();

        GetPlanFactory planFactory = fmp.new GetPlanFactory();
        Plan p = planFactory.getPlan(type);

        p.getRate();

        p.calculateBill(quantity);

    }
    
}
