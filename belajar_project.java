import java.io.*;
import java.util.*;

class Barang {
    int id;
    String nama;
    String kategori;
    int jumlah;
    boolean aktif;

    Barang(int id, String nama, String kategori, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.aktif = true;
    }

    public String toString() {
        return String.format("%-5d %-25s %-15s %-10d",
                id, nama, kategori, jumlah);
    }
}
public class belajar_project {
    static ArrayList<Barang> data = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "data_barang.txt";
    public static void main(String[] args) {
      loadData();

        // DATA AWAL
        if (data.isEmpty()) {
            data.add(new Barang(101, "Indomie Goreng", "Makanan", 50));
            data.add(new Barang(102, "Indomie Soto", "Makanan", 40));
            data.add(new Barang(201, "Teh Botol", "Minuman", 35));
            data.add(new Barang(202, "Aqua 600ml", "Minuman", 60));
            data.add(new Barang(203, "Coca Cola", "Minuman", 20));
            data.add(new Barang(204, "Sprite", "Minuman", 22));
            data.add(new Barang(205, "Kopi Kapal Api", "Minuman", 30));
            data.add(new Barang(206, "Susu Ultra Milk", "Minuman", 15));
            data.add(new Barang(301, "Chitato", "Snack", 25));
            data.add(new Barang(302, "Qtela", "Snack", 18));
            data.add(new Barang(401, "Rinso", "Kebersihan", 12));
            data.add(new Barang(402, "So Klin lantai", "Kebersihan", 10));
            data.add(new Barang(403, "Lifebuoy", "Kebersihan", 28));
            data.add(new Barang(404, "Pepsodent", "Kebersihan", 17));
            data.add(new Barang(501, "Pantene Shampoo", "Perawatan", 14));
            data.add(new Barang(502, "Sunsilk Shampoo", "Perawatan", 11));
            data.add(new Barang(503, "Rexona", "Perawatan", 19));
            data.add(new Barang(504, "Biore", "Perawatan", 13));
            data.add(new Barang(601, "Buku Tulis Sidu", "Alat Tulis", 45));
            data.add(new Barang(602, "Pulpen Pilot", "Alat Tulis", 33));
            data.add(new Barang(603, "Pensil 2B", "Alat Tulis", 27));
            data.add(new Barang(604, "Penghapus Joyko", "Alat Tulis", 21));
            data.add(new Barang(701, "Baygon", "Rumah Tangga", 9));
            data.add(new Barang(702, "Wipol", "Rumah Tangga", 16));
            data.add(new Barang(703, "Tissue Paseo", "Rumah Tangga", 24));
            data.add(new Barang(801, "Minyak Goreng Bimoli", "Sembako", 14));
            data.add(new Barang(802, "Beras Ramos 5kg", "Sembako", 8));
            data.add(new Barang(803, "Gula Gulaku", "Sembako", 26));
            data.add(new Barang(804, "Garam Cap Kapal", "Sembako", 32));
            data.add(new Barang(805, "Telur Ayam", "Sembako", 29));

            simpanData();
        }

        while (true) {
            System.out.println("\n================================================");
            System.out.println("           INVENTARIS BARANG MINIMARKET");
            System.out.println("================================================");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Edit Data Barang");
            System.out.println("4. Hapus Data Barang");
            System.out.println("5. Cari Barang");
            System.out.println("6. Urutkan Data");
            System.out.println("7. Lihat Statistik");
            System.out.println("0. Keluar");
            System.out.println("================================================");
            System.out.print("Pilih menu : ");
            int pilih = inputInt();

            switch (pilih) {
                case 1:
                    tambah();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    hapus();
                    break;
                case 5:
                    searchMenu();
                    break;
                case 6:
                    sortMenu();
                    break;
                case 7:
                    statistik();
                    break;
                case 0:
                    simpanData();
                    System.out.println("Program selesai.");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }
    }
   
    // METHOD SIMPAN DATA
    static void simpanData() {
        try {
            PrintWriter pw = new PrintWriter(
                    new FileWriter(FILE_NAME)
            );

            for (Barang b : data) {
                pw.println(
                        b.id + ";" +
                        b.nama + ";" +
                        b.kategori + ";" +
                        b.jumlah + ";" +
                        b.aktif
                );
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data.");
        }
    }

    // METHOD LOAD DATA
    static void loadData() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return;
            }
            Scanner baca = new Scanner(file);

            while (baca.hasNextLine()) {
                String line = baca.nextLine();
                String[] split = line.split(";");
                Barang b = new Barang(
                        Integer.parseInt(split[0]),
                        split[1],
                        split[2],
                        Integer.parseInt(split[3])
                );

                b.aktif = Boolean.parseBoolean(split[4]);
                data.add(b);
            }
            baca.close();
        } catch (Exception e) {
            System.out.println("Gagal membaca data.");
        }
    }

    // VALIDASI INPUT ANGKA
    static int inputInt() {

        while (!sc.hasNextInt()) {
            System.out.println("Input harus berupa angka.");
            sc.next();
            System.out.print("Masukkan lagi : ");
        }
        int angka = sc.nextInt();
        sc.nextLine();
        return angka;
    }

    // TAMBAH DATA
    static void tambah() {
        System.out.println("\n========== TAMBAH DATA ==========");
        System.out.print("Masukkan ID       : ");
        int id = inputInt();

        for (Barang b : data) {
            if (b.id == id) {
                System.out.println("ID sudah digunakan.");
                return;
            }
        }
        System.out.print("Masukkan Nama     : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Kategori : ");
        String kategori = sc.nextLine();
        System.out.print("Masukkan Jumlah   : ");
        int jumlah = inputInt();

        data.add(new Barang(id, nama, kategori, jumlah));
        sortByID();
        simpanData();
        System.out.println("Data berhasil ditambahkan.");
    }
   // TAMPIL DATA
