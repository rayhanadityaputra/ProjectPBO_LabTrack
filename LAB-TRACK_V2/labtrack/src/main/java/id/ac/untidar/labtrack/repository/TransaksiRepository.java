/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.ac.untidar.labtrack.repository;

import id.ac.untidar.labtrack.model.TransaksiPeminjaman;
import java.util.List;

interface TransaksiRepository {
    void simpan(TransaksiPeminjaman t);
    TransaksiPeminjaman cariById(String id);
    List<TransaksiPeminjaman> cariSemua();
    void update(TransaksiPeminjaman t);
}