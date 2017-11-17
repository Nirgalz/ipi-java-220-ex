package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

enum Note{
    INSUFFISANT, PASSABLE, BIEN, TRES_BIEN
}

public  class Commercial extends Employe{

    private Double caAnnuel;
    private  Integer performance;


    public Note equivalenceNote()
    {
        switch (this.performance){
            case 0 :
                return Note.INSUFFISANT;
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return Note.INSUFFISANT;
        }
    }
    public Integer isPerformance()
    {
        return this.performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }



    public boolean performanceEgale(Integer perf)
    {
        if (performance.equals(perf)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Double getPrimeAnnuelle() {

        Double prime;
        if (caAnnuel == null || caAnnuel == 0) caAnnuel = 0.0;

        prime = Math.ceil(caAnnuel * 0.05);

        if (prime<500) prime = 500.0;

        return prime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Commercial that = (Commercial) o;

        return caAnnuel.equals(that.caAnnuel);
    }

    public Commercial(){

    }


    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public Commercial(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }



}

