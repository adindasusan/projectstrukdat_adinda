import java.util.List;

public class Halaman<T> {
    private final int nomor;
    private final List<T> isi;

    public Halaman(int nomor, List<T> isi) {
        this.nomor = nomor;
        this.isi = isi;
    }

    public int getNomor() {
        return nomor;
    }

    public List<T> getIsi() {
        return isi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Halaman ").append(nomor).append(" ===\n");
        for (int i = 0; i < isi.size(); i++) {
            sb.append(i + 1).append(". ").append(isi.get(i)).append("\n");
        }
        return sb.toString();
    }
}