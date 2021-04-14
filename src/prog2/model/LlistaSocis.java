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
        _llistaSocis = new ArrayList<>(100);
    }

    @Override
    public int getSize() {
        return _llistaSocis.size();
    }

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        _llistaSocis.add(soci);
    }

    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub {
        _llistaSocis.remove(soci);
    }

    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        return _llistaSocis.get(position);
    }

    @Override
    public Soci getSoci(String dni) throws ExcepcioClub {
        for (int i = 0; i < _llistaSocis.size(); i++) {
            if (_llistaSocis.get(i).getDNI().equals(dni)) {
                return _llistaSocis.get(i);
            }
        }
        return null;
    }

    @Override
    public void clear() throws ExcepcioClub {
        _llistaSocis.clear();
    }

    @Override
    public boolean isFull() throws ExcepcioClub {
        return _llistaSocis.size() == 100;
    }

    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return _llistaSocis.isEmpty();
    }

    @Override
    public String toString() {
        String impr = "LLISTA: \n";
        for (int i = 0; i < this._llistaSocis.size(); i++) {
            if (_llistaSocis.get(i) instanceof SociFederat) {
                SociFederat soci = (SociFederat) _llistaSocis.get(i);
                impr += soci.toString() + " \n";
            } else if (_llistaSocis.get(i) instanceof SociEstandard) {
                SociEstandard soci = (SociEstandard) _llistaSocis.get(i);
                impr += soci.toString() + "\n";
            } else if(_llistaSocis.get(i) instanceof SociJunior){
                SociJunior soci = (SociJunior) _llistaSocis.get(i);
                impr += soci.toString() + "\n";
            }
        }
        return impr;
    }

}
