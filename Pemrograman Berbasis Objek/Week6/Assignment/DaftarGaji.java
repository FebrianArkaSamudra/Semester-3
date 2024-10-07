package Assignment;

public class DaftarGaji {
    public Pegawai[] listPegawai;
    private int currentIndex = 0;

    public DaftarGaji(int jumlahPegawai) {
        listPegawai = new Pegawai[jumlahPegawai];
    }

    public void addPegawai(Pegawai pegawai) {
        if (currentIndex < listPegawai.length) {
            listPegawai[currentIndex] = pegawai;
            currentIndex++;
        } else {
            System.out.println("List penuh, tidak bisa menambahkan pegawai.");
        }
    }

    public void printSemuaGaji() {
        for (Pegawai pegawai : listPegawai) {
            if (pegawai != null) {
                System.out.println("Nama: " + pegawai.getNama() + ", Gaji: " + pegawai.getGaji());
            }
        }
    }
}