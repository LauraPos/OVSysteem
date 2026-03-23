package ovSysteem;

public class Paal {
    private String[] haltes;
    private double[][] prijzen;

    // Setters
    public void setHaltes(String[] haltes){
        this.haltes = haltes;
    }

    public void setPrijzen(double[][] prijzen){
        this.prijzen = prijzen;
    }

    // Getters
    public String[] getHaltes(){
        return haltes;
    }

    public double[][] getPrijzen(){
        return prijzen;
    }
}
