/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.ExcepcioClub;

/**
 * Classe llista socis on emagatzem el objectes de tipus Soci.
 *
 * @author arran
 */
public class LlistaSocis implements InSociList, Serializable {

    private final ArrayList<Soci> _llistaSocis;
    private int _capacitatMax = 100;

    /**
     * Métode constructor de llista socis
     */
    public LlistaSocis() {
        _capacitatMax = 100;
        _llistaSocis = new ArrayList<>(_capacitatMax);
    }

    /**
     * Llista constructor amb máxim.
     *
     * @param capacitatMax
     */
    public LlistaSocis(int capacitatMax) {
        _capacitatMax = capacitatMax;
        _llistaSocis = new ArrayList<>(_capacitatMax);
    }

    /**
     * Retorna la mida de la llista de socis
     *
     * @return
     */
    @Override
    public int getSize() {
        return _llistaSocis.size();
    }

    /**
     * Afegeix un soci a la llista de soci si no el conté encara.
     *
     * @param soci
     * @throws ExcepcioClub
     */
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

    /**
     * Elimina un soci de la llista socis
     *
     * @param soci
     */
    @Override
    public void removeSoci(Soci soci) {
        _llistaSocis.remove(soci);
    }

    /**
     * Retorna un soci a una posició en concret
     *
     * @param position
     * @return
     * @throws ExcepcioClub
     */
    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        if (position > _llistaSocis.size()) {
            throw new ExcepcioClub("No existeix un soci en aquesta posició.");
        }
        return _llistaSocis.get(position);
    }

    /**
     * Retorna un soci amb un DNI concret
     *
     * @param dni
     * @return
     * @throws ExcepcioClub
     */
    @Override
    public Soci getSoci(String dni) throws ExcepcioClub {
        for (int i = 0; i < _llistaSocis.size(); i++) {
            if (_llistaSocis.get(i).getDNI().equals(dni)) {
                return _llistaSocis.get(i);
            }
        }
        throw new ExcepcioClub("Soci no trobat.");
    }

    /**
     * Buida la llista de socis.
     *
     * @throws ExcepcioClub
     */
    @Override
    public void clear() throws ExcepcioClub {
        _llistaSocis.clear();
    }

    /**
     * Retorna true si la llista a arribat a la seva capacitat màxima.
     *
     * @return
     * @throws ExcepcioClub
     */
    @Override
    public boolean isFull() throws ExcepcioClub {
        return _llistaSocis.size() >= _capacitatMax;
    }

    /**
     * Retorna true si no hi ha cap element a la llista.
     *
     * @return
     * @throws ExcepcioClub
     */
    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return _llistaSocis.isEmpty();
    }

    /**
     * Retorna la llista a una string
     *
     * @return string
     */
    @Override
    public String toString() {
        String impr = "LLISTA: \n";
        for (Soci soci : _llistaSocis) {
            impr += soci.toString() + " \n";
        }
        return impr;
    }

    /**
     * Indica amb un boolea si existeix o no un soci a la llista
     *
     * @return boolean
     */
    private boolean contains(Soci soci) {
        for (Soci sociLlista : _llistaSocis) {
            if (soci.equals(sociLlista)) {
                return true;
            }
        }
        return false;
    }
}
