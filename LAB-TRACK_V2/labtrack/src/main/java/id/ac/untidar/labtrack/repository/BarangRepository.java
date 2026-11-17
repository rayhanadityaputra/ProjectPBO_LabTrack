/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.ac.untidar.labtrack.repository;

interface BarangRepository {
    void simpan(BarangLab b);
    BarangLab cariByKode(String kode);
    List<BarangLab> cariSemua();
    void update(BarangLab b);
    boolean hapus(String kode);
}