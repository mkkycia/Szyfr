import szyfry.Cezar;

public class TestCezar {
    static void test(String name, String input, int shift, String expected) {
        String out = Cezar.encrypt(input, shift);
        if (out.equals(expected)) {
            System.out.println(name + " – OK");
        } else {
            System.out.println(name + " – FAILED: got \"" + out + "\"");
        }
    }
    public static void main(String[] args) {
        test("Shift 0", "Abc XYZ!", 0, "Abc XYZ!");
        test("Inverse", "Hello, World!", 0,
             Cezar.decrypt(Cezar.encrypt("Hello, World!", 5), 5));
        test("Wrap Z->A", "Z", 1, "A");
        test("Non‑letters", "123!?", 13, "123!?");
    }
}
