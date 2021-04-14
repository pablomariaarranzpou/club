/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import prog2.vista.ExcepcioClub;

/**
 *
 * @author arran
 */
public class Soci implements InSoci {

    private String nom;
    private String dni;

    public Soci(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setDNI(String dni) {
        this.dni = dni;
    }

    @Override
    public String getDNI() {
        return dni;
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
