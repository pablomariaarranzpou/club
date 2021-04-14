/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.ArrayList;
import prog2.vista.ExcepcioClub;

/**
 *
 * @author arran
 */
public class LlistaSocis implements InSociList {
    
    private ArrayList<Soci> _llistaSocis;

    public LlistaSocis() {
        this._llistaSocis = new ArrayList<Soci>(100);
    }
    
    
    @Override
    public int getSize() {
        return this._llistaSocis.size();
    }

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        this._llistaSocis.add(soci);
    }

    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub {
        this._llistaSocis.remove(soci);
    }

    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        return this._llistaSocis.get(position);
    }

    @Override
    public Soci getSoci(String dni) throws ExcepcioClub {
        for (int i = 0; i < this._llistaSocis.size(); i++) {
            if (this._llistaSocis.get(i).getDNI().equals(dni)){
                return this._llistaSocis.get(i);
            } 
        }
        return null;
    }

    @Override
    public void clear() throws ExcepcioClub {
        this._llistaSocis.clear();
    }

    @Override
    public boolean isFull() throws ExcepcioClub {
        return this._llistaSocis.size() == 100;
    }

    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return this._llistaSocis.isEmpty();
    }
    
}
