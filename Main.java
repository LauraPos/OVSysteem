package ovSysteem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Kaart krt = new Kaart();
        Paal pl = new Paal();

        //initialize
        krt.setSaldo(30.0);
        krt.setGeldig(true);
        krt.setStatus(false);
        krt.setKaartnummer("0101010");
        krt.setHuidigeHalte("Nijmegen Centraal");
        krt.setBeginHalte(krt.getHuidigeHalte());

        // haltes en prijzen
        pl.setHaltes(new String[]{
                "Nijmegen Centraal",
                "Arnhem Centraal",
                "Amsterdam Centraal",
                "Rotterdam Centraal",
                "Eindhoven Centraal"
        });

        pl.setPrijzen(new double[][]{
                {0, 5, 12.5, 10, 7.5},
                {5, 0, 7.5, 8, 6},
                {12.5, 7.5, 0, 6, 10},
                {10, 8, 6, 0, 9},
                {7.5, 6, 10, 9, 0}
        });

        // Start
        int keuze = 0;

        while (keuze != 4) {

            System.out.println("1. Saldo opladen");
            System.out.println("2. Kaart informatie");
            System.out.println("3. Reizen");
            System.out.println("4. Stop");

            keuze = sc.nextInt();

            //Saldo ophogen
            if (keuze == 1) {
                System.out.println("Met hoeveel euro wil je ophogen?");
                double geld = sc.nextDouble();
                krt.saldoOphogen(geld);
            }
            //Kaart informatie laten zien
            else if (keuze == 2) {
                krt.kaartInformatie();
            }
            //Het reizen
            else if (keuze == 3){

                System.out.println("Je bent nu op: " + krt.getHuidigeHalte());

                String[] haltes = pl.getHaltes();
                double[][] prijzen = pl.getPrijzen();

                // huidige index zoeken
                int huidigeIndex = 0;
                for (int i = 0; i < haltes.length; i++) {
                    if (haltes[i].equals(krt.getHuidigeHalte())) {
                        huidigeIndex = i;
                    }
                }

                // Locatie kiezen
                if (!krt.getStatus()) {

                    System.out.println("\nKies je bestemming:");

                    for (int i = 0; i < haltes.length; i++) {
                        System.out.println((i + 1) + ". " + haltes[i]);
                    }

                    int keuzeHalte = sc.nextInt();
                    int nieuweIndex = keuzeHalte - 1;

                    if (nieuweIndex == huidigeIndex) {
                        System.out.println("Je bent al hier!");
                        continue;
                    }

                    double prijs = prijzen[huidigeIndex][nieuweIndex];

                    if (krt.getSaldo() >= prijs) {
                        System.out.println("Je checkt in!");
                        krt.setStatus(true);

                        System.out.println("Je reist van " + haltes[huidigeIndex] + " naar " + haltes[nieuweIndex]);
                        System.out.println("Kosten: €" + prijs);

                        krt.setSaldo(krt.getSaldo() - prijs);
                        krt.setHuidigeHalte(haltes[nieuweIndex]);

                        huidigeIndex = nieuweIndex;
                    } else {
                        System.out.println("Niet genoeg saldo!");
                        continue;
                    }
                }

                // keuze menu
                boolean bezig = true;

                while (bezig) {

                    System.out.println("\nJe bent ingecheckt.");
                    System.out.println("1. Verder reizen");
                    System.out.println("2. Uitchecken");
                    System.out.println("3. Kaartinformatie tonen");

                    int reisKeuze = sc.nextInt();

                    // uitchecken
                    if (reisKeuze == 2) {
                        System.out.println("Je bent uitgecheckt.");
                        krt.setStatus(false);
                        bezig = false;
                        break;
                    }

                    // Kaartinformatie tonen
                    if (reisKeuze == 3){
                        krt.kaartInformatie();
                        continue;
                    }

                    // verder reizen
                    System.out.println("\nMogelijke bestemmingen:");

                    for (int i = huidigeIndex + 1; i < haltes.length; i++) {
                        System.out.println((i + 1) + ". " + haltes[i]);
                    }

                    int keuzeHalte = sc.nextInt();
                    int nieuweIndex = keuzeHalte - 1;

                    if (nieuweIndex <= huidigeIndex || nieuweIndex >= haltes.length) {
                        System.out.println("Alleen vooruit reizen!");
                        continue;
                    }

                    double prijs = prijzen[huidigeIndex][nieuweIndex];

                    if (krt.getSaldo() >= prijs) {
                        System.out.println("Je reist naar " + haltes[nieuweIndex]);
                        System.out.println("Kosten: €" + prijs);

                        krt.setSaldo(krt.getSaldo() - prijs);
                        krt.setHuidigeHalte(haltes[nieuweIndex]);

                        huidigeIndex = nieuweIndex;
                    } else {
                        System.out.println("Niet genoeg saldo!");
                    }
                }
            }

            // Programma stoppen
            else if (keuze == 4){
                System.out.println("Programma gestopt.");
            }

            // ongeldig nummer
            else {
                System.out.println("Ongeldige keuze.");
            }
        }

        sc.close();
    }
}