import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cesar {
    String message;

    // Constructor that takes the message
    public Cesar(String message) {
        this.message = message;
    }

    public HashMap<Character, Integer> CalculateOccurences(String message) {
        char[] splitedMessage = message.toCharArray();
        // create a hash map <Char as a key , counter of the number (Integer)>
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (char currenChar : splitedMessage) {
            hashMap.put(currenChar, hashMap.getOrDefault(currenChar, 0) + 1);
        }
        return hashMap;
    }

    public Character maxCharacter(String message, char[] Alphabet, HashMap<Character, Integer> hashMap) {
        // get the max
        ArrayList<Integer> ArrayList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            ArrayList.add(value);
        }

        Collections.sort(ArrayList);
        Integer MaxOccurence = ArrayList.get(ArrayList.size() - 1);
        Character maxCharacter = null;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == MaxOccurence) {
                maxCharacter = entry.getKey();
                break;
            }
        }
        return maxCharacter;
    }

    public void Decrypt(String message, Character maxCharacter, char[] Alphabet) {
        int indexMaxCharacter = 0;
        int indexMaxEng = 0;

        for (int i = 0; i < Alphabet.length; i++) {
            if (Alphabet[i] == maxCharacter) {
                indexMaxCharacter = i;
            }
            if (Alphabet[i] == 'e') {
                indexMaxEng = i;
            }
        }

        StringBuilder decryptedMessage = new StringBuilder();

        int shift = indexMaxCharacter - indexMaxEng;

        for (char currentChar : message.toCharArray()) {
            if (Character.isLetter(currentChar) || currentChar == '.' || currentChar == ' ') {
                int currentIndex = -1;

                for (int i = 0; i < Alphabet.length; i++) {
                    if (Alphabet[i] == currentChar) {
                        currentIndex = i;
                        break;
                    }
                }

                int newIndex = (currentIndex - shift) % Alphabet.length;

                if (newIndex < 0) {
                    newIndex += Alphabet.length;
                }

                decryptedMessage.append(Alphabet[newIndex]);
            } else {
                decryptedMessage.append(currentChar);
            }
        }

        System.out.println("Decrypted Message: " + decryptedMessage.toString());
    }

}