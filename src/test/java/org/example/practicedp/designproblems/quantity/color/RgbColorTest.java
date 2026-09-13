package org.example.practicedp.designproblems.quantity.color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RgbColorTest {

    @Test
    void shouldPreserveWhiteHexColor() {
        RgbColor color = RgbColor.of("#FFFFFF");

        assertEquals("#FFFFFF", color.toHex());
    }

    @Test
    void shouldBlendGreenAndRedUsingFloorAverage() {
        RgbColor result = RgbColor.of("#00FF00")
                .plus(RgbColor.of("#FF0000"));

        assertEquals("#7F7F00", result.toHex());
    }

    @Test
    void shouldBlendSameColorsWithoutChangingColor() {
        RgbColor result = RgbColor.of("#FFFFFF")
                .plus(RgbColor.of("#FFFFFF"));

        assertEquals("#FFFFFF", result.toHex());
    }

    @Test
    void shouldFloorDecimalChannelAverage() {
        RgbColor result = RgbColor.of(0, 0, 0)
                .plus(RgbColor.of(255, 255, 255));

        assertEquals("#7F7F7F", result.toHex());
    }

    @Test
    void shouldCreateColorFromRgbChannels() {
        RgbColor color = RgbColor.of(255, 127, 0);

        assertEquals("#FF7F00", color.toHex());
    }

    @Test
    void shouldNormalizeLowercaseHexToUppercase() {
        RgbColor color = RgbColor.of("#ff0000");

        assertEquals("#FF0000", color.toHex());
    }

    @Test
    void shouldRejectHexWithoutHash() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of("FF0000")
        );
    }

    @Test
    void shouldRejectShortHexColor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of("#FFF")
        );
    }

    @Test
    void shouldRejectLongHexColor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of("#FFFFFFFF")
        );
    }

    @Test
    void shouldRejectInvalidHexCharacters() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of("#GG0000")
        );
    }

    @Test
    void shouldRejectNullHexColor() {
        assertThrows(
                NullPointerException.class,
                () -> RgbColor.of((String) null)
        );
    }

    @Test
    void shouldRejectNegativeRedChannel() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of(-1, 0, 0)
        );
    }

    @Test
    void shouldRejectGreenChannelAboveMaximum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of(0, 256, 0)
        );
    }

    @Test
    void shouldRejectBlueChannelAboveMaximum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RgbColor.of(0, 0, 256)
        );
    }

    @Test
    void shouldRejectNullColorDuringBlend() {
        RgbColor color = RgbColor.of("#FF0000");

        assertThrows(
                NullPointerException.class,
                () -> color.plus(null)
        );
    }

    @Test
    void shouldConsiderSameRgbValuesEqual() {
        RgbColor first = RgbColor.of("#FF0000");
        RgbColor second = RgbColor.of(255, 0, 0);

        assertEquals(first, second);
    }

    @Test
    void shouldProduceSameHashCodeForEqualColors() {
        RgbColor first = RgbColor.of("#FF0000");
        RgbColor second = RgbColor.of(255, 0, 0);

        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void shouldConsiderDifferentColorsNotEqual() {
        RgbColor red = RgbColor.of("#FF0000");
        RgbColor green = RgbColor.of("#00FF00");

        assertNotEquals(red, green);
    }

    @Test
    void shouldReturnHexFromToString() {
        RgbColor color = RgbColor.of("#00FF00");

        assertEquals("#00FF00", color.toString());
    }
}