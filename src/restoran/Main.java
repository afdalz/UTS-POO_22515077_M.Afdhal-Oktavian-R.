package restoran;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restoran restoran = new Restoran("Nusantara Restaurant", "Jl. Hj. Lamuse");
        QueuePesanan antreanPesanan = new QueuePesanan(5);

        int pilihan = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEM MANAJEMEN RESTORAN (NIM: 22515077)  ");
            System.out.println("========================================");
            System.out.println("1. Tambah & Tampilkan Menu");
            System.out.println("2. Tambah & Tampilkan Pelanggan");
            System.out.println("3. Buat Pesanan & Masukkan ke Antrean (Enqueue)");
            System.out.println("4. Proses Antrean Pesanan (Dequeue)");
            System.out.println("5. Tampilkan Antrean & Pesanan Terdepan");
            System.out.println("6. Cari Data Menu / Pelanggan");
            System.out.println("7. Ringkasan Restoran");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu (1-8): ");

            // Validasi input angka agar tidak crash jika diinput huruf
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Bersihkan newline
            } else {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Menu: ");
                    String kodeM = scanner.nextLine();
                    System.out.print("Masukkan Nama Menu: ");
                    String namaM = scanner.nextLine();
                    System.out.print("Masukkan Kategori Menu (contoh: Makanan/Minuman): ");
                    String kategoriM = scanner.nextLine();
                    System.out.print("Masukkan Harga Menu: ");
                    if (scanner.hasNextDouble()) {
                        double hargaM = scanner.nextDouble();
                        scanner.nextLine();
                        Menu menuBaru = new Menu(kodeM, namaM,kategoriM, hargaM);
                        restoran.tambahMenu(menuBaru);
                        System.out.println("Menu berhasil ditambahkan!");
                    } else {
                        System.out.println("Harga harus berupa angka!");
                        scanner.nextLine();
                    }
                    restoran.tampilkanSemuaMenu();
                    break;

                case 2:
                    System.out.print("Masukkan ID Pelanggan: ");
                    String idP = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String namaP = scanner.nextLine();
                    System.out.print("Masukkan No. Telepon: ");
                    String telpP = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String AlamatP = scanner.nextLine();
                    Pelanggan pelangganBaru = new Pelanggan(idP, namaP, telpP, AlamatP);
                    restoran.tambahPelanggan(pelangganBaru);
                    System.out.println("Pelanggan berhasil ditambahkan!");
                    restoran.tampilkanSemuaPelanggan();
                    break;

                case 3:
                    System.out.print("Masukkan ID Pesanan: ");
                    String idOrd = scanner.nextLine();
                    System.out.print("Masukkan ID Pelanggan yang memesan: ");
                    String idPel = scanner.nextLine();
                    Pelanggan pDitemukan = restoran.cariPelanggan(idPel);

                    if (pDitemukan != null) {
                        Pesanan pesananBaru = new Pesanan(idOrd, pDitemukan);

                        // Aturan Bisnis: Pesanan memuat minimal 1 menu
                        boolean tambahLagi = true;
                        while (tambahLagi) {
                            restoran.tampilkanSemuaMenu();
                            System.out.print("Masukkan Kode Menu yang ingin ditambahkan ke pesanan: ");
                            String kMenu = scanner.nextLine();
                            Menu mDitemukan = restoran.cariMenu(kMenu);
                            if (mDitemukan != null) {
                                pesananBaru.tambahMenuPesanan(mDitemukan);
                                System.out.println("Menu " + mDitemukan.getNamaMenu() + " ditambahkan.");
                            } else {
                                System.out.println("Menu tidak ditemukan.");
                            }
                            System.out.print("Tambah menu lain ke pesanan ini? (y/n): ");
                            String jawab = scanner.nextLine();
                            if (jawab.equalsIgnoreCase("n")) {
                                tambahLagi = false;
                            }
                        }

                        if (pesananBaru.getDaftarMenu().size() > 0) {
                            antreanPesanan.enqueue(pesananBaru);
                        } else {
                            System.out.println("Gagal: Pesanan harus memuat minimal 1 menu!");
                        }
                    } else {
                        System.out.println("Pelanggan tidak ditemukan. Daftarkan pelanggan terlebih dahulu.");
                    }
                    break;

                case 4:
                    antreanPesanan.dequeue();
                    break;

                case 5:
                    antreanPesanan.tampilkanQueue();
                    if (!antreanPesanan.isEmpty()) {
                        System.out.println("Pesanan di depan antrean:");
                        antreanPesanan.front().tampilkanDetailPesanan();
                    }
                    break;

                case 6:
                    System.out.print("Cari apa? (1. Menu / 2. Pelanggan): ");
                    int subCari = scanner.nextInt();
                    scanner.nextLine();
                    if (subCari == 1) {
                        System.out.print("Masukkan Kode Menu: ");
                        String cKode = scanner.nextLine();
                        Menu hasilM = restoran.cariMenu(cKode);
                        if (hasilM != null) hasilM.tampilkanInfoMenu();
                        else System.out.println("Menu tidak ditemukan.");
                    } else if (subCari == 2) {
                        System.out.print("Masukkan ID Pelanggan: ");
                        String cId = scanner.nextLine();
                        Pelanggan hasilP = restoran.cariPelanggan(cId);
                        if (hasilP != null) hasilP.tampilkanInfoPelanggan();
                        else System.out.println("Pelanggan tidak ditemukan.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 7:
                    System.out.println("=== RINGKASAN SISTEM RESTORAN ===");
                    restoran.tampilkanSemuaMenu();
                    restoran.tampilkanSemuaPelanggan();
                    antreanPesanan.tampilkanQueue();
                    break;

                case 8:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilihan != 8);

        scanner.close();
    }
}