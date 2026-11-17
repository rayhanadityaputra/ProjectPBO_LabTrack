/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.ac.untidar.labtrack.notification;

/**
 * Abstraksi interface layanan notifikasi.
 */
public interface Notifikasi {
    void kirimPesan(String penerima, String pesan);
}