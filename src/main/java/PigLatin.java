import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }

    public int findFirstVowel(String sWord) {
        for (int i = 0; i < sWord.length(); i++) {
            char c = sWord.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return i;
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        int vowelAt = findFirstVowel(sWord);
        if(vowelAt == -1) return sWord + "ay";
        else if (vowelAt == 0) return sWord + "way";
        else if (sWord.substring(0,2).equals("qu")) return sWord.substring(2) + "quay";
        else return sWord.substring(vowelAt) + sWord.substring(0, vowelAt) + "ay";
    }
}// end PigLatin class
