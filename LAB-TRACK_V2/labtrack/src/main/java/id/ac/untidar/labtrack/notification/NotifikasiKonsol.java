/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack.notification;

/**
 * Implementasi pengiriman notifikasi via Konsol CLI.
 */
class NotifikasiKonsol implements Notifikasi {
    @Override
    public void kirimPesan(String penerima, String pesan) {
        System.out.println("[NOTIFIKASI KONSOL -> " + penerima + "]: " + pesan);
    }
}
