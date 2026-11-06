# ProjectPBO_LabTrack

# 🧪 LAB-TRACK (Laboratory Tool & Resource Access Control Kit)

> **LAB-TRACK** adalah aplikasi manajemen laboratorium berbasis **Object-Oriented Programming (PBO)** menggunakan bahasa Pemrograman Java. Aplikasi ini dirancang untuk menyelesaikan permasalahan pencatatan manual peminjaman alat laboratorium di perguruan tinggi secara digital, transparan, dan terintegrasi.

---

## 📌 Pendahuluan & Latar Belakang

Pengelolaan laboratorium komputer, informatika, maupun laboratorium teknik di perguruan tinggi membutuhkan efisiensi tinggi dalam hal manajemen inventaris dan aset. Pencatatan manual menggunakan buku besar sering kali menimbulkan berbagai kendala operasional:
- ❌ **Informasi Stok Tidak Real-Time:** Peminjam harus datang langsung ke lab hanya untuk mengecek ketersediaan alat.
- ❌ **Keterlambatan Pengembalian:** Tidak adanya pengingat otomatis jatuh tempo.
- ❌ **Kerusakan & Kehilangan Aset:** Penelusuran penanggung jawab terakhir atas alat yang rusak/hilang sulit dilakukan.
- ❌ **Beban Administrasi Laboran:** Pembuatan rekapitulasi penggunaan dan komputasi denda memakan waktu lama.

**LAB-TRACK** hadir sebagai solusi berbasis objek (*Object-Oriented*) yang mengotomatisasi seluruh alur peminjaman, pemeriksaan ketersediaan stok, verifikasi kondisi fisik pengembalian, hingga komputasi denda polimorfik.

---

## 🎯 Kriteria & Pilar PBO dalam Rancangan

Aplikasi ini dirancang dengan memenuhi 4 Pilar Utama Pemrograman Berorientasi Objek:

1. **🔒 Enkapsulasi (*Encapsulation*):** Atribut sensitif seperti `stok`, `password`, dan `hargaSewa` diset sebagai `private`. Pengubahan stok hanya dapat dilakukan melalui method resmi (`tambahStok()`, `kurangiStok()`) yang memvalidasi aturan bisnis (misal: stok tidak boleh negatif).
2. **🧬 Pewarisan (*Inheritance*):** 
   - Hierarchy Pengguna: Class `Mahasiswa`, `Dosen`, dan `AdminLab` mewarisi `abstract class Pengguna`.
   - Hierarchy Aset: Class `BarangElektronik` dan `BarangKonsumabel` mewarisi `abstract class BarangLab`.
3. **🎭 Polimorfisme (*Polymorphism*):** Penanganan denda dinamis menggunakan interface `HitungDenda` yang diimplementasikan secara terpisah oleh class `DendaTerlambat` (denda harian) dan `DendaKerusakan` (persentase fisik barang).
4. **📦 Abstraksi (*Abstraction*):** Menyembunyikan kompleksitas detail teknis melalui `abstract class` (`Pengguna`, `BarangLab`) dan `interface` (`HitungDenda`).

---

## 🏗️ Struktur Diagram Kelas (Class Diagram)

