
import java.util.Map;
import java.util.Optional;

public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {
    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
