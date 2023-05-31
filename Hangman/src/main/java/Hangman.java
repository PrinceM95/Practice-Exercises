import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {





        Scanner scanner = new Scanner(new File("C:\\Users\\mouti\\Downloads\\words_alpha.txt"));
        Scanner keyboard = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        //checks for words from scanner object and adds words until no more left to add
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        //an object designed to retrieve words in a randomized fashion
        Random rand = new Random();

        //these two lines are designed to select a random word from 'words' list and then print out to console
        String word = words.get(rand.nextInt(words.size()));
        System.out.println(word);

        //An array list object designed to keep track of the letters player guesses
        List<Character> playerGuesses = new ArrayList<>();


        while(true) {
            printWordState(word, playerGuesses);
            getPlayerGuess(keyboard, word, playerGuesses);

            if(printWordState(word,playerGuesses)) {
                System.out.println("You win!");
                break;
            }

            System.out.println("Please enter your guess for the word:");
            if(keyboard.nextLine().equals(word)) {
                System.out.println("You win!");
                break;
            }
            else {
                System.out.println("Nope! Try again");
            }
        }
    }

    //stored method designed to continuously ask user to guess a letter. we make sure it takes the first character
    // they type as opposed to multiple characters.
    private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter:");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
    }


    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}