```text
+---------------------------------------------------------------------------------------------------+
|                                     DIAGRAM KELAS LAB-TRACK                                       |
+---------------------------------------------------------------------------------------------------+

 1. HIERARKI PENGGUNA (Inheritance):
    [Abstract Class] Pengguna (#idUser, #nama, #email, #password) <--- [Inherits]
         |---> Mahasiswa (+nim, +prodi | +buatPeminjaman())
         |---> Dosen (+nidn, +departemen | +buatPeminjamanPrioritas())
         |---> AdminLab (+nip, +jabatan | +approvePeminjaman(), +prosesPengembalian())

 2. HIERARKI INVENTARIS BARANG (Inheritance):
    [Abstract Class] BarangLab (#kodeBarang, #namaBarang, #stok) <--- [Inherits]
         |---> BarangElektronik (+dayaListrik, +statusKalibrasi)
         |---> BarangKonsumabel (+tglKedaluwarsa, +isHabisPakai)

 3. STRUKTUR TRANSAKSI & KOMPOSISI (Composition & Association):
    [TransaksiPeminjaman] 1 ---- * [ItemPeminjaman] * ---- 1 [BarangLab]
    [TransaksiPeminjaman] 1 ---- 0..1 [PengembalianLab]

 4. POLIMORFISME DENDA (Interface & Realization):
    <<Interface>> HitungDenda (+hitungDenda(hari, nilaiBarang): double)
         ^                             ^
         | (implements)                | (implements)
    [DendaTerlambat]              [DendaKerusakan]

+---------------------------------------------------------------------------------------------------+


✨ Fitur Utama Sistem👥 Multi-Actor Access: Hak akses terpisah untuk Mahasiswa, Dosen, Admin Lab, dan System Automation.📋 Katalog Alat Real-Time: Menampilkan data inventaris, ketersediaan stok, serta detail spesifikasi alat.🔄 Manajemen Peminjaman & Pengembalian: Pencatatan transaksi peminjaman lengkap dengan tanggal jatuh tempo dan verifikasi kondisi fisik barang saat dikembalikan (Baik / Rusak Ringan / Rusak Berat / Hilang).💰 Kalkulasi Denda Otomatis: Perhitungan denda otomatis berbasis keterlambatan waktu maupun denda persentase kerusakan fisik.📊 Rekapitulasi Laporan: Fitur pembuatan rekap laporan bulanan untuk Admin Lab.📂 Struktur RepositoriPlaintextlab-track/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   ├── Pengguna.java (Abstract Class)
│   │   │   │   ├── Mahasiswa.java
│   │   │   │   ├── Dosen.java
│   │   │   │   ├── AdminLab.java
│   │   │   │   ├── BarangLab.java (Abstract Class)
│   │   │   │   ├── BarangElektronik.java
│   │   │   │   ├── BarangKonsumabel.java
│   │   │   │   ├── TransaksiPeminjaman.java
│   │   │   │   ├── ItemPeminjaman.java
│   │   │   │   └── PengembalianLab.java
│   │   │   │
│   │   │   ├── service/
│   │   │   │   ├── HitungDenda.java (Interface)
│   │   │   │   ├── DendaTerlambat.java
│   │   │   │   └── DendaKerusakan.java
│   │   │   │
│   │   │   └── Main.java (App Runner & CLI Interface)
│
├── docs/
│   ├── PBO_TBP_Kelompok2_LAB_TRACK_Proposal_Lengkap.docx
│   └── lab_track_class_diagram.png
│
├── README.md
└── .gitignore
👥 Anggota Tim & KontribusiNama AnggotaPeran / Tanggung Jawab UtamaRayhan Aditya Putra (Ketua)Project Leader & System Architect (Problem Statement, 5 Whys, & Architecture Design)Erny KurniawatiRequirement Analyst (Analisis Kebutuhan KF & KNF)Vandra Noprianus SembiringClass Designer (Tabel Seleksi Kelas, Kartu CRC, & Class Diagram)Kenji Muhammad AdisusiloDeveloper (Implementasi Code Java Core & Testing CLI)Syifa Rahma RasendriyaQA & Documentation (Test Case Scenarios & Final Report Documentation)🛠️ Cara Menjalankan Proyek (Setup & Execution)Clone Repositori ini:Bashgit clone [https://github.com/username-kalian/lab-track.git](https://github.com/username-kalian/lab-track.git)
cd lab-track
Kompilasi dan Jalankan via Terminal / IDE:NetBeans / IntelliJ IDEA / Eclipse: Open Project -> Run Main.java.Terminal (CLI):Bashjavac -d bin src/main/java/**/*.java
java -cp bin Main
