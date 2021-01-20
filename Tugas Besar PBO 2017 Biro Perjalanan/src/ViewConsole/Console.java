/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewConsole;
import Model.Aplikasi;
import Model.PaketWisata;
import Model.Pelanggan;
import Model.Perjalanan;
import Model.Petugas;
import Model.TempatWisata;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kukuh Rahingga P
 */
public class Console {
    private Aplikasi model;
    private Scanner cinInt;
    private Scanner cinStr;
    
    public Console (Aplikasi model){
        this.model = model;
        cinInt = new Scanner (System.in);
        cinStr = new Scanner (System.in);
    }
    
    public int inputInteger(){
        try {
            return cinInt.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input harus integer");
        } finally {
            cinInt = new Scanner(System.in);
        }
    }
    
    public void menuPelanggan() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Pelanggan -------");
                System.out.println("- 1. Tambah pelanggan        ");
                System.out.println("- 2. Hapus pelanggan         ");
                System.out.println("- 3. Lihat semua pelanggan   ");
                System.out.println("- 4. Cari pelanggan by ID    ");
                System.out.println("- 5. Cari pelanggan by Index ");
                System.out.println("- 0. Kembali                 ");
                System.out.println("-----------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Pelanggan ---");
                        System.out.print(" - Nama           : "); String nama = cinStr.nextLine();
                        System.out.print(" - Pekerjaan      : "); String pekerjaan = cinStr.nextLine();
                        System.out.print(" - noHp           : "); String noHp = cinStr.nextLine();
                        System.out.print(" - Alamat         : "); String alamat = cinStr.nextLine();
                        System.out.print(" - Jenis Kelamin  : "); String jenisKelamin = cinStr.nextLine();
                        System.out.print(" - Tanggal lahir  : "); String tglLahir = cinStr.nextLine();
                        model.createPelanggan (pekerjaan, nama, noHp, alamat, jenisKelamin, tglLahir);
                        pekerjaan = null;
                        break;
                    case 2:
                        System.out.println("--- Hapus Pelanggan ---");
                        System.out.print(" - Id pelanggan : "); String id = cinStr.nextLine();
                        model.removePelanggan(id);
                        break;    
                    case 3:
                        System.out.println("--- Daftar Pelanggan ---");
                        model.viewListConsole(model.getListPelanggan());
                        break;
                    case 4:
                        System.out.println("--- Cari Pelanggan by ID ---");
                        System.out.print(" - Masukkan id pelanggan : "); id = cinStr.nextLine();
                        Pelanggan e = model.getPelanggan(id);
                        System.out.println(e);
                        break;
                    case 5:
                        System.out.println("--- Cari Pelanggan by Index ---");
                        System.out.print(" - Masukkan index pelanggan : "); int index = inputInteger();
                        e = model.getPelanggan(index);
                        System.out.println(e);
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void menuPetugas() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Petugas -------");
                System.out.println("- 1. Tambah Petugas        ");
                System.out.println("- 2. Hapus Petugas         ");
                System.out.println("- 3. Lihat semua petugas   ");
                System.out.println("- 4. Cari Petugas by ID    ");
                System.out.println("- 5. Cari Petugas by Index ");
                System.out.println("- 0. Kembali               ");
                System.out.println("---------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Petugas ---");
                        System.out.print(" - Nama           : "); String nama = cinStr.nextLine();
                        System.out.print(" - Jabatan        : "); String jabatan = cinStr.nextLine();
                        System.out.print(" - Gaji           : "); double gaji = inputInteger();
                        System.out.print(" - noHp           : "); String noHp = cinStr.nextLine();
                        System.out.print(" - Alamat         : "); String alamat = cinStr.nextLine();
                        System.out.print(" - Jenis Kelamin  : "); String jenisKelamin = cinStr.nextLine();
                        System.out.print(" - Tanggal lahir  : "); String tglLahir = cinStr.nextLine();
                        model.createPetugas(gaji, jabatan, nama, noHp, alamat, jenisKelamin, tglLahir);
                        break;
                    case 2:
                        System.out.println("--- Hapus Petugas ---");
                        System.out.print(" - Id Petugas : "); String id = cinStr.nextLine();
                        model.removePetugas(id);
                        break;
                    case 3:
                        System.out.println("--- Daftar Petugas ---");
                        model.viewListConsole(model.getListPetugas());
                        break;
                    case 4:
                        System.out.println("--- Cari Petugas by ID ---");
                        System.out.print(" - Masukkan id Petugas : "); id = cinStr.nextLine();
                        Petugas e = model.getPetugas(id);
                        System.out.println(e);
                        break;
                    case 5:
                        System.out.println("--- Cari Petugas by Index ---");
                        System.out.print(" - Masukkan index Petugas : "); int index = inputInteger();
                        e = model.getPetugas(index);
                        System.out.println(e);
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void menuTempatWisata() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Tempat Wisata -------");
                System.out.println("- 1. Tambah Tempat Wisata        ");
                System.out.println("- 2. Hapus Tempat Wisata         ");
                System.out.println("- 3. Lihat semua Tempat Wisata   ");
                System.out.println("- 4. Cari Tempat Wisata by ID    ");
                System.out.println("- 5. Cari Tempat Wisata by Index ");
                System.out.println("- 0. Kembali                     ");
                System.out.println("---------------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Tempat Wisata ---");
                        System.out.print(" - Nama tempat wisata : "); String namaWisata = cinStr.nextLine();
                        System.out.print(" - Lokasi             : "); String lokasiWisata = cinStr.nextLine();
                        model.createTempatWisata(namaWisata, lokasiWisata);
                        break;
                    case 2:
                        System.out.println("--- Hapus Tempat Wisata ---");
                        System.out.print(" - Id Tempat Wisata : "); String id = cinStr.nextLine();
                        model.removeTempatWisata(id);
                        break;
                    case 3:
                        System.out.println("--- Daftar Tempat Wisata ---");
                        model.viewListConsole(model.getListTempatWisata());
                        break;
                    case 4:
                        System.out.println("--- Cari Tempat Wisata by ID ---");
                        System.out.print(" - Masukkan id Tempat Wisata : "); id = cinStr.nextLine();
                        TempatWisata e = model.getTempatWisata(id);
                        System.out.println(e);
                        break;
                    case 5:
                        System.out.println("--- Cari Tempat Wisata by Index ---");
                        System.out.print(" - Masukkan index Tempat Wisata : "); int index = inputInteger();
                        e = model.getTempatWisata(index);
                        System.out.println(e);
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void menuPaketWisata() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Paket Wisata -------");
                System.out.println("- 1. Tambah Paket Wisata        ");
                System.out.println("- 2. Hapus Paket Wisata         ");
                System.out.println("- 3. Lihat semua paket wisata   ");
                System.out.println("- 4. Cari Paket Wisata          ");
                System.out.println("- 5. Kelola Tempat Wisata       ");
                System.out.println("- 0. Kembali                    ");
                System.out.println("--------------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Paket Wisata ---");
                        System.out.print(" - Nama paket         : "); String namaPaket = cinStr.nextLine();
                        System.out.print(" - Durasi             : "); String durasi = cinStr.nextLine();
                        System.out.print(" - Domisili           : "); String domisili = cinStr.nextLine();
                        System.out.print(" - harga              : "); double harga = inputInteger();
                        System.out.print(" - Maksimal pelanggan : "); int maxPelanggan = inputInteger();
                        model.createPaketWisata(namaPaket, durasi, domisili, harga, maxPelanggan);
                        break;
                    case 2:
                        System.out.println("--- Hapus Paket Wisata ---");
                        System.out.print(" - Id Paket Wisata : "); String id = cinStr.nextLine();
                        model.removePaketWisata(id);
                        break;
                    case 3:
                        System.out.println("--- Daftar Paket Wisata ---");
                        model.viewListConsole(model.getListPaketWisata());
                        break;
                    case 4:
                        System.out.println("--- Cari Paket Wisata ---");
                        System.out.print(" - Masukkan id Paket Wisata : "); id = cinStr.nextLine();
                        PaketWisata e = model.getPaketWisata(id);
                        System.out.println(e);
                        String s = model.getListTujuanWisata(id);
                        System.out.println(s);
                        break;
                    case 5:
                        menuKelolaTempatWisata();
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void menuPerjalanan() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Perjalanan -------");
                System.out.println("- 1. Tambah Perjalanan        ");
                System.out.println("- 2. Hapus Perjalanan         ");
                System.out.println("- 3. Lihat semua perjalanan   ");
                System.out.println("- 4. Cari Perjalanan          ");
                System.out.println("- 5. Kelola Perjalanan        ");
                System.out.println("- 0. Kembali                  ");
                System.out.println("------------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Perjalanan ---");
                        System.out.print(" - Tanggal perjalanan : "); String tanggal = cinStr.nextLine();
                        System.out.print(" - ID Paket wisata    : "); String idpaket = cinStr.nextLine();
                        PaketWisata paket;
                        paket = model.getSetPaket(idpaket);
                        model.createPerjalanan(tanggal, paket);
                        break;
                    case 2:
                        System.out.println("--- Hapus perjalanan ---");
                        System.out.print(" - Id perjalanan : "); String id = cinStr.nextLine();
                        model.removePerjalanan(id);
                        break;
                    case 3:
                        System.out.println("--- Daftar perjalanan ---");
                        model.viewListConsole(model.getListPerjalanan());
                        break;
                    case 4:
                        System.out.println("--- Cari perjalanan ---");
                        System.out.print(" - Masukkan id perjalanan : "); id = cinStr.nextLine();
                        Perjalanan e = model.getPerjalanan(id);
                        System.out.println(e);
                        String s = model.getListPelangganA(id);
                        System.out.println(s);
                        break;
                    case 5:
                        menuKelolaPelanggan();
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void menuKelolaTempatWisata() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Kelola Tempat Wisata dalam Paket Wisata -------");
                System.out.println("- 1. Tambah Tempat Wisata                                  ");
                System.out.println("- 2. Kurangi Tempat Wisata                                 ");
                System.out.println("- 0. Kembali                                               ");
                System.out.println("-----------------------------------------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Tempat Wisata ---");
                        System.out.print(" - ID Paket wisata    : "); String idpaket = cinStr.nextLine();
                        System.out.print(" - ID Tempat wisata   : "); String idtempat = cinStr.nextLine();
                        model.assignTempatWisata(idpaket, idtempat);
                        break;
                    case 2:
                        System.out.println("--- Tambah Tempat Wisata ---");
                        System.out.print(" - ID Paket wisata    : "); idpaket = cinStr.nextLine();
                        System.out.print(" - ID Tempat wisata   : "); idtempat = cinStr.nextLine();
                        model.unassignTempatWisata(idpaket, idtempat);
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void menuKelolaPelanggan() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Kelola Pelanggan dalam Perjalanan -------");
                System.out.println("- 1. Tambah pelanggan                                ");
                System.out.println("- 2. Kurangi pelanggan                               ");
                System.out.println("- 0. Kembali                                         ");
                System.out.println("-----------------------------------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("--- Tambah Pelanggan ---");
                        System.out.print(" - ID Perjalanan    : "); String idperjalanan = cinStr.nextLine();
                        System.out.print(" - ID Pelanggan     : "); String idpelanggan = cinStr.nextLine();
                        model.assignPelanggan(idperjalanan, idpelanggan);
                        break;
                    case 2:
                        System.out.println("--- Tambah Pelanggan ---");
                        System.out.print(" - ID Perjalanan    : "); idperjalanan = cinStr.nextLine();
                        System.out.print(" - ID Pelanggan     : "); idpelanggan = cinStr.nextLine();
                        model.assignPelanggan(idperjalanan, idpelanggan);
                        break;
                    case 0:
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
    
    public void mainMenu() {
        int pil = 0;
        do {            
            try {
                System.out.println("------ Menu Utama -------");
                System.out.println("- 1. Kelola Pelanggan    ");
                System.out.println("- 2. Kelola Petugas      ");
                System.out.println("- 3. Kelola Tempat Wisata");
                System.out.println("- 4. Kelola Paket Wisata ");
                System.out.println("- 5. Kelola Perjalanan   ");
                System.out.println("- 0. Exit                ");
                System.out.println("-------------------------");
                System.out.print("- Pilih menu : ");
                pil = inputInteger();
                switch (pil){
                    case 1:
                        menuPelanggan();
                        break;
                    case 2:
                        menuPetugas();
                        break;
                    case 3:
                        menuTempatWisata();
                        break;
                    case 4:
                        menuPaketWisata();
                        break;
                    case 5:
                        menuPerjalanan();
                        break;
                    case 0:
                        System.out.println("Terimakasih");
                }
                
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                cinInt = new Scanner(System.in);
                cinStr = new Scanner(System.in);
            }
            
        } while (pil != 0); 
    }
}
