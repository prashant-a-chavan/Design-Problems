package practicedp.designproblems.quantity.color;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public final class RgbColor {

    private static final int MIN_CHANNEL_VALUE = 0;
    private static final int MAX_CHANNEL_VALUE = 255;

    private static final Pattern HEX_PATTERN = Pattern.compile("^#[0-9A-Fa-f]{6}$");

    private final int red;
    private final int green;
    private final int blue;

    private RgbColor(int red, int green, int blue) {
        this.red = validateChannel("red", red);
        this.green = validateChannel("green", green);
        this.blue = validateChannel("blue", blue);
    }

    public static RgbColor of(String hex) {
        validateHex(hex);
        return new RgbColor(RgbParser.parseChannel(hex, 1), RgbParser.parseChannel(hex, 3), RgbParser.parseChannel(hex, 5));
    }

    public static RgbColor of(int red, int green, int blue) {
        return new RgbColor(red, green, blue);
    }

    public RgbColor plus(RgbColor other) {
        Objects.requireNonNull(other, "Color to blend cannot be null");
        return new RgbColor(average(red, other.red), average(green, other.green), average(blue, other.blue));
    }

    public String toHex() {
        return String.format(Locale.ROOT, "#%02X%02X%02X", red, green, blue);
    }

    @Override
    public String toString() {
        return toHex();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RgbColor other)) return false;

        return red == other.red && green == other.green && blue == other.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    private static int average(int first, int second) {
        return (first + second) / 2;
    }

    private static void validateHex(String hex) {
        Objects.requireNonNull(hex, "Hex color cannot be null");

        if (!HEX_PATTERN.matcher(hex).matches()) {
            throw new IllegalArgumentException("Expected RGB hex format #RRGGBB, but got: " + hex);
        }
    }

    private static int validateChannel(String channelName, int value) {
        if (value < MIN_CHANNEL_VALUE || value > MAX_CHANNEL_VALUE) {
            throw new IllegalArgumentException("%s channel must be between %d and %d, but got: %d".formatted(channelName, MIN_CHANNEL_VALUE, MAX_CHANNEL_VALUE, value));
        }

        return value;
    }
}