static void tampil() {
    boolean ada = false;
    int totalStok = 0;
    System.out.println("\n==============================================================");
    System.out.println("                    DAFTAR DATA BARANG");
    System.out.println("==============================================================");
    System.out.printf("%-5s %-25s %-15s %-10s\n",
            "ID", "Nama Barang", "Kategori", "Stok");
    System.out.println("--------------------------------------------------------------");

    for (Barang b : data) {
        if (b.aktif) {
            System.out.println(b);
            totalStok += b.jumlah;
            ada = true;
        }
    }

    if (!ada) {
        System.out.println("Tidak ada data barang.");
    } else {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Total Stok Barang : " + totalStok);
    }
    System.out.println("==============================================================");
}
    // EDIT DATA
    static void edit() {
        System.out.println("\n========== EDIT DATA ==========");
        System.out.print("Masukkan ID : ");
        int id = inputInt();
        for (Barang b : data) {
            if (b.id == id && b.aktif) {
                System.out.print("Nama baru     : ");
                b.nama = sc.nextLine();
                System.out.print("Kategori baru : ");
                b.kategori = sc.nextLine();
                System.out.print("Jumlah baru   : ");
                b.jumlah = inputInt();
                simpanData();
                System.out.println("Data berhasil diupdate.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    // HAPUS DATA
    static void hapus() {
        System.out.println("\n========== HAPUS DATA ==========");
        System.out.print("Masukkan ID : ");
        int id = inputInt();

        for (Barang b : data) {
            if (b.id == id && b.aktif) {
                b.aktif = false;
                simpanData();
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    // MENU SEARCHING
    static void searchMenu() {
        System.out.println("\n========== MENU SEARCHING ==========");
        System.out.println("1. Cari Nama (Linear Search)");
        System.out.println("2. Cari ID (Binary Search)");
        System.out.println("3. Cari Kategori");
        System.out.print("Pilih : ");
        int pilih = inputInt();

        switch (pilih) {
            case 1:
                searchNama();
                break;
            case 2:
                searchID();
                break;
            case 3:
                searchKategori();
                break;
            default:
                System.out.println("Menu tidak tersedia.");
        }
    }

    // SEARCH NAMA
   static void searchNama() {
    System.out.print("Masukkan nama : ");
    String key = sc.nextLine();
    boolean ditemukan = false;

    System.out.println("\n==============================================================");
    System.out.printf("%-5s %-25s %-15s %-10s\n",
            "ID", "Nama Barang", "Kategori", "Stok");
    System.out.println("--------------------------------------------------------------");

    for (Barang b : data) {
        if (b.aktif &&
                b.nama.toLowerCase().contains(key.toLowerCase())) {
            System.out.println(b);
            ditemukan = true;
        }
    }

    if (!ditemukan) {
        System.out.println("Data tidak ditemukan.");
    }
    System.out.println("==============================================================");
}

    // SEARCH ID
   static void searchID() {

    sortByID();

    System.out.print("Masukkan ID : ");
    int id = inputInt();
    int kiri = 0;
    int kanan = data.size() - 1;

    System.out.println("\n==============================================================");
    System.out.printf("%-5s %-25s %-15s %-10s\n",
            "ID", "Nama Barang", "Kategori", "Stok");
    System.out.println("--------------------------------------------------------------");

    while (kiri <= kanan) {
        int tengah = (kiri + kanan) / 2;

        if (data.get(tengah).id == id &&
                data.get(tengah).aktif) {
            System.out.println(data.get(tengah));
            System.out.println("==============================================================");
            return;
        }

        if (data.get(tengah).id < id) {
            kiri = tengah + 1;
        } else {
            kanan = tengah - 1;
        }
    }
    System.out.println("Data tidak ditemukan.");
    System.out.println("==============================================================");
}

    // SEARCH KATEGORI
   static void searchKategori() {
    System.out.print("Masukkan kategori : ");
    String kategori = sc.nextLine();
    boolean ditemukan = false;

    System.out.println("\n==============================================================");
    System.out.printf("%-5s %-25s %-15s %-10s\n",
           "ID", "Nama Barang", "Kategori", "Stok");
    System.out.println("--------------------------------------------------------------");

    for (Barang b : data) {
        if (b.aktif &&
                b.kategori.equalsIgnoreCase(kategori)) {
            System.out.println(b);
            ditemukan = true;
        }
    }

    if (!ditemukan) {
        System.out.println("Data tidak ditemukan.");
    }
    System.out.println("==============================================================");
}
    // MENU SORTING
    static void sortMenu() {
        System.out.println("\n========== MENU SORTING ==========");
        System.out.println("1. Sort ID (Bubble Sort)");
        System.out.println("2. Sort Nama (Selection Sort)");
        System.out.println("3. Sort Jumlah Descending");
        System.out.print("Pilih : ");
        int pilih = inputInt();

        switch (pilih) {
            case 1:
                sortByID();
                break;
            case 2:
                sortByNama();
                break;
            case 3:
                sortByJumlah();
                break;
            default:
                System.out.println("Menu tidak tersedia.");
                return;
        }
            simpanData();
        System.out.println("Data berhasil diurutkan.");
        tampil();
    }

    // BUBBLE SORT ID
    static void sortByID() {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).id > data.get(j + 1).id) {
                    Barang temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }

    // SELECTION SORT NAMA
    static void sortByNama() {
        for (int i = 0; i < data.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).nama.compareToIgnoreCase(
                        data.get(min).nama) < 0) {

                    min = j;
                }
            }

            Barang temp = data.get(i);
            data.set(i, data.get(min));
            data.set(min, temp);
        }
    }

    // SORT JUMLAH DESCENDING
    static void sortByJumlah() {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).jumlah <
                        data.get(j + 1).jumlah) {

                    Barang temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }
    // STATISTIK DATA
    static void statistik() {

        int total = data.size();
        int aktif = 0;
        int dihapus = 0;

        for (Barang b : data) {
            if (b.aktif) {
                aktif++;
            } else {
                dihapus++;
            }
        }
        System.out.println("\n========== STATISTIK DATA ==========");
        System.out.println("Total Data Barang : " + total);
        System.out.println("Data Aktif        : " + aktif);
        System.out.println("Data Dihapus      : " + dihapus);
        System.out.println("====================================");
    }
}