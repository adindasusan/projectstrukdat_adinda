import java.util.List;

public class ConsoleViewer<T> implements Viewer<T> {
    @Override
    public void view(List<T> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println("=== Halaman " + (i + 1) + " ===");
            System.out.println(items.get(i));
            System.out.println();
        }
    }
}