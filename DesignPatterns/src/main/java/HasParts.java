import enums.Property;

import java.util.Optional;
import java.util.stream.Stream;

public interface HasParts extends  Document{
    default Stream<Parts> getParts(){
        return children(Property.PARTS.toString(), Parts::new);
    }
}
