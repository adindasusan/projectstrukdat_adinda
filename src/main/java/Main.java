import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    static List<String> pisahKalimat(String teks) {
        List<String> hasil = new ArrayList<>();
        String bersih = teks.replaceAll("\\s+", " ").trim();
        if (bersih.isEmpty()) {
            return hasil;
        }
        BreakIterator it = BreakIterator.getSentenceInstance(Locale.forLanguageTag("id-ID"));
        it.setText(bersih);
        int start = it.first();
        for (int end = it.next(); end != BreakIterator.DONE; start = end, end = it.next()) {
            String kalimat = bersih.substring(start, end).trim();
            if (!kalimat.isEmpty()) {
                hasil.add(kalimat);
            }
        }
        return hasil;
    }

    public static void main(String[] args) {
        String path = "sample.pdf";
        String output = "output.txt";

        if (!new File(path).exists()) {
            System.out.println("File tidak ditemukan: " + path);
            return;
        }

        try {
            List<String> teksPerHalaman = new PdfFileReader().bacaPerHalaman(path);

            List<String> baris = new ArrayList<>();
            for (int i = 0; i < teksPerHalaman.size(); i++) {
                Halaman<String> h = new Halaman<>(i + 1, pisahKalimat(teksPerHalaman.get(i)));
                baris.add(h.toString());
            }

            Files.write(Paths.get(output), baris, StandardCharsets.UTF_8);
            System.out.println("Berhasil menulis " + baris.size() + " halaman ke " + output);
        } catch (IOException e) {
            System.out.println("Gagal memproses PDF: " + e.getMessage());
        }
    }
}