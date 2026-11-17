/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.untidar.labtrack;

import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi Repository, Notifikasi, & Service (sama seperti sebelumnya)
        BarangRepository barangRepo = new MemoryBarangRepository();
        TransaksiRepository transaksiRepo = new MemoryTransaksiRepository();
        Notifikasi notif = new NotifikasiEmail();

        PeminjamanService peminjamanService = new PeminjamanService(transaksiRepo, barangRepo, notif);
        PengembalianService pengembalianService = new PengembalianService(transaksiRepo, barangRepo, notif);
        InventarisService inventarisService = new InventarisService(barangRepo);

        // Seed data awal barang & user
        inventarisService.tambahBarang(new BarangElektronik("ELK-001", "Router MikroTik", 5, "Rak A-1", 750000.0, "12V", "TERKALIBRASI"));
        inventarisService.tambahBarang(new BarangKonsumabel("KNS-001", "Kabel UTP Cat6", 20, "Rak B-2", 35000.0, new Date(), false));
        Mahasiswa mhs1 = new Mahasiswa("USR-MHS1", "Rayhan Aditya", "rayhan@student.untidar.ac.id", "pass123", 250506005, "Teknologi Informasi");

        int pilihan;
        do {
            System.out.println("\n=== MENU LAB-TRACK ===");
            System.out.println("1. Lihat Katalog Barang");
            System.out.println("2. Ajukan Peminjaman");
            System.out.println("3. Approve Peminjaman (Admin)");
            System.out.println("4. Proses Pengembalian (Admin)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer Enter

            switch (pilihan) {
                case 1:
                    inventarisService.tampilkanKatalog();
                    break;

                case 2:
                    System.out.print("Masukkan ID Transaksi (misal TX-001): ");
                    String idTx = input.nextLine();
                    System.out.print("Masukkan Kode Barang (misal ELK-001): ");
                    String kode = input.nextLine();
                    System.out.print("Jumlah pinjam: ");
                    int qty = input.nextInt();
                    input.nextLine();

                    BarangLab barangDipilih = barangRepo.cariByKode(kode);
                    if (barangDipilih != null) {
                        TransaksiPeminjaman tx = new TransaksiPeminjaman(idTx, mhs1, new Date(), new Date());
                        tx.tambahItem(barangDipilih, qty);
                        peminjamanService.ajukanPeminjaman(tx);
                    } else {
                        System.out.println("[GAGAL] Kode barang tidak ditemukan!");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID Transaksi yang di-approve: ");
                    String idApprove = input.nextLine();
                    if (!peminjamanService.approvePeminjaman(idApprove)) {
                        System.out.println("[GAGAL] ID Transaksi tidak ditemukan atau bukan PENDING.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Transaksi yang dikembalikan: ");
                    String idKembali = input.nextLine();
                    System.out.print("Jumlah hari terlambat (0 jika tepat waktu): ");
                    int telat = input.nextInt();
                    input.nextLine();
                    System.out.print("Kondisi barang (BAIK / RUSAK): ");
                    String kondisi = input.nextLine();

                    pengembalianService.prosesPengembalian(idKembali, new Date(), telat, kondisi);
                    break;

                case 0:
                    System.out.println("Keluar dari sistem...");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 0);

        input.close();
    }
}