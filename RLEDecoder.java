/*
RLE_Decoder.java

Violeta Solorio

The RLE Decoder decompresses a given string given a prefix(s)
*/
public class RLEDecoder {
public static String decode(String encoded) {
    var decoded = new StringBuilder();
    for (int i = 0; i < encoded.length(); i++) {
        char c = encoded.charAt(i);
         //Checks if the first char is a digit
         if(Character.isDigit(c)){
         //Check if the following char is a digit
             if(Character.isDigit(encoded.charAt(i+1))){
             //Checks if the second following char is a digit
                 if(Character.isDigit(encoded.charAt(i+2))){
                     var letter = Character.toString(encoded.charAt(i + 3));
                    
                    int firstDigit = Character.getNumericValue(c);
                    int secondDigit =
                    Character.getNumericValue(encoded.charAt(i+1));
                    
                    int thirdDigit =
                    Character.getNumericValue(encoded.charAt(i+2));
                    
                    
                    String allDigits = ""+ firstDigit + secondDigit + thirdDigit;
                    int intDigits = Integer.parseInt(allDigits);
                    decoded.append(letter.repeat(intDigits));
                    //The for loop skips the third digit of the string
                    i+=2;
                }else{
                    var letter = Character.toString(encoded.charAt(i + 2));
                    int firstDigit = Character.getNumericValue(c);
                    int secondDigit =
                    Character.getNumericValue(encoded.charAt(i+1));
                    String allDigits = ""+ firstDigit + secondDigit;
                    int intDigits = Integer.parseInt(allDigits);
                    decoded.append(letter.repeat(intDigits));
                    //The for loop skips the second digit of the string
                    i++;
                }
            }else{
                 var letter = Character.toString(encoded.charAt(i + 1));
                 decoded.append(letter.repeat(Character.getNumericValue(c)));
                }
            }
        }
        return decoded.toString();
    }
    
 }


