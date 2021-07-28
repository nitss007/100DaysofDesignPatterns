import java.util.Map;
import java.util.Optional;

public class Parts extends AbstractDocument implements HasModel, HasPrice, HasType {
    public Parts(Map<String, Object> properties) {
        super(properties);
    }
}
