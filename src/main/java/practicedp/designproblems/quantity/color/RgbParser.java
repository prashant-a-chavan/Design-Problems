package practicedp.designproblems.quantity.color;

final class RgbParser {

    private RgbParser() {
    }

    static int parseChannel(String hex, int startIndex) {
        return Integer.parseInt(hex.substring(startIndex, startIndex + 2), 16);
    }
}