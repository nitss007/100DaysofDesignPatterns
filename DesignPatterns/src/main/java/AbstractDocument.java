import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class  AbstractDocument implements Document{
    public final Map<String, Object> properties;

    protected AbstractDocument(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "properties map is required");
        this.properties = properties;
    }

    public Object get(String key){
        return properties.get(key);
    }
    public Void put(String key, Object value){
        properties.put(key,value);
        return null;
    }

    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor){
        return  Stream.ofNullable(get(key))
//                .filter(Object::nonNull)
                .map(el -> (List<Map<String, Object>>) el)
                .findAny()
                .stream()
                .flatMap(Collection::stream)
                .map(constructor);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append(getClass().getName()).append("[");
        properties.forEach((k,v) -> builder.append("[").append(k).append(":").append(v).append("]"));
        return builder.append("]").toString();
    }
}
