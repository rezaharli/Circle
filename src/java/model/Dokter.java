/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Reza Harli
 */
public class Dokter {
    private String id;
    private String nama;
    private String harga;
    private String idKlaim;

    public Dokter(String id, String nama, String harga, String idKlaim) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.idKlaim = idKlaim;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the harga
     */
    public String getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(String harga) {
        this.harga = harga;
    }

    /**
     * @return the idKlaim
     */
    public String getIdKlaim() {
        return idKlaim;
    }

    /**
     * @param idKlaim the idKlaim to set
     */
    public void setIdKlaim(String idKlaim) {
        this.idKlaim = idKlaim;
    }
    
    
}
