package com.ipiecoles.java.java220;

import java.util.HashSet;

public class Manager extends Employe{

    private HashSet<Technicien> equipe = new HashSet<Technicien>();

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public void ajoutTechnicienEquipe(Technicien tech)
    {
        this.equipe.add(tech);
    }

    @Override
    public void setSalaire(Double salaire) {
        Double size = (double)this.equipe.size();
        Double result = (salaire * Entreprise.INDICE_MANAGER) ;

        super.setSalaire(result + (salaire * (size / 10.0)));
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + this.equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }
}
