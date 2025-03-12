//Beispiel für das Referat
//Fahrzeuge (Auto & Motorrad) definieren, erstellen und Methoden ausführen

class Fahrzeug {
    // Verkapselung Schritt 1: private Variablen
    private String marke;
    private String modell;
    private int baujahr;
    private String farbe;
    private boolean motorLaeuft;
    private double fuellstand;
    private double getankterSprit;
    private int fahrtzeit = 30; 

    // Konstruktor(Bauplan): Gibt an, welche Attribute das Objekt "Fahrzeug" haben soll
    public Fahrzeug(String marke, String modell, int baujahr, String farbe, double fuellstand) {
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.farbe = farbe;
        this.fuellstand = fuellstand;
        this.motorLaeuft = false;
        this.getankterSprit = 0.0; //Basiswert vom getankten Sprit ist 0; Es wurde noch nicht getankt
    }

    // Verkapselung Schritt 2: "Getter" Methode um die Werte der privaten Variablen zu erhalten
    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public String getFarbe() {
        return farbe;
    }
    
    public double getFuellstand() {
        return fuellstand;
    }
    
    public double getGetankterSprit() { 
        return getankterSprit;
    }
    
    public boolean istMotorLaeuft() {
        return motorLaeuft;
    }
    
    public int getFahrtzeit() {
        return this.fahrtzeit;
    }
    
    // Methoden, die für alle Fahrzeuge gelten
    public void motorStarten() {
        motorLaeuft = true;
        System.out.println("Der Motor läuft jetzt.");
    }

    public void motorStoppen() {
        motorLaeuft = false;
        System.out.println("Du hast den Motor aus gemacht.");
    }
    
    public void tanken() {
        if(fuellstand < 0.8) {
            getankterSprit = (1 - fuellstand) * 10;
            this.fuellstand = 1;
            System.out.println("Du warst gerade tanken. Dein Tank ist wieder voll.");
        }
        else if(fuellstand >= 0.8) {
            System.out.println("Du warst doch erst tanken.");
        }
    }

    // Polymorphismus: Methode, welche später von den Unterkalssen überschrieben wird
    public void fahren() {
        if (motorLaeuft) {
            System.out.println("Das Fahrzeug bewegt sich.");
        } else {
            System.out.println("Kann nicht fahren. Der Motor läuft nicht.");
        }
    }
    
   
    public void fahren(int fahrtzeit) {
        System.out.println("Du bist " + fahrtzeit + " Minuten lang gefahren.");
    }
    
    // getInfo
    public String getInfo() {
        return "Baujahr: "+ baujahr +" " + marke + " " + modell + " " + farbe;
    }
}

//Auto-Klasse erbt von Fahrzeug
class Auto extends Fahrzeug {
    private int anzahlTueren;

    // Konstruktor für Autos
    public Auto(String marke, String modell, int baujahr, String farbe, double fuellstand, int anzahlTueren){
        // Aufruf des Konstruktors der Elternklasse
        super(marke, modell, baujahr, farbe, fuellstand);
        this.anzahlTueren = anzahlTueren;
    }
    
    // Wenn man keine Anzahl für die Türen angibt, werden automatisch 4 genommen
    public Auto(String marke, String modell, int baujahr, String farbe, double fuellstand) {
        super(marke, modell, baujahr, farbe, fuellstand);
        this.anzahlTueren = 4;
    }
    
    public int getAnzahlTueren() {
        return this.anzahlTueren;
    }
    
    // Polymorphismus: fahren() wird überschrieben
    @Override
    public void fahren() {
        if (istMotorLaeuft()) {
            System.out.println("Das Auto fährt mit 100 Sachen 80.");
        } else {
            System.out.println("Der Motor läuft nicht.");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Türen: " + anzahlTueren;
    }
}

//Motorrad-Klasse erbt auch von Fahrzeug
class Motorrad extends Fahrzeug {
    private int motorGroesse; // motorGroesse = cc
    // fahrtzeit-Variable wurde in die Basisklasse verschoben

    // Konstruktor
    public Motorrad(String marke, String modell, int baujahr, String farbe, int motorGroesse, double fuellstand) {
        super(marke, modell, baujahr, farbe, fuellstand);
        this.motorGroesse = motorGroesse;
    }

    public int getMotorGroesse() {
        return this.motorGroesse;
    }
    


