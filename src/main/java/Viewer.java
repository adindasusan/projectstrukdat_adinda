import java.util.List;

public interface Viewer<T> {
    void view(List<T> items);
}