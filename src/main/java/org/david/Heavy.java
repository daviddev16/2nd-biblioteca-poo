package org.david;

import org.david.annotations.Unsafe;
import org.david.annotations.When;

import java.util.Objects;
import java.util.Scanner;

@Unsafe(when = When.MAYBE)
public final class Heavy {

    private final String value;

    @Unsafe(when = "scanner == null")
    public Heavy(Scanner scanner) {
        this.value = Objects.requireNonNull(scanner, "scanner cannot be null.").next();
    }

    @Unsafe(when = "value != int")
    public int getAsInt() {
        return Integer.parseInt(getAsString());
    }

    @Unsafe(when = "value != float")
    public float getAsFloat() {
        return Float.parseFloat(getAsString());
    }

    @Unsafe(when = "value != double")
    public double getAsDouble() {
        return Double.parseDouble(getAsString());
    }

    @Unsafe(when = "value != byte")
    public byte getAsByte() {
        return Byte.parseByte(getAsString());
    }

    @Unsafe(when = "value != float")
    public boolean getAsBoolean() {
        return Boolean.parseBoolean(getAsString());
    }

    @Unsafe(when = "value != long")
    public long getAsLong() {
        return Long.parseLong(getAsString());
    }

    @Unsafe(when = When.NEVER)
    public String getAsString() {
        return value.trim();
    }

    @Override
    public String toString() {
        return "Heavy{" +
                "value='" + value + '\'' +
                '}';
    }

}
