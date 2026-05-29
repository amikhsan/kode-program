Sistem Inventaris Minimarket



Deskripsi



Sistem Inventaris Minimarket adalah aplikasi berbasis Java yang digunakan untuk mengelola data barang pada minimarket. Program ini mendukung pengelolaan data barang mulai dari penambahan, pengeditan, penghapusan, pencarian, pengurutan, hingga penyimpanan data ke file.



Fitur Utama



1\. Manajemen Data Barang



\* Tambah barang baru

\* Edit data barang

\* Hapus barang (Soft Delete)

\* Tampilkan seluruh data barang aktif



2\. Pencarian Data (Searching)



\* Linear Search berdasarkan nama barang

\* Binary Search berdasarkan ID barang

\* Pencarian berdasarkan kategori barang



3\. Pengurutan Data (Sorting)



\* Bubble Sort berdasarkan ID

\* Selection Sort berdasarkan nama barang

\* Bubble Sort Descending berdasarkan jumlah stok

&#x20;

4\. Statistik Data



\* Total data barang

\* Jumlah data aktif

\* Jumlah data yang telah dihapus



5\. Penyimpanan Data



\* Data disimpan ke file `data\_barang.txt`

\* Data otomatis dimuat kembali saat program dijalankan



Struktur Data



Program menggunakan:



\* ArrayList<Barang>

\* Class Barang sebagai representasi data inventaris



Atribut Barang:



| Atribut  | Tipe Data | Keterangan      |
|----------|-----------|-----------------|
| id       | int       | ID barang       |
| nama     | String    | Nama barang     |
| kategori | String    | Kategori barang |
| jumlah   | int       | Jumlah stok     |
| aktif    | boolean   | Status data     |




Algoritma yang Digunakan



\# Searching



\# Linear Search



Digunakan untuk:



\* Pencarian nama barang

\* Pencarian kategori barang



Kompleksitas:



\* Best Case: O(1)

\* Worst Case: O(n)



\# Binary Search



Digunakan untuk:



\* Pencarian berdasarkan ID barang



Kompleksitas:



\* Best Case: O(1)

\* Worst Case: O(log n)





\# Sorting



\# Bubble Sort



Digunakan untuk:



\* Pengurutan ID barang

\* Pengurutan jumlah stok



Kompleksitas:



\* Best Case: O(n)

\* Worst Case: O(n²)



\# Selection Sort



Digunakan untuk:



\* Pengurutan nama barang



Kompleksitas:



\* Best Case: O(n²)

\* Worst Case: O(n²)





\# Cara Menjalankan Program



\- Compile Program



```bash

javac belajar\_project.java

```



\- Menjalankan Program



```bash

java belajar\_project

```
\# File Project

\* `belajar\_project.java` → Source code program

\* `data\_barang.txt` → Penyimpanan data inventaris

\* `README.md` → Dokumentasi project




- langkah-langkah menjalankan program

1. Download atau salin belajar_project

2. Buka menggunakan VS Code

3. Compile file Java

4. Jalankan file main

5. Program akan tampil di terminal

\---



\# Mata Kuliah

Algoritma dan Struktur Data (ASD)

\# Tema Project

Sistem Inventaris Barang Minimarket
