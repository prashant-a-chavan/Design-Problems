package practicedp.oop.chapter5b;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InstrumentSpec {
    private Map<String, Object> properties;

    public InstrumentSpec() {
        this.properties = new HashMap<>();
    }

    public InstrumentSpec(Map<String, Object> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
        } else {
            this.properties = new HashMap<>(properties);
        }
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public boolean matches(InstrumentSpec otherSpec) {
        for (String propertyName : otherSpec.getProperties().keySet()) {
            if (!Objects.equals(getProperty(propertyName), otherSpec.getProperty(propertyName))) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties == null ? new HashMap<>() : new HashMap<>(properties);
    }
}
