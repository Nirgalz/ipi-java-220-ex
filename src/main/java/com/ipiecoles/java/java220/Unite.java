package com.ipiecoles.java.java220;

import java.util.Collections;
import java.util.HashSet;

public class Unite<U>
{
    private U responsable;
    private HashSet<U> membres = new HashSet<>();


    public void ajouterMembre(U[] membres){
            Collections.addAll(this.membres,membres);

    }

    @Override
    public String toString() {
        return "Unite{" +
                "responsable=" + responsable +
                ", membres=" + membres +
                '}';
    }

    public Unite() {
    }


    public Unite(U membre) {
        this.responsable = membre;
        this.membres.add(membre);
    }

    public U getResponsable() {
        return responsable;
    }

    public void setResponsable(U responsable) {
        this.responsable = responsable;
    }

    public HashSet<U> getMembres() {
        return membres;
    }

    public void setMembres(HashSet<U> membres) {
        this.membres = membres;
    }





}
