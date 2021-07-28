import enums.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        LOGGER.info("Constructing parts and car");

        Map<String, ? extends Serializable> wheelProperties = Map.of(
                Property.TYPE.toString(), "wheel",
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 100L);

        Map<String, ? extends Serializable> doorProperties = Map.of(
                Property.TYPE.toString(), "door",
                Property.MODEL.toString(), "Lambo",
                Property.PRICE.toString(), 300L);

        Map<String, Object> carProperties = Map.of(
                Property.MODEL.toString(), "300SL",
                Property.PRICE.toString(), 10000L,
                Property.PARTS.toString(), List.of(wheelProperties, doorProperties));

        var car = new Car(carProperties);

        LOGGER.info("Here is our car:");
        LOGGER.info("-> model: {}", car.getModel().orElseThrow());
        LOGGER.info("-> price: {}", car.getPrice().orElseThrow());
        LOGGER.info("-> parts: ");
        car.getParts().forEach(p -> LOGGER.info("\t{}/{}/{}",
                p.getType().orElse(null),
                p.getModel().orElse(null),
                p.getPrice().orElse(null))
        );
    }
}