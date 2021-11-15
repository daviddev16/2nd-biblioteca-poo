package org.david;

public interface Unique extends Comparable<Unique> {

    int getUniqueId();

    @Override
    default int compareTo(Unique other) {
        return Integer.compare(getUniqueId(), other.getUniqueId());
    }

}
