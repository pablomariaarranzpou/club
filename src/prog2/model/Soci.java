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


    protected String _nom;
    protected String _dni;

    /**
     *Constructor per defecte de la classe Soci
     * @param nom
     * @param dni
     */
    public Soci(String nom, String dni) {
        _nom = nom;
        _dni = dni;
    }

    /**
     * Setter del nom d´un soci
     * @param nom
     */
    @Override
    public void setNom(String nom) {
        _nom = nom;
    }

    /**
     * Getter del nom d´un Soci
     * @return
     */
    @Override
    public String getNom() {
        return _nom;
    }

    /**
     * Setter del DNI d´un Soci
     * @param dni
     */
    @Override
    public void setDNI(String dni) {
        _dni = dni;
    }

    /**
     * Getter del Nom d´un soci.
     * @return
     */
    @Override
    public String getDNI() {
        return _dni;
    }
    
    /**
     * Métode abstracte implmentat a les classes filles( veure classes filles)
     * @return
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public abstract float calculaQuota(float quotaBase) throws ExcepcioClub;
    
    /**
     * Métode abstracte implmentat a les classes filles( veure classes filles)
     * @return
     * @throws prog2.vista.ExcepcioClub
     */
    @Override
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;

    /**
     * Métode abstracte implmentat a les classes filles( veure classes filles)
     * @return
     */
    @Override
    public abstract String toString();

    /**
     * Retorna si un objecte el seu dni es igual
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Soci soci = (Soci) obj;
        return _dni.equals(soci.getDNI());
    }

}
