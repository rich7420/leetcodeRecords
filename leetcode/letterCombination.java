// 17. Letter Combinations of a Phone Number
// by rich7420 myself
// for unique letters 
import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        // new List<String>
        List<String> result = new ArrayList<>();

        // if we don't get anything from digits return ""
        if(digits.length()==0) return result; 
        
        // define telephone Map
        Map<String,String[]> digitToLetter = new HashMap<>();
        digitToLetter.put("2",new String[]{"a","b","c"});
        digitToLetter.put("3",new String[]{"d","e","f"});
        digitToLetter.put("4",new String[]{"g","h","i"});
        digitToLetter.put("5",new String[]{"j","k","l"});
        digitToLetter.put("6",new String[]{"m","n","o"});
        digitToLetter.put("7",new String[]{"p","q","r","s"});
        digitToLetter.put("8",new String[]{"t","u","v"});
        digitToLetter.put("9",new String[]{"w","x","y","z"});

        // conbine and convert to List<String> and get result
        conbineLetter(digits,digitToLetter, 0, "", result);

        // output all results
        return result;
    }
    static public void conbineLetter(String digits, Map<String, String[]> map, int index, String currentString, List<String> result){
        if (index == digits.length()) {
            result.add(currentString);
            return;
        }

        char digit = digits.charAt(index);
        for (String letter : map.get(String.valueOf(digit))) {
            conbineLetter(digits, map, index + 1, currentString + letter, result);
        }
    }
}

