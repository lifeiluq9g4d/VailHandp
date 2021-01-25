/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Jeremi
 */

public abstract class Orang implements Serializable{
    private String nama;
    private String noHp;
    private String alamat;
    private String jenisKelamin;
    private String tglLahir;

    public Orang(String nama, String noHp, String alamat, String jenisKelamin, String tglLahir) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.tglLahir = tglLahir;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }   
}
