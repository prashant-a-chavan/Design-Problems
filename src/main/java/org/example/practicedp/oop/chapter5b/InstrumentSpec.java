package org.example.practicedp.oop.chapter5b;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.practicedp.oop.chapter5b.enums.Builder;
import org.example.practicedp.oop.chapter5b.enums.Type;
import org.example.practicedp.oop.chapter5b.enums.Wood;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
public class InstrumentSpec {
    private Map<String, Object> properties;

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
}
