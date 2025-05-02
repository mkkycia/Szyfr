package szyfry;

public class Cezar {
    // zamienia litery na większe o shift
    public static String encrypt(String text, int shift){
        shift %= 26;
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z'){
                encrypted.append((char)((text.charAt(i) - 'A' + shift) % 26 + 'A'));
            }
            else if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z'){
                encrypted.append((char)((text.charAt(i) - 'a' + shift) % 26 + 'a'));
            }
            else{
                encrypted.append(text.charAt(i));
            }
        }
        return encrypted.toString();
    }
    public static String decrypt(String text, int shift){
        shift %= 26;
        return encrypt(text, 26-shift);
    }
}
