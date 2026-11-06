/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pboproject_labtrack;

/**
 *
 * @author ASUS
 */

// Kerangka Sistem LAB_TRACK, BUKAN CODE FINAL

public class PBOProject_LabTrack {
    // 1. ABSTRACT CLASS PENGGUNA (Inheritance & Encapsulation)
public abstract class Pengguna {
    private String idUser;
    private String nama;
    private String email;

    public Pengguna(String idUser, String nama, String email) {
        this.idUser = idUser;
        this.nama = nama;
        this.email = email;
    }

    public String getIdUser() { return idUser; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }

    public abstract String getRole();
}

// 2. SUBCLASS MAHASISWA
public class Mahasiswa extends Pengguna {
    private String nim;
    private String prodi;

    public Mahasiswa(String idUser, String nama, String email, String nim, String prodi) {
        super(idUser, nama, email);
        this.nim = nim;
        this.prodi = prodi;
    }

    @Override
    public String getRole() { return "Mahasiswa"; }
    public String getNim() { return nim; }
}

// 3. INTERFACE POLIMORFISME HITUNG DENDA
public interface HitungDenda {
    double hitungDenda(int hariTerlambat, double nilaiBarang);
}

// 4. IMPLEMENTASI DENDA TERLAMBAT
public class DendaTerlambat implements HitungDenda {
    private static final double TARIF_PER_HARI = 5000.0;

    @Override
    public double hitungDenda(int hariTerlambat, double nilaiBarang) {
        if (hariTerlambat <= 0) return 0.0;
        return hariTerlambat * TARIF_PER_HARI;
    }
}

// 5. IMPLEMENTASI DENDA KERUSAKAN
public class DendaKerusakan implements HitungDenda {
    private double persentaseKerusakan; // Contoh: 0.5 (50%) atau 1.0 (100%)

    public DendaKerusakan(double persentaseKerusakan) {
        this.persentaseKerusakan = persentaseKerusakan;
    }

    @Override
    public double hitungDenda(int hariTerlambat, double nilaiBarang) {
        return nilaiBarang * persentaseKerusakan;
    }
}

}
