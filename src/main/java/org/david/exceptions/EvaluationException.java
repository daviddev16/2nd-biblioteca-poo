package org.david.exceptions;

import java.util.Collection;
import java.util.StringJoiner;

public class EvaluationException extends RuntimeException {

    public EvaluationException(String message) {
        super(message);
    }

    public EvaluationException(Class<?> actualType, Collection<Class<?>> expectedTypes) {
        this("Actual: " + actualType.getSimpleName() + ", Expected: " + typesToString(expectedTypes));
    }

    private static String typesToString(Collection<Class<?>> types) {
        if (types == null)
            return "[?]";

        StringJoiner stringTypes = new StringJoiner("/");
        types.forEach(t -> stringTypes.add(t.getSimpleName()));

        return "[Any: " + stringTypes.toString() + "]";
    }

}