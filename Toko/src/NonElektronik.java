// Kelas turunan dari Barang, menggunakan interface Harga
class NonElektronik extends Barang implements Harga { //Inheritance
    public NonElektronik() {
        super("Gurita hp", 3000);
    }

    @Override
    public long hitungTotalBayar(long jumlah) {
        return (long) harga * jumlah;
    }
}