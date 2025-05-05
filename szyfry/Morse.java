package szyfry;

public class Morse {

    private static final String[] LETTERS = new String[]{"·−", "−···", "−·−·", "−··", "·", "··−·", "−−·", "····", "··", "·−−−", "−·−", "·−··", "−−", "−·", "−−−", "·−−·", "−−·−", "·−·", "···", "−", "··−", "···−", "·−−", "−··−", "−·−−", "−−··"};

    public static String decrypt(String text){
        text = text.trim(); //trailing newlines are incompatible with the Morse code convention.
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < text.length(); ){
            if(text.charAt(i) == ' '){
                int count = 1;
                for(i++; i<text.length(); i++){
                    if(text.charAt(i) != ' ')
                        break;
                    count++;
                }

                if(count == 3) {
                    result.append(' ');
                }
                else if(count == 7) {
                    result.append('\n');
                }
                else {
                    System.err.println("Warning: Unexpected spacing of " + count + " spaces.");
                    result.append(' ');//for legibility, even if input is incorrect
                }
            }

            else{
                StringBuilder characterBuilder = new StringBuilder();
                do{
                    characterBuilder.append(text.charAt(i));
                    i++;
                }
                while(i < text.length() && text.charAt(i) != ' ' && text.charAt(i) != '/');

                if(i < text.length() && text.charAt(i) == '/')
                    i++;

                String characterCode = characterBuilder.toString();
                boolean match = false;
                for(int j = 0; j<26; j++){
                    if(LETTERS[j].equals(characterCode)){
                        result.append((char)('a' + j));
                        match = true;
                        break;
                    }
                }
                if(!match){
                    result.append('?');//for legibility, even if input is incorrect
                    System.err.println("Warning: Unknown Morse character code: '" + characterCode + "'");
                }
            }
        }

        return result.toString();
    }
    public static  String encrypt(String text){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '\n')
                result.append("       "); //7 spaces
            if(text.charAt(i) == ' ')
                result.append("   ");//3 spaces

            else if('a' <= text.charAt(i) && text.charAt(i) <= 'z'){
                result.append(LETTERS[text.charAt(i)-'a']);
                if(i != text.length() - 1){
                    if(text.charAt(i+1) != ' ' && text.charAt(i+1) != '\n'){
                        result.append('/');
                    }
                }
            }

            //Other characters are ignored.
        }
        return result.toString();
    }
}
