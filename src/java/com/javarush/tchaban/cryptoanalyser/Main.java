package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
                'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
                'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
                ':', '!', '?', ' ');
        String pathToFileForCrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\src\\forCrypt.txt";
        int key = 2;

       // Scanner scanner = new Scanner(System.in);
       // pathToFileForCrypt = scanner.nextLine();
       // key = scanner.nextInt();


        BufferedReader bufferCharFromFile = new BufferedReader(new FileReader(pathToFileForCrypt));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt"));
        while (bufferCharFromFile.ready()) {
            char oneChar = (char) bufferCharFromFile.read();
            if (ALPHABET.contains(oneChar)) {
                int position = ALPHABET.indexOf(oneChar);
                int positionAfterCrypt = position + key;
                if (positionAfterCrypt >= ALPHABET.size()) {
                    positionAfterCrypt = positionAfterCrypt % ALPHABET.size();
                }
                bufferedWriter.write(ALPHABET.get(positionAfterCrypt));
            } else {
                bufferedWriter.write(oneChar);
            }

        }
        bufferedWriter.close();
        bufferCharFromFile.close();

/////////////////////////

        BufferedReader bufferCrypt = new BufferedReader(new FileReader("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt"));
        BufferedWriter bufferDecrypt = new BufferedWriter(new FileWriter("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCrypt.txt"));
        while (bufferCrypt.ready()) {
            char oneChar = (char) bufferCrypt.read();
            if (ALPHABET.contains(oneChar)) {
                int position = ALPHABET.indexOf(oneChar);
                int positionAfterDeCrypt = position - key;
                if (positionAfterDeCrypt < 0) {
                    positionAfterDeCrypt = ALPHABET.size()  + positionAfterDeCrypt;
                }
                bufferDecrypt.write(ALPHABET.get(positionAfterDeCrypt));
            } else {
                bufferDecrypt.write(oneChar);
            }

        }
        bufferDecrypt.close();
        bufferCrypt.close();


    }
}
