/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.model;

/**
 * Subclass pengguna peran Dosen.
 */
class Dosen extends Pengguna implements AksiPeminjam {
    private int nidn;
    private String departemen;

    public Dosen(String idUser, String nama, String email, String password, int nidn, String departemen) {
        super(idUser, nama, email, password);
        this.nidn = nidn;
        this.departemen = departemen;
    }

    public int getNidn() { return nidn; }
    public String getDepartemen() { return departemen; }

    @Override
    public String getRole() { return "Dosen"; }
    public void lihatKatalog() {
        System.out.println("Dosen " + nama + " melihat katalog alat riset.");
    }
    public void ajukanPeminjaman() {
        System.out.println("Dosen " + nama + " mengajukan peminjaman alat riset prioritas.");
    }
}