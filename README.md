**Tugas Praktikum 4 DPBO 2026 - Kelas C1**

Topik: Membuat Aplikasi Java Swing CRUD & GUI Designer.

---

Nama: Muh. Adib Al-Fathi NIM: 2500418 Kelas: C1

**Janji**

Saya Muh. Adib Al-Fathi dengan NIM 2500418 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## 1. Desain / Fungsi Program
Aplikasi ini dibuat buat ngelola data *Person* pakai Java Swing di IntelliJ IDEA. Biar gampang dipakai, tampilannya udah dibikin pakai GUI Form (`.form`)[cite: 3, 13]. Komponen utamanya ada:
- `JTextField` buat ngetik ID, Nama, Tahun Lahir, sama Kategori[cite: 3].
- `JComboBox` buat milih status (*Aktif, Cuti, Non-Aktif*)[cite: 3, 13].
- `JTable` (dibungkus `JScrollPane`) buat nampilin list data secara rapi[cite: 3, 13].
- Tombol-tombol aksi: **Add**, **Update**, **Delete**, sama **Cancel**[cite: 3, 13].

## 2. Penjelasan Alur (CRUD)
Alur jalannya program sesuai sama operasi CRUD standar:
- **Create (Add):** Masukin data di textfield, pilih status di combo box, terus klik *Add*. Data bakal otomatis masuk ke list dan nampil di tabel[cite: 13].
- **Read:** Pas program pertama kali dibuka, data dummy awal bakal langsung ke-load dan tampil di tabel berkat `DefaultTableModel`[cite: 13].
- **Update:** Tinggal klik salah satu baris data di tabel, otomatis datanya naik ke form atas. Kalau mau ada yang diubah, tinggal edit terus klik *Update*[cite: 13].
- **Delete:** Pilih baris data di tabel, terus klik *Delete*. Bakal muncul pop-up konfirmasi (*JOptionPane*) dulu biar gak salah hapus. Kalau di-yes, data langsung kehapus dari tabel[cite: 13].
- **Cancel:** Tombol buat ngebersihin form input kalau semisal batal nambah/edit data[cite: 13].

## 3. Dokumentasi Program
Berikut penampakan screenshot pas programnya dijalanin dan nyobain semua fitur CRUD:
- **Tampilan Awal & Tambah Data (Add):**
<img width="959" height="566" alt="memuat data awal" src="https://github.com/user-attachments/assets/3574ed67-0f57-47a3-bcef-279cf8d69c8f" />
<img width="959" height="565" alt="menambah data baru" src="https://github.com/user-attachments/assets/855e5e60-4672-462c-91ed-878be404d1b3" />

- **Ubah Data (Update):**
<img width="959" height="564" alt="update data" src="https://github.com/user-attachments/assets/2494ce5c-a538-4a90-b831-f6ab37ddf369" />

- **Hapus Data (Delete + Konfirmasi):**
<img width="959" height="563" alt="menghapus data" src="https://github.com/user-attachments/assets/0de7cdfd-c5ad-468d-adea-b4c5a199e40f" />









