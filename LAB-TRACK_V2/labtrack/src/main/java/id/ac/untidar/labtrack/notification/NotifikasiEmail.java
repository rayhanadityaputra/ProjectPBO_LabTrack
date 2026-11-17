/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.notification;

/**
 * Implementasi pengiriman notifikasi via Email (Simulasi).
 */
public class NotifikasiEmail implements Notifikasi {
    @Override
    public void kirimPesan(String penerima, String pesan) {
        System.out.println("[SENDING EMAIL -> " + penerima + "]: " + pesan);
    }
}