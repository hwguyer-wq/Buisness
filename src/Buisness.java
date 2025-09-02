//This class represents a buisness with attributes of its earnings and the projected market value with getters and setters
//It also has a constructor
//
//@author Hunter Guyer Sep 2 2025

public class Buisness {
    //intialize arrays
    private double[] projectedEarnings;
    private double[] marketValue;
    //constructor
    public Buisness(double[] earnings){
        projectedEarnings = new double[5];
        marketValue = new double[5];

        // initalize the value to 0 and the earnings to what we will give through our inputs
        for(int i = 0; i < 5; i++){
            marketValue[i]=0;
            projectedEarnings[i] = earnings[i];
        }
    }

    // getters and setters
    public double[] getProjectedEarnings() {
        return projectedEarnings;
    }

    // getter for market value
    public double[] getMarketValue() {
        return marketValue;
    }
    // set the market value to what  we will give in the other class and the index we give it
    public void setMarketValue(double value, int index) {
        if(index >= 0 && index < 5){
            marketValue[index] = value;
        }
    }

}