    // Spezifische Methode für Motorrad
    public void wheelieVersuch() {
        double glueck = Math.random(); // Variable umbenannt
        if(istMotorLaeuft() && glueck >= 0.5) {
            System.out.println("Tim macht einen Wheelie!");
        } else if (istMotorLaeuft()){
            System.out.println("Aua. Tim hat einen Unfall gebaut. Hoffentlich ist er versichert.");
        } else {
            System.out.println("Kann keinen Wheelie machen. Der Motor läuft nicht.");
        }
    }

    // Polymorphismus: fahren() wird überschrieben
    @Override
    public void fahren() {
        if (istMotorLaeuft()) {
            System.out.println("Das Motorrad rast die Straße entlang mit seinem " + 
                motorGroesse + "cc Motor!");
        } else {
            System.out.println("Das Motorrad kann nicht fahren. Der Motor läuft nicht.");
        }
    }
   

    @Override
    public String getInfo() {
        return super.getInfo() + " Motorgröße: " + motorGroesse + "cc";
    }
}

public class Referat {
    public static void main(String[] args) {
        // Objekt der KLasse Auto erstellen
        Auto erstesAuto = new Auto("Audi", "A4", 2000, "Rot", 0.4, 4);
        Auto zweitesAuto = new Auto("Audi", "A7", 2025, "Mattschwarz", 1, 4);

        // Objekt der KLasse Motorrad erstellen
        Motorrad erstesMotorrad = new Motorrad("Honda", "CBR", 2023, "Rot", 600, 0.5);
        Motorrad zweitesMotorrad = new Motorrad("Ninja", "H2R", 2021, "Schwarz", 1000, 0.8);
        
        
        ////// Funktionen ausführen
        
        System.out.println("Informationen zum ersten Auto: "+ erstesAuto.getInfo() + "");
        erstesAuto.motorStarten();
        erstesAuto.fahren();
        erstesAuto.motorStoppen();
        erstesAuto.tanken();
        System.out.println();

        ///Wenn man möchte, könnte man die Funktionen ausbauen und von einem zweiten Objekt ausführen lassen
        
        System.out.println("Informationen zum zweiten Auto: "+ zweitesAuto.getInfo());
        /*zweitesAuto.motorStarten();
        zweitesAuto.fahren();
        zweitesAuto.motorStoppen();
        zweitesAuto.tanken();
        */System.out.println();
        
        
        
        System.out.println("Informationen zum ersten Motorrad: "+ erstesMotorrad.getInfo());
        erstesMotorrad.motorStarten();
        erstesMotorrad.fahren();
        erstesMotorrad.wheelieVersuch();
        erstesMotorrad.motorStoppen();
        erstesMotorrad.fahren(30);
    }

    //UML-Klassendiagramm mit code; Wenn man sich die mühe machen möchte
    public static void umlDiagrammAusgeben() {
        System.out.println("+-------------------+");
        System.out.println("|     Fahrzeug      |");
        System.out.println("+-------------------+");
        System.out.println("| - marke           |");
        System.out.println("| - modell          |");
        System.out.println("| - baujahr         |");
        System.out.println("| - farbe           |");
        System.out.println("| - motorLaeuft     |");
        System.out.println("| - fuellstand      |"); 
        System.out.println("| - getankterSprit  |");
        System.out.println("| - fahrtzeit       |");
        System.out.println("+-------------------+");
        System.out.println("| + motorStarten()  |");
        System.out.println("| + motorStoppen()  |");
        System.out.println("| + tanken()        |"); 
        System.out.println("| + fahren()        |");
        System.out.println("| + fahren(int)     |");
        System.out.println("| + getFahrtzeit()  |");
        System.out.println("| + getInfo()       |");
        System.out.println("+-------------------+");
        System.out.println("          ^");
        System.out.println("          |");
        System.out.println("+---------+---------+");
        System.out.println("|                   |");
        System.out.println("+------------------------+-------------------+");
        System.out.println("|       Auto             |     Motorrad      |");
        System.out.println("+------------------------+-------------------+");
        System.out.println("| - anzahlTueren         | - motorGroesse    |");
        System.out.println("+------------------------+-------------------+");
        System.out.println("| + fahren()             | + fahren()        |");
        System.out.println("|                        | + wheelieVersuch()|"); 
        System.out.println("+------------------------+-------------------+");
    }
}