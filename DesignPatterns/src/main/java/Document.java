import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {
    public Object get(String key);
    public Void put(String key, Object value);
    <T> Stream<T> children(String key, Function<Map<String,Object>,T> constructor);
}
