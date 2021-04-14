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

    private final ArrayList<Soci> _llistaSocis;
    private int _capacitatMax = 100;

    public LlistaSocis() {
        _capacitatMax = 100;
        _llistaSocis = new ArrayList<>(_capacitatMax);
    }

    public LlistaSocis(int capacitatMax) {
        _capacitatMax = capacitatMax;
        _llistaSocis = new ArrayList<>(_capacitatMax);
    }

    @Override
    public int getSize() {
        return _llistaSocis.size();
    }

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        if (isFull()) {
            throw new ExcepcioClub("No es poden afegir més socis.");
        } else if (contains(soci)) {
            throw new ExcepcioClub("Aquest soci ja existeix.");
        } else {
            _llistaSocis.add(soci);
        }
    }

    @Override
    public void removeSoci(Soci soci) {
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
        throw new ExcepcioClub("Soci no trobat.");
    }

    @Override
    public void clear() throws ExcepcioClub {
        _llistaSocis.clear();
    }

    @Override
    public boolean isFull() throws ExcepcioClub {
        return _llistaSocis.size() >= _capacitatMax;
    }

    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return _llistaSocis.isEmpty();
    }

    @Override
    public String toString() {
        String impr = "LLISTA: \n";
        for (Soci soci : _llistaSocis) {
            impr += soci.toString() + " \n";
        }
        return impr;
    }

    private boolean contains(Soci soci) {
        for (Soci sociLlista : _llistaSocis) {
            if (soci.equals(sociLlista)) {
                return true;
            }
        }
        return false;
    }
}
