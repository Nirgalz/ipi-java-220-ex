package com.ipiecoles.java.java220;
import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien>{

    private Integer grade;


    public Technicien()
    {

    }

    @Override
    public void setSalaire(Double salaire) {
        salaire += (salaire * (this.grade * 10)/100);
        super.setSalaire(salaire);
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) throws TechnicienException {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.setGrade(grade);
    }
    public Double getPrimeAnnuelle() {
        Double salaireBase = Entreprise.primeAnnuelleBase();
        return salaireBase + salaireBase * (1 + (double) grade / 10) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }


    @Override
    public Integer getNbConges() {
        return super.getNbConges() + getNombreAnneeAnciennete();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) throws TechnicienException {
        if (grade <= 0 || grade > 5){
            throw new TechnicienException(TechnicienException.GRADE, this, grade);
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                "} " + super.toString();
    }


    @Override
    public int compareTo(Technicien o) {
        return Integer.compare(o.getGrade(), this.grade);
    }
}
