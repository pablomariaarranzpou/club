/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author arran
 */
public abstract class Soci implements InSoci, Serializable {

    private String _nom;
    private String _dni;

    public Soci(String nom, String dni) {
        _nom = nom;
        _dni = dni;
    }

    @Override
    public void setNom(String nom) {
        _nom = nom;
    }

    @Override
    public String getNom() {
        return _nom;
    }

    @Override
    public void setDNI(String dni) {
        _dni = dni;
    }

    @Override
    public String getDNI() {
        return _dni;
    }

    @Override
    public abstract float calculaQuota(float quotaBase) throws ExcepcioClub;

    @Override
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;

    @Override
    public abstract String toString();

}
