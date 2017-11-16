package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public  class Commercial extends Employe{

    private Double caAnnuel;
    private  Integer performance;
    private enum notes{
        INSUFFISANT, PASSABLE, BIEN, TRES_BIEN
    }

//    public static notes equivalenceNote()
//    {
//        switch (this.performance){
//            case 0 :
//                return notes.INSUFFISANT;
//        }
//    }


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
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
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

