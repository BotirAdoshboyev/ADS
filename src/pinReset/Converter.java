package pinReset;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    private final Map<String, Character> hexValue;
    private final Map<Character, String> binaryValue;

    public Converter() {
        hexValue = new HashMap<>();
        hexValue.put("0000", '0');
        hexValue.put("0001", '1');
        hexValue.put("0010", '2');
        hexValue.put("0011", '3');
        hexValue.put("0100", '4');
        hexValue.put("0101", '5');
        hexValue.put("0110", '6');
        hexValue.put("0111", '7');
        hexValue.put("1000", '8');
        hexValue.put("1001", '9');
        hexValue.put("1010", 'A');
        hexValue.put("1011", 'B');
        hexValue.put("1100", 'C');
        hexValue.put("1101", 'D');
        hexValue.put("1110", 'E');
        hexValue.put("1111", 'F');

        binaryValue = new HashMap<>();
        binaryValue.put('0', "0000");
        binaryValue.put('1', "0001");
        binaryValue.put('2', "0010");
        binaryValue.put('3', "0011");
        binaryValue.put('4', "0100");
        binaryValue.put('5', "0101");
        binaryValue.put('6', "0110");
        binaryValue.put('7', "0111");
        binaryValue.put('8', "1000");
        binaryValue.put('9', "1001");
        binaryValue.put('A', "1010");
        binaryValue.put('B', "1011");
        binaryValue.put('C', "1100");
        binaryValue.put('D', "1101");
        binaryValue.put('E', "1110");
        binaryValue.put('F', "1111");
    }

    public Character getHexValue(String binary) {
        if (!hexValue.containsKey(binary)) throw new IllegalArgumentException("Invalid binary value");
        return hexValue.get(binary);
    }

    public String getBinaryValue(Character hex) {
        if (!binaryValue.containsKey(hex)) throw new IllegalArgumentException("Invalid hex value");
        return binaryValue.get(hex);
    }
}
