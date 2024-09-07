public class TestMahasiswa {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa();
        Mahasiswa mhs2 = new Mahasiswa();
        Mahasiswa mhs3= new Mahasiswa();

        mhs1.nim=101;
        mhs1.nama="Lestari";
        mhs1.alamat="Jl. Vinolia No 1A";
        mhs1.kelas="1A";
        mhs1.tampilBiodata();

        mhs1.nim=102;
        mhs1.nama="Arka";
        mhs1.alamat="Jl. Batu Amaril";
        mhs1.kelas="1G";
        mhs1.tampilBiodata();

        mhs1.nim=103;
        mhs1.nama="Tono";
        mhs1.alamat="Jl. Serayu";
        mhs1.kelas="1H";
        mhs1.tampilBiodata();
    }   
}
