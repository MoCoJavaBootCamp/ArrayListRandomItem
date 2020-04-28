/*How would you return a random item from an ArrayList?
        Create 3 array list: subject, verb, and object.
        Ask a user to populate each array list with 3 to 10 words.
        As an example, ask a user to enter 4 subject word, 5 verb words, and
        9 object words. Ask a user if they want to generate a sentence.
        If user says "yes" then create a sentence by randomly selecting one word from subject,
        verb and object array list. Finally, print out the content of your array lists.
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class ArrayListRandomItem {
    public static void main(String[] args) {
        // declare 3 array lists
        ArrayList<String> subject = new ArrayList<String>();
        ArrayList<String> verb = new ArrayList<String>();
        ArrayList<String> object = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String randomSentence = "";
        String response = "";

        // Ask a user to populate each array list with 3 to 10 words.
        addToList(subject, "Subject List");
        addToList(verb, "Verb List");
        addToList(object, "Object List");

        // Ask a user if they want to generate a sentence.
            // yes: create random sentence
        do {
            System.out.println("Would you like to generate a random sentence? (y/n)");
            response = input.nextLine();
            System.out.printf("%s %s %s.\n", getRandomWord(subject), getRandomWord(verb), getRandomWord(object));
        } while (!response.equals("n"));

        // convert list to array, convert array to string
        System.out.println("Subject List: " + Arrays.toString(subject.toArray()));
        System.out.println("Verb List: " + Arrays.toString(verb.toArray()));
        System.out.println("Object List: " + Arrays.toString(object.toArray()));
    }

    public static void addToList(ArrayList<String> sentenceList, String listName) {
        Scanner input = new Scanner(System.in);
        int slSize = sentenceList.size();
        // while size is between 3-10 and user does not quit
        while (slSize < 3) {
            System.out.printf("Enter a word to add to %s (%d/10)\n", listName, slSize + 1);
            String word = input.nextLine();
            sentenceList.add(word);
            slSize = sentenceList.size();
        }

        while (slSize < 11) {
            System.out.printf("Enter a word to add to %s (%d/10) or 'q' to quit\n", listName, slSize + 1);
            String word = input.nextLine();
            if (word.equals("q")) {
                break;
            }
            sentenceList.add(word);
            slSize = sentenceList.size();
        }
    }

    public static String getRandomWord(ArrayList<String> sentenceList) {
        Random random = new Random();
        int listSize = sentenceList.size();
        int randomIdx = random.nextInt(listSize);
        return sentenceList.get(randomIdx);
    }
}
