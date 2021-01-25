/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Aplikasi;
import Model.*;
import ViewGui.ViewGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * Nama   : Kukuh Rahingga Permadi 
 * NIM    : 1301150035 
 */
public class Controller implements ActionListener{
    private Aplikasi model;
    private ViewGui view;

    public Controller() {
        model = new Aplikasi();
        view = new ViewGui();
        view.setVisible(true);
        view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try {
            if (source.equals(view.getBtnExit())) {
                try {
                    model.savePelanggan();
                    model.savePetugas();
                    model.saveTempatWisata();
                    model.savePaketWisata();
                    model.savePerjalanan();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                System.exit(0);
                
            // Pelanggan -----
            } else if (source.equals(view.getPelBtnLihat())) {
                model.loadPelanggan();
                view.setPelList(model.viewIdPelanggan());
            
            } else if (source.equals(view.getPelBtnRefresh())) {
                try {
                    model.loadPelanggan();
                    view.reset();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                
            } else if (source.equals(view.getPelBtnAdd())) {
                String nama         = view.getPelTextNama();
                String pekerjaan    = view.getPelTextPekerjaan();
                String kontak       = view.getPelTextKontak();
                String alamat       = view.getPelTextAlamat();
                String tglLahir     = view.getPelTextTtl();
                String jenisKelamin;
                int cek = view.getPelComboJenis();
                if (cek != 2) {
                    jenisKelamin = "Laki-laki";
                } else {
                    jenisKelamin = "Perempuan";
                }
                model.createPelanggan (pekerjaan, nama, kontak, alamat, jenisKelamin, tglLahir);
                try {
                    model.savePelanggan();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                view.reset();
                
                
            } else if (source.equals(view.getPelBtnCari())) {
                model.loadPelanggan();
                String Cari     = view.getPelTextCari();
                int cekBy       = view.getPelComboBy();
                int cekTujuan   = view.getPelComboTujuan();
                Pelanggan p;
                view.reset();
                if (cekBy != 2) {
                    p = model.getPelanggan(Cari);
                    if (cekTujuan != 2) {
                        if (p != null) {
                            view.setPelDetil(p.toString());
                        } else {
                            throw new IllegalArgumentException("Pelanggan tidak ditemukan");
                        }
                    } else if (cekTujuan != 1) {
                        if (p != null) {
                            model.removePelanggan(Cari);
                        } else {
                            throw new IllegalArgumentException("Pelanggan tidak ditemukan");
                        }
                    }
                } else if (cekBy != 1) {
                    p = model.getPelanggan(Cari);
                    if (cekTujuan != 1) {
                        if (p != null) {
                            Pelanggan Pel = model.getPelanggan(Cari);
                            view.setPelDetil(p.toString());
                        } else {
                            throw new IllegalArgumentException("Pelanggan tidak ditemukan / inputan bukan ID");
                        }
                    } 
                }
                model.savePelanggan();
            }
            
            // Petugas -----
            else if (source.equals(view.getPetBtnLihat())) {
                model.loadPetugas();
                view.setPetList(model.viewIdPetugas());
                
            } else if (source.equals(view.getPetBtnRefresh())) {
                model.loadPetugas();
                view.reset();
                view.setPetDetil("");
                
            } else if (source.equals(view.getPetBtnAdd())) {
                String nama         = view.getPetTextNama();
                String jabatan      = view.getPetTextJabatan();
                String gajitx       = view.getPetTextGaji();
                String noHp         = view.getPetTextKontak();
                String alamat       = view.getPetTextAlamat();
                String tglLahir     = view.getPetTextTtl();
                String jenisKelamin;
                int cek = view.getPetComboJenis();
                if (cek != 2) {
                    jenisKelamin = "Laki-laki";
                } else {
                    jenisKelamin = "Perempuan";
                }
                double gaji = Double.parseDouble(gajitx);
                model.createPetugas(gaji, jabatan, nama, noHp, alamat, jenisKelamin, tglLahir);
                try {
                    model.savePetugas();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                view.reset();
                
            } else if (source.equals(view.getPetBtnCari())) {
                model.loadPetugas();
                String Cari     = view.getPetTextCari();
                int cekBy       = view.getPetComboBy();
                int cekTujuan   = view.getPetComboTujuan();
                Petugas p;
                view.reset();
                if (cekBy != 2) {
                    p = model.getPetugas(Cari);
                    if (cekTujuan != 2) {
                        if (p != null) {
                            view.setPetDetil(p.toString());
                        } else {
                            throw new IllegalArgumentException("Petugas tidak ditemukan");
                        }
                    } else if (cekTujuan != 1) {
                        if (p != null) {
                            model.removePetugas(Cari);
                        } else {
                            throw new IllegalArgumentException("Petugas tidak ditemukan");
                        }
                    }
                } else {
                    p = model.getPetugas(Cari);
                    if (cekTujuan != 1) {
                        if (p != null) {
                            view.setPetDetil(p.toString());
                        } else {
                            throw new IllegalArgumentException("Petugas tidak ditemukan / inputan bukan ID");
                        }
                    }
                }
                model.savePetugas();
                
            }
            
            // Tempat Wisata -----
            else if (source.equals(view.getTwBtnLihat())) {
                model.loadTempatWisata();
                view.setTwList(model.viewIdTempatWisata());
                    
            } else if (source.equals(view.getTwBtnRefresh())) {    
                model.loadTempatWisata();
                view.reset();
                view.setTwDetil("");
                
            } else if (source.equals(view.getTwBtnAdd())) {
                String namaWisata   = view.getTwTextNama();
                String lokasiWisata = view.getTwTextLokasi();
                model.createTempatWisata(namaWisata, lokasiWisata);
                try {
                    model.saveTempatWisata();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                view.reset();
                
            } else if (source.equals(view.getTwBtnCari())) {
                model.loadTempatWisata();
                String Cari     = view.getTwTextCari();
                int cekBy       = view.getTwComboBy();
                int cekTujuan   = view.getTwComboTujuan();
                TempatWisata tw;
                view.reset();
                if (cekBy != 2) {
                    tw = model.getTempatWisata(Cari);
                    if (cekTujuan != 2) {
                        if (tw != null) {
                            view.setTwDetil(tw.toString());
                        } else {
                            throw new IllegalArgumentException("Tempat wisata tidak ditemukan");
                        }
                    } else if (cekTujuan != 1) {
                        if (tw != null) {
                            model.removeTempatWisata(Cari);
                        } else {
                            throw new IllegalArgumentException("Tempat wisata tidak ditemukan");
                        }
                    }
                } else {
                    tw = model.getTempatWisata(Cari);
                    if (cekTujuan != 1) {
                        if (tw != null) {
                            view.setTwDetil(tw.toString());
                        } else {
                            throw new IllegalArgumentException("Tempat wisata tidak ditemukan / inputan bukan ID");
                        }
                    }
                }
                model.saveTempatWisata();
            }
            
            // Paket Wisata -----
            else if (source.equals(view.getPwBtnLihat())) {
                model.loadPaketWisata();
                view.setPwList(model.viewIdPaketWisata());
             
            } else if (source.equals(view.getPwBtnRefresh())) {
                model.loadPaketWisata();
                view.reset();
                view.setPwDetil("");
                
            } else if (source.equals(view.getPwBtnAdd())) {
                String namaPaket        = view.getPwTextNama();
                String durasi           = view.getPwTextDurasi();
                String domisili         = view.getPwTextDomisili();
                String hargatx          = view.getPwTextHarga();
                String maxPelanggantx   = view.getPwTextMax();
                double harga = Double.parseDouble(hargatx);
                int maxPelanggan = Integer.parseInt(maxPelanggantx);
                model.createPaketWisata(namaPaket, durasi, domisili, harga, maxPelanggan);
                try {
                    model.savePaketWisata();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                view.reset();
                    
            } else if (source.equals(view.getPwBtnCommit())) {
                model.loadPaketWisata();
                model.loadTempatWisata();
                String IdPw = view.getPwTextIdPw();
                String IdTw = view.getPwTextIdTw();
                int cekPil = view.getPwComboTujuan2();
                if (cekPil != 2) {
                    model.assignTempatWisata(IdPw, IdTw);
                } else if (cekPil != 1) {
                    model.unassignTempatWisata(IdPw, IdTw);
                }
                model.savePaketWisata();
                view.reset();
                
            } else if (source.equals(view.getPwBtnCari())) {
                model.loadPaketWisata();
                String Cari     = view.getPwTextCari();
                int cekTujuan   = view.getPwComboTujuan();
                PaketWisata pw;
                pw = model.getPaketWisata(Cari);
                view.reset();
                if (cekTujuan != 2) {
                    if (pw != null) {
                        view.setTwDetil(pw.toString());
                    } else {
                        throw new IllegalArgumentException("Paket wisata tidak ditemukan");
                    }
                } else if (cekTujuan != 1) {
                    if (pw != null) {
                        model.removePaketWisata(Cari);
                    } else {
                        throw new IllegalArgumentException("Paket wisata tidak ditemukan");
                    }
                }
                model.savePaketWisata();
            }
            
            // Perjalanan -----
            else if (source.equals(view.getPerBtnLihat())) {
                model.loadPerjalanan();
                view.setPerList(model.viewIdPerjalanan());
            
            } else if (source.equals(view.getPelBtnRefresh())) {
                model.loadPerjalanan();
                view.reset();
                view.setPerDetil("");
                
            } else if (source.equals(view.getPerBtnAdd())) {
                model.loadPerjalanan();
                model.loadPelanggan();
                String IdPer = view.getPerTextIdPer();
                String IdPel = view.getPerTextIdPel();
                int cekPil = view.getPwComboTujuan();
                view.reset();
                if (cekPil != 2) {
                    model.assignPelanggan(IdPer, IdPer);
                } else if (cekPil != 1) {
                    model.unassignPelanggan(IdPer, IdPer);
                }
                model.savePerjalanan();
                    
            } else if (source.equals(view.getPerBtnAdd2())) {
                String tanggal      = view.getPerTextTgl();
                String idpaket      = view.getPerTextIdPw();
                PaketWisata paket;
                paket = model.getSetPaket(idpaket);
                model.createPerjalanan(tanggal, paket);
                try {
                    model.savePerjalanan();
                } catch (IOException e) {
                    view.viewErrorMsg(e.getMessage());
                }
                view.reset();
                    
            } else if (source.equals(view.getPerBtnCari())) {
                model.loadPerjalanan();
                String Cari     = view.getPerTextCari();
                int cekTujuan   = view.getPerComboTujuan();
                Perjalanan per;
                per = model.getPerjalanan(Cari);
                view.reset();
                if (cekTujuan != 2) {
                    if (per != null) {
                        view.setPerDetil(per.toString());
                    } else {
                        throw new IllegalArgumentException("Perjalanan tidak ditemukan");
                    }
                } else if (cekTujuan != 1) {
                    if (per != null) {
                        model.removePerjalanan(Cari);
                    } else {
                        throw new IllegalArgumentException("Perjalanan tidak ditemukan");
                    }
                }
                model.savePerjalanan();
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "terjadi kesalahan input");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
            view.reset();
        }
    } 
}
