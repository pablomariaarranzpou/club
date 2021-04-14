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
public class SociFederat extends Soci{
    
    public SociFederat(String nom, String dni) {
        super(nom, dni);
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
