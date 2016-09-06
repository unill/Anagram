
package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Anil
 */
public class Anagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
      
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of words :");
        
         int noOfWords = 0;
         try{
         noOfWords = scan.nextInt();
         }
         catch(java.util.InputMismatchException e){
             System.out.println("Please enter a valid number");
         }
         Scanner y = new Scanner(System.in);
           String[] array = new String[noOfWords];
          
           for(int i =0; i < array.length; i++){
               System.out.println("Enter your word no: " +(i+1));
               array[i] = y.nextLine();
               wordList.add(array[i]);
                
           }

        
System.out.println("Input array -->" + wordList);
            
Map<String, List<String>> result = getAnagramsInGroup(wordList);
for(Map.Entry<String, List<String>> entry : result.entrySet()) {
List<String> data = entry.getValue();
int outputArray = data.toArray().length;
Collections.sort(data, new Comparator<String>() {
    @Override
    public int compare(String t, String t1) {
        return t1.length() - t.length();
    }
});



System.out.println("OUTPUT -->" +outputArray  + Arrays.toString(data.toArray())+ " ");
        
    }
    }
private static Map<String, List<String>> getAnagramsInGroup(ArrayList<String> wordList) {
Map<String, List<String>> result = new HashMap<>();
String key;
List<String> data = null;
for(String strWord : wordList) {
//count str


long count = 0L;
for(int i = 0; i < strWord.length(); i++) {
count += strWord.charAt(i);

}

key =String.valueOf(count);
if(result.containsKey(key)) {
data = result.get(key);
data.add(strWord);

result.put(key, data);
} else {
data = new ArrayList<String>();
strWord.trim();
data.add(strWord);


result.put(key, data);


}
}

return result;
}

    }

    


    
       
    



