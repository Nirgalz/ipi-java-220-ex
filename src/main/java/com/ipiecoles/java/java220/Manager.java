package com.ipiecoles.java.java220;

import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.*;
import java.util.stream.Collectors;

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

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) throws TechnicienException
    {
        Technicien tech = new Technicien(nom,prenom,matricule,dateEmbauche,salaire,grade);
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

    @Override
    public void augmenterSalaire(Double pourcentage) {
        super.augmenterSalaire(pourcentage);
        augmenterSalaireEquipe( pourcentage);

    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien technicien : equipe) {
            technicien.augmenterSalaire(pourcentage);
        }
    }

    public List equipeParGrade(){
        return equipe.stream().sorted(Comparator.comparing(Technicien::getGrade, Collections.reverseOrder())).
                collect(Collectors.toList());
    }

    public Double salaireEquipeGrade1()
    {

        Double result = 0.;
        for (Technicien t : equipe.stream().filter(p->p.getGrade() ==1).collect(Collectors.toList())){
            result += t.getSalaire();
        }

        return result;
    }


}
