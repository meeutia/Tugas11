// Kelas utama untuk merepresentasikan barang elektronik
class Barang {
    String nama;
    long harga;

    public Barang(String nama, long harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println(nama + " = Rp. " + harga);
    }

    public long hitungTotalBayar(long jumlahBeli) {
        return 0;
    }
}