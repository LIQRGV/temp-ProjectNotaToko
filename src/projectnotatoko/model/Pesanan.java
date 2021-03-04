package projectnotatoko.model;

public class Pesanan {
    private Barang barang;
    private int kuantitas;

    public Pesanan(Barang barang, int kuantitas) {
        this.barang = barang;
        this.kuantitas = kuantitas;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public int getJumlahBayar() {
        return barang.getHarga() * kuantitas;
    }
}
