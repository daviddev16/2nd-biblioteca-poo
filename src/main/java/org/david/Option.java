package org.david;

import org.david.annotations.Metadata;

public interface Option<E> {

    void display(Selector selector, E handled);

    default Metadata getMetadata() {
        return getClass().getAnnotation(Metadata.class);
    }

    default String getName() {
        return getMetadata() != null ? getMetadata().name() : null;
    }

    default String getDescription() {
        return getMetadata() != null ? getMetadata().description() : null;
    }

}
