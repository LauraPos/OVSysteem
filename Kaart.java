package ovSysteem;

public class Kaart {
    private double saldo;
    private String kaartnummer;
    private boolean geldigheid;
    private boolean status;
    private String huidigeHalte;
    private String beginHalte;

    // Setters
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setGeldig(boolean geldigheid){
        this.geldigheid = geldigheid;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setKaartnummer(String kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    public void setHuidigeHalte(String halte){
        this.huidigeHalte = halte;
    }

    public void setBeginHalte(String halte){
        this.beginHalte = halte;
    }

    // Getters
    public double getSaldo() {
        return saldo;
    }

    public boolean getStatus(){
        return status;
    }

    public boolean isGeldig(){
        return geldigheid;
    }

    public String getHuidigeHalte(){
        return huidigeHalte;
    }

    public String getBeginHalte(){
        return beginHalte;
    }


    // Functies
    public void saldoOphogen(double bedrag) {
        saldo += bedrag;
        System.out.println("Uw nieuwe saldo: " + saldo);
    }

    public void kaartInformatie(){
        if (geldigheid){
            System.out.println("De kaart is geldig");
        } else {
            System.out.println("De kaart is niet meer geldig");
        }

        if (status){
            System.out.println("De kaart is ingecheckt");
            System.out.println("Ingecheckt bij halte: " + beginHalte);;
        } else {
            System.out.println("De kaart is niet ingecheckt");
        }
        System.out.println("Kaartnummer: " + kaartnummer);
        System.out.println("Saldo: " + saldo);
    }
}