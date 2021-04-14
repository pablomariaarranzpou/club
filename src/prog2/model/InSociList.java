/*
 * Universitat de Barcelona
 * Programació 2
 */
package prog2.model;

import prog2.vista.ExcepcioClub;

/**
 * Interfície InSociList
 *
 * @author laura
 */
public interface InSociList {

    /**
     * Donar el número d'elemnts que hi ha actualment emmagatzemants a la
     * llista.
     *
     * @return int amb el número d'elements de la llista.
     */
    public int getSize();

    /**
     * Afegir un nou soci
     *
     * @param soci objecte per afegir a la llista.
     * @throws prog2.vista.ExcepcioClub
     */
    public void addSoci(Soci soci) throws ExcepcioClub;

    /**
     * Eliminar un objecte de la llista
     *
     * @param soci objecte per eliminar.
     * @throws prog2.vista.ExcepcioClub
     */
    public void removeSoci(Soci soci) throws ExcepcioClub;

    /**
     * Obtenir el soci guardat a una certa posició donada
     *
     * @param position posició a la llista de socis.
     * @return objecte soci a la posició donada o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getAt(int position) throws ExcepcioClub;

    /**
     * Obtenir el soci donat el seu DNI
     *
     * @param dni DNI del soci al que volem accedir.
     * @return Objecte soci amb el dni donat o null si no existeix.
     * @throws prog2.vista.ExcepcioClub
     */
    public Soci getSoci(String dni) throws ExcepcioClub;

    /**
     * Eliminar tots els elements de la llista
     *
     * @throws prog2.vista.ExcepcioClub
     */
    public void clear() throws ExcepcioClub;

    /**
     * Comprovar si la llista està a la seva capacitat màxima o no.
     *
     * @return True si la llista està plena (no hi ha lloc per més elements) o
     * false sinó.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isFull() throws ExcepcioClub;

    /**
     * Comprovar si la llista està buida o no.
     *
     * @return True si la llista està buida (no hi ha cap elements) o false
     * sinó.
     * @throws prog2.vista.ExcepcioClub
     */
    public boolean isEmpty() throws ExcepcioClub;

}
