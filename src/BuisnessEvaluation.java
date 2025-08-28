import java.util.Scanner;

public class BuisnessEvaluation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] earnings = new double[5];
        double[] ratios = new double[5];


        System.out.println("Enter projected earnings for 5 years ($200000 to $500000):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Year " + (i + 1) + ": $");
            double earning = input.nextDouble();

            while (earning < 200000 || earning > 500000) {
                System.out.println("Number has to be between 200000 and 500000.");
                System.out.print("Year " + (i + 1) + ": $");
                earning = input.nextDouble();
            }
            earnings[i] = earning;
        }
        Buisness myBusiness = new Buisness(earnings);

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
            ratios[i] = ratio;
        }

        for (int i = 0; i < 5; i++) {
            double market = myBusiness.getProjectedEarnings()[i] * ratios[i];
            myBusiness.setMarketValue(market, i);
        }

        System.out.println();
        System.out.println("Year | Earnings | P/E Ratio | Market Value");
        System.out.println("---------------------------------------");

        for (int i = 0; i < 5; i++) {
            System.out.println("Year " + (i + 1) + ": $ " + Math.round(myBusiness.getProjectedEarnings()[i] * 100) / 100.0
                    + "  " +  ratios[i] + "  $" + Math.round(myBusiness.getMarketValue()[i] * 100) / 100.0);
        }

        input.close();
    }
}
