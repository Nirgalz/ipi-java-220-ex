package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {

    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;


    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public Employe()
    {


    }



    public final Integer getNombreAnneeAnciennete()
    {
        Calendar now = Calendar.getInstance();
        Integer year = now.get(Calendar.YEAR);


        return year - this.dateEmbauche.getYear() ;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception{

        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now()))
        {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }

        this.dateEmbauche = dateEmbauche;
    }

    public Integer getNbConges(){
         return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employe employe = (Employe) o;

        if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
        if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
        if (matricule != null ? !matricule.equals(employe.matricule) : employe.matricule != null) return false;
        if (dateEmbauche != null ? !dateEmbauche.equals(employe.dateEmbauche) : employe.dateEmbauche != null)
            return false;
        return salaire != null ? salaire.equals(employe.salaire) : employe.salaire == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom,prenom,matricule,dateEmbauche,salaire);
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }


    public abstract Double getPrimeAnnuelle();

    public void augmenterSalaire(Double pourcentage){
        this.salaire += (this.salaire * pourcentage);
    }


}

