public class MainTask2 {
    public static void aktivitasMakan(Manusia manusia) {
        manusia.makan();
    }

    public static void main(String[] args) {
        System.out.println("Testing with Dosen object:");
        Manusia dosen = new Dosen();  
        aktivitasMakan(dosen);  
        ((Dosen) dosen).lembur();  

        System.out.println("\nTesting with Mahasiswa object:");
        Manusia mahasiswa = new Mahasiswa();  
        aktivitasMakan(mahasiswa);  
        if (mahasiswa instanceof Mahasiswa) {
            ((Mahasiswa) mahasiswa).tidur(); 
        }
    }
}