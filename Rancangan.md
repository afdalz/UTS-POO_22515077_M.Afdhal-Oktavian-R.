1. Rancangan Class Entitas 1: Menu
   Merepresentasikan item makanan atau minuman yang dijual oleh restoran.
   -Atribut (Private):
    -private String kodeMenu;
    -private String namaMenu;
    -private double harga;
    -private String kategori;
   -Konstruktor:
    -public Menu() (Default)
    -public Menu(String kodeMenu, String namaMenu, double harga, String kategori) (Berparameter)--
   -Getter & Setter (dengan Validasi):
    -getKodeMenu(), setKodeMenu(String kodeMenu)
    -getNamaMenu(), setNamaMenu(String namaMenu)		 
    -getHarga(), setHarga(double harga) > Validasi: harga harus > 0   
    -getKategori(), setKategori(String kategori)
   -Method Perilaku (Minimal 3 di luar Getter/Setter):  
    -public void tampilkanInfoMenu() — Mencetak informasi detail menu ke 			 konsol.
    -public void ubahHarga(double hargaBaru) — Mengubah harga menu dengan 			-memanggil validasi setter.
    -public boolean cekKetersediaan() — Mengembalikan status ketersediaan menu 		 (boolean).
2. Rancangan Class Entitas 2: Pelanggan
   Merepresentasikan konsumen yang datang atau memesan makanan di restoran.
   -Atribut (Private):
    -private String idPelanggan;
    -private String namaPelanggan;
    -private String nomorTelepon;
    -private String alamat;
   -Konstruktor:
    -public Pelanggan() (Default)
    -public Pelanggan(String idPelanggan, String namaPelanggan, String 			 nomorTelepon, String alamat) (Berparameter)
   -Getter & Setter:
    -getIdPelanggan(), setIdPelanggan(String idPelanggan)
    -getNamaPelanggan(), setNamaPelanggan(String namaPelanggan)
    -getNomorTelepon(), setNomorTelepon(String nomorTelepon)
    -getAlamat(), setAlamat(String alamat)
   -Method Perilaku (Minimal 3):
    -public void tampilkanInfoPelanggan() — Menampilkan profil singkat --
    -pelanggan.public void updateNomorTelepon(String telpBaru) — Memperbarui 
    -nomor telepon pelanggan.public void updateAlamat(String alamatBaru) — 			 Memperbarui data alamat pelanggan.
3. Rancangan Class Entitas 3: Pesanan
   Merepresentasikan transaksi utama yang menghubungkan pelanggan dengan daftar menu yang dipilih (menerapkan relasi dan aturan bisnis pajak).
   -Atribut (Private):
    -private String idPesanan;
    -private Pelanggan pelanggan; (Relasi Asosiasi ke Pelanggan)
    -private List<Menu> daftarMenu; (Relasi Agregasi/Komposisi ke Menu 			 menggunakan ArrayList)
    -private double totalBiaya;
    -private String statusPesanan;
   -Konstruktor:
    -public Pesanan() (Default)
    -public Pesanan(String idPesanan, Pelanggan pelanggan) (Berparameter)
   -Getter & Setter:
    -getIdPesanan(), setIdPesanan(...)
    -getPelanggan(), setPelanggan(...)
    -getDaftarMenu()
    -getTotalBiaya()
    -getStatusPesanan()
   -Method Perilaku (Minimal 3):
    -public void tambahMenuPesanan(Menu menu) — Memasukkan objek Menu ke dalam 	 	 ArrayList daftarMenu.
    -public void hitungTotalBiaya() — Aturan Bisnis: Menjumlahkan subtotal 			 harga menu dan otomatis menghitung penambahan pajak 10% (subtotal * 0.10).   
    -public void ubahStatusPesanan(String statusBaru) — Mengubah status pesanan 		 (misal:"Pending" menjadi "Diproses" atau "Selesai") dengan validasi teks.
4. Rancangan Class Entitas 4: Restoran
   Merepresentasikan sistem manajemen pusat yang menampung seluruh inventaris menu dan data pelanggan dalam memori.
   -Atribut (Private):
    -private String namaRestoran;
    -private String alamatRestoran;
    -private List<Menu> listMenu;
    -private List<Pelanggan> listPelanggan;
   -Konstruktor:
    -public Restoran() (Default)
    -public Restoran(String namaRestoran, String alamatRestoran) (Berparameter)	-Getter & Setter:
    -getNamaRestoran(), setNamaRestoran(...)
    -getAlamatRestoran(), setAlamatRestoran(...)
    -getListMenu(), getListPelanggan()
   -Method Perilaku (Minimal 3):  
    -public void tambahMenu(Menu menu) — Menambahkan objek menu baru ke 			 listMenu.
    -public void tambahPelanggan(Pelanggan pelanggan) — Menambahkan objek 			 pelanggan baru ke listPelanggan.
    -public Menu cariMenu(String kode) — Mencari menu berdasarkan atribut kunci 		 kode menu.
    -public Pelanggan cariPelanggan(String id) — Mencari pelanggan berdasarkan 		 atribut kunci ID pelanggan.
5. Rancangan Class ADT: QueuePesanan (Queue / FIFO)
   Class struktur data khusus untuk mengantrekan objek Pesanan.   
   -Atribut (Private):
    -private Pesanan[] dataQueue;
    -private int front;
    -private int rear;
    -private int size;
    -private int capacity;
   -Konstruktor:
    -public QueuePesanan(int capacity) — Menginisialisasi ukuran maksimal 			 antrean array.
   -Operasi Wajib ADT Queue:
    -public boolean isEmpty() — Mengecek apakah antrean kosong.
    -public boolean isFull() — Mengecek apakah antrean penuh.
    -public void enqueue(Pesanan pesanan) — Menambahkan pesanan ke bagian 			 belakang antrean (rear).
    -public Pesanan dequeue() — Mengeluarkan pesanan terdepan (front) untuk 		 diproses (FIFO).
    -public Pesanan front() — Melihat data pesanan yang berada di posisi 			 terdepan tanpa menghapusnya.
    -public int size() — Mengembalikan jumlah total antrean yang sedang aktif.
6. Rancangan Class Utama: Main
   -Method Utama::
    -public static void main(String[] args) — Menjalankan perulangan menu 			 konsol interaktif (do-while dan switch-case) dengan pengamanan validasi i		 nput Scanner (hasNextInt() / hasNextDouble()) agar program tidak crash.
