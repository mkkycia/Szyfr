package szyfry;

public class Morse {
    public static String decrypt(String text){

        return text;
    }
    public static  String encrypt(String text){
        String[] letters = new String[]{"·−", "−···", "−·−·", "−··", "·", "··−·", "−−·", "····", "··", "·−−−", "−·−", "·−··", "−−", "−·", "−−−", "·−−·", "−−·−", "·−·", "···", "−", "··−", "···−", "·−−", "−··−", "−·−−", "−−··"};
        StringBuilder result = new StringBuilder();
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == ' ' || text.charAt(i) == '\n')
                result.append(text.charAt(i));
            else if('a' <= text.charAt(i) && text.charAt(i) <= 'z'){
                result.append(letters[text.charAt(i)-'a']);
            }
            //Other characters are ignored.
        }
        return result.toString();
    }
}
