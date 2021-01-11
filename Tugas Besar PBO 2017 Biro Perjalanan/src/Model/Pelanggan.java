/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jeremi
 */
public class Pelanggan extends Orang{
    private static int countM = 1;
    
    private final String idPelanggan;
    private String pekerjaan;

    public Pelanggan(String pekerjaan, String nama, String noHp, String alamat, String jenisKelamin, String tglLahir) {
        super(nama, noHp, alamat, jenisKelamin, tglLahir);
        idPelanggan = "M-" + (countM++);
        this.pekerjaan = pekerjaan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    @Override
    public String toString() {
        return  "idPelanggan  : " + idPelanggan + "\n" +
                "nama         : " + getNama() + "\n" + 
                "noHp         : " + getNoHp() + "\n" +
                "alamat       : " + getAlamat() + "\n" +
                "jenisKelamin : " + getJenisKelamin() + "\n" +
                "tglLahir     : " + getTglLahir()+ "\n" +
                "pekerjaan    : " + pekerjaan ;
    }
    
    public String toStringAll() {
        return idPelanggan + " , " + getNama() + " , " + getNoHp() + " , " + getAlamat() + " , " + getJenisKelamin() + " , " + getTglLahir() + " , " + pekerjaan;
    }
}
