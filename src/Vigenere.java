

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Vigenere {
    public static void main(String[] args) {
        try {
            VigenereCipher();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //the allowed characters in the cipher
    public static ArrayList<Character> allowedChar = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '.', '?', '!', ' '));

    public static void VigenereCipher() throws IOException {


        String key = "";

        String text = "";
        try {
            File file = new File("text.txt");
            Scanner readFile = new Scanner(file);
            key = readFile.nextLine();

            while (readFile.hasNextLine()) {
                text += readFile.nextLine() + '\n';
            }
            readFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String tempKey = key;
        key = generateKey(key, text);


        String encryptedText = encryption(key, text);
        FileOutputStream encryptWriter = new FileOutputStream("encrypted.dec");
        byte[] encryptedData = encryptedText.getBytes();
        encryptWriter.write(encryptedData);
        encryptWriter.close();

        //change values here if you want to decrypt a specific file with a specific key
        //you can use the absolute path for the file you want to decrypt
        File enc = new File("encrypted.dec");
        decryption(enc, tempKey);


    }

    public static String encryption(String key, String text) throws IOException {
        String result = "";
        int j = 0;
        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '\n') {
                result += (char) ('\n');
                j = j - 1;
            } else {

                int x = (allowedChar.indexOf(text.charAt(i)) + allowedChar.indexOf(key.charAt(i + j))) % allowedChar.size();
                result += allowedChar.get(x);
            }
        }


        return result;

    }

    //method to generate key that match the plain text length in a circular manner
    public static String generateKey(String key, String text) {

        for (int i = 0; ; i++) {

            if (i == text.length()) i = 0;

            if (key.length() == text.length()) break;

            key += key.charAt(i);
        }
        return key;
    }

    public static void decryption(File file, String key) throws IOException {
        String encryptedText = "";
        String result = "";
        String newKey = "";
        String temp = "";
        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNextLine()) {
            encryptedText += fileReader.nextLine() + '\n';
        }

        for (int i = 0; i < key.length(); i++) {
            int x = (allowedChar.size() - allowedChar.indexOf(key.charAt(i))) % allowedChar.size();

            newKey += allowedChar.get(x);
        }
        temp = newKey;
        newKey = generateKey(newKey, encryptedText);
        result = encryption(newKey, encryptedText);

        FileOutputStream decryptWriter = new FileOutputStream("decrypted.txt");
        byte[] decryptedData = result.getBytes();
        decryptWriter.write(temp.getBytes());
        decryptWriter.write('\n');
        decryptWriter.write(decryptedData);
        decryptWriter.close();


    }

}