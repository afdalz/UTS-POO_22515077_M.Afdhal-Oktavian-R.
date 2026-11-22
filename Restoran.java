import java.util.ArrayList;
import java.util.List;

public class Restoran {
    private String namaRestoran;
    private List<Menu> listMenu;
    private List<Pelanggan> listPelanggan;

    public Restoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
        this.listMenu = new ArrayList<>();
        this.listPelanggan = new ArrayList<>();
    }

    public void tambahMenu(Menu menu) {
        listMenu.add(menu);
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        listPelanggan.add(pelanggan);
    }

    public Menu cariMenu(String kode) {
        for (Menu m : listMenu) {
            if (m.getKodeMenu().equalsIgnoreCase(kode)) {
                return m;
            }
        }
        return null;
    }

    public Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : listPelanggan) {
            if (p.getIdPelanggan().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public void tampilkanSemuaMenu() {
        System.out.println("=== DAFTAR MENU RESTORAN " + namaRestoran + " ===");
        if (listMenu.isEmpty()) {
            System.out.println("Belum ada menu.");
        } else {
            for (Menu m : listMenu) {
                m.tampilkanInfoMenu();
            }
        }
    }

    public void tampilkanSemuaPelanggan() {
        System.out.println("=== DAFTAR PELANGGAN " + namaRestoran + " ===");
        if (listPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
        } else {
            for (Pelanggan p : listPelanggan) {
                p.tampilkanInfoPelanggan();
            }
        }
    }
}