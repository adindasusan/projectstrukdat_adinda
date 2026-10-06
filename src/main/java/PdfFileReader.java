import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfFileReader {
    public List<String> bacaPerHalaman(String path) throws IOException {
        List<String> hasil = new ArrayList<>();
        try (PDDocument doc = Loader.loadPDF(new File(path))) {
            PDFTextStripper stripper = new PDFTextStripper();
            for (int i = 1; i <= doc.getNumberOfPages(); i++) {
                stripper.setStartPage(i);
                stripper.setEndPage(i);
                hasil.add(stripper.getText(doc).trim());
            }
        }
        return hasil;
    }
}