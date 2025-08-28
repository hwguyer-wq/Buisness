import java.util.Scanner;

public class BuisnessEvaluation {

    public static void main(String[] args) {
        // set a scanner for inputs
        Scanner input = new Scanner(System.in);
        // innitalize my variables
        double[] earnings = new double[5];
        double[] ratios = new double[5];

        // ask for the earnings
        System.out.println("Enter projected earnings for 5 years ($200000 to $500000):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Year " + (i + 1) + ": $");
            // catch what we input
            double earning = input.nextDouble();
            // if it isn't in the range reprompt
            while (earning < 200000 || earning > 500000) {
                System.out.println("Number has to be between 200000 and 500000.");
                System.out.print("Year " + (i + 1) + ": $");
                earning = input.nextDouble();
            }
            // set the earnings to the earnings array
            earnings[i] = earning;
        }
        // Buisness object with an array of earnings
        Buisness myBusiness = new Buisness(earnings);

        // same principal as above ask for a value
        System.out.println("Enter price-to-earnings ratios for 5 years (0.0 to 10.0):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Year " + (i + 1) + ": ");
            double ratio = input.nextDouble();


            // Keep asking until valid input is given
            while (ratio < 0.0 || ratio > 10.0) {
                System.out.println("Error: Value must be between 0.0 and 10.0.");
                System.out.print("Year " + (i + 1) + ": ");
                ratio = input.nextDouble();
            }
            // set the second array to the value of the current itteratior of the for loop
            ratios[i] = ratio;
        }

        // calculate earnings and reset the Market value through its setter
        for (int i = 0; i < 5; i++) {
            double market = myBusiness.getProjectedEarnings()[i] * ratios[i];
            myBusiness.setMarketValue(market, i);
        }

        // styalistic inputs for the output table
        System.out.println();
        System.out.println("Year | Earnings | P/E Ratio | Market Value");
        System.out.println("---------------------------------------");
        // print out all final values, use math. round in case there are multiple decimal points
        for (int i = 0; i < 5; i++) {
            System.out.println("Year " + (i + 1) + ": $ " + Math.round(myBusiness.getProjectedEarnings()[i] * 100.0) / 100.0
                    + "  " +  ratios[i] + "  $" + Math.round(myBusiness.getMarketValue()[i] * 100.0) / 100.0);
        }
        // close scanner and end program
        input.close();
    }
}
