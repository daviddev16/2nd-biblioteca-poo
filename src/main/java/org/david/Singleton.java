package org.david;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Singleton {

    private static Set<Object> singletons;

    static {
        singletons = Collections.synchronizedSet(new HashSet<>());
    }

    private Singleton() {}

    public synchronized static <E> E of(E instance) throws InstantiationException {
        if (instance == null)
            throw new NullPointerException("Instância nula.");

        else if (findInstanceByClass(instance.getClass()) != null)
            throw new InstantiationException(instance.getClass().getSimpleName() + " já instanciado.");

        else
            singletons.add(instance);

        return instance;
    }

    @SuppressWarnings({"unchecked", "unsafe"})
    public synchronized static <E> E getInstance(Class<E> instanceClass) {
        if (instanceClass == null)
            throw new NullPointerException("Tipo nulo.");

        E instance = (E) findInstanceByClass(instanceClass);

        if (instance != null)
            return instance;

        throw new NullPointerException("Classe não instanciada.");
    }

    private static Object findInstanceByClass(Class<?> instanceClass) {
        return singletons.stream()
                .filter(instance -> instance.getClass().isAssignableFrom(instanceClass))
                .findAny()
                .orElse(null);
    }

}
