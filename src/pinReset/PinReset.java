package pinReset;

public class PinReset {

    private static final Converter converter = new Converter();

    private static final Character PADDING = 'F';
    private static final Character ISO_FORMAT = '0'; // ISO 9564-1 0
    private static final Integer CLEAR_PIN_LENGTH = 16;
    private static final Integer RADIX = 10;

    public static String encodePin(String pin, String pan) {
        if (pan.length() != 16 || pin.length() > 8 || pin.length() < 4)
            throw new IllegalArgumentException("invalid pan or pin");
        String[] preparedPin = preparePin(pin);
        String[] preparedPan = preparePan(pan);
        return generateClearPin(preparedPin, preparedPan);
    }

    private static String[] preparePin(String pin) {
        String[] pinBinary = new String[CLEAR_PIN_LENGTH];
        pinBinary[0] = converter.getBinaryValue(ISO_FORMAT);
        pinBinary[1] = converter.getBinaryValue(Character.forDigit(pin.length(), RADIX));
        for (int i = 0; i < pin.length(); i++) pinBinary[i + 2] = converter.getBinaryValue(pin.charAt(i));
        for (int i = pin.length() + 2; i < CLEAR_PIN_LENGTH; i++) pinBinary[i] = converter.getBinaryValue(PADDING);
        return pinBinary;
    }

    private static String[] preparePan(String pan) {
        String[] panBinary = new String[CLEAR_PIN_LENGTH];
        for (int i = 0; i < pan.length(); i++) {
            if (i < 4) panBinary[i] = converter.getBinaryValue('0');
            else panBinary[i] = converter.getBinaryValue(pan.charAt(i - 1));
        }
        return panBinary;
    }

    private static String generateClearPin(String[] preparedPin, String[] preparedPan) {
        StringBuilder cleanPin = new StringBuilder();
        for (int i = 0; i < CLEAR_PIN_LENGTH; i++) {
            String pin = preparedPin[i];
            String pan = preparedPan[i];
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 4; j++) builder.append(pin.charAt(j) ^ pan.charAt(j));
            cleanPin.append(converter.getHexValue(builder.toString()));
        }
        return cleanPin.toString();
    }

    private static String reverseClearPin(String clearPin, String pan) {
        String[] pinBinary = new String[CLEAR_PIN_LENGTH];
        for (int i = 0; i < clearPin.length(); i++) pinBinary[i] = converter.getBinaryValue(clearPin.charAt(i));
        String pin = generateClearPin(pinBinary, preparePan(pan));
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < pin.length(); i++) {
            if (pin.charAt(i) == 'F') break;
            builder.append(pin.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String pin = encodePin("123456", "5432101234567890");
        String decoded = reverseClearPin(pin, "5432101234567890");
        System.out.println(pin);
        System.out.println(decoded);
    }
}

