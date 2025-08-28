public class Buisness {
    private double[] projectedEarnings;
    private double[] marketValue;

    public Buisness(double[] earnings){
        projectedEarnings = new double[5];
        marketValue = new double[5];

        for(int i=0;i<5;i++){
            marketValue[i]=0;
            projectedEarnings[i] = earnings[i];
        }
    }

    public double[] getProjectedEarnings() {
        return projectedEarnings;
    }

    // getter for market value
    public double[] getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double value, int index) {
        if(index >= 0 && index < 5){
            marketValue[index] = value;
        }
    }
    public void setMarketValue(double[] values){
        if (values.length == 5){
            for(int i = 0; i < 5; i++){
                marketValue[i] = values[i];
            }
        }
    }

}
