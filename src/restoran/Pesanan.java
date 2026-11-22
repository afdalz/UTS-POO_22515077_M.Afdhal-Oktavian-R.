package restoran;
import java.util.ArrayList;
import java.util.List;  

public class Pesanan {
    private String idPesanan;
    private Pelanggan pelanggan; // Relasi Asosiasi/Agregasi
    private List<Menu> daftarMenu; // Relasi Komposisi/Agregasi
    private double totalBiaya;
    private String statusPesanan; // Contoh: "Pending", "Diproses", "Selesai"

    public Pesanan(String idPesanan, Pelanggan pelanggan) {
        this.idPesanan = idPesanan;
        this.pelanggan = pelanggan;
        this.daftarMenu = new ArrayList<>();
        this.totalBiaya = 0.0;
        this.statusPesanan = "Pending";
    }

    public void tambahMenuPesanan(Menu menu) {
        if (menu != null) {
            daftarMenu.add(menu);
            hitungTotalBiaya();
        }
    }

    // Aturan bisnis: Pesanan memuat minimal 1 menu dan pajak 10% dihitung otomatis
    public void hitungTotalBiaya() {
        double subtotal = 0;
        for (Menu m : daftarMenu) {
            subtotal += m.getHarga();
        }
        double pajak = subtotal * 0.10;
        this.totalBiaya = subtotal + pajak;
    }

    public void ubahStatusPesanan(String statusBaru) {
        this.statusBaruValidator(statusBaru);
    }

    private void statusBrBaru(String status) {
        this.statusPesanan = status;
    }

    private void statusBaruValidator(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.statusPesanan = status;
            System.out.println("Status pesanan " + idPesanan + " diubah menjadi: " + status);
        } else {
            System.out.println("Status tidak valid!");
        }
    }

    public void tampilkanDetailPesanan() {
        System.out.println("ID Pesanan: " + idPesanan);
        if (pelanggan != null) {
            System.out.println("Pelanggan: " + pelanggan.getNamaPelanggan());
        }
        System.out.println("Daftar Menu Pesanan:");
        if (daftarMenu.isEmpty()) {
            System.out.println("  (Belum ada menu - Melanggar aturan bisnis min 1 menu)");
        } else {
            for (Menu m : daftarMenu) {
                System.out.println("  - " + m.getNamaMenu() + " (Rp " + m.getHarga() + ")");
            }
        }
        System.out.println("Total Biaya (termasuk pajak 10%): Rp " + totalBiaya);
        System.out.println("Status: " + statusPesanan);
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public List<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }
}
