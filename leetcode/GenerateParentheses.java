// 22. Generate Parentheses
// by rich7420 myself
// use binary backtrack tree way 
class Solution {
    public List<String> generateParenthesis(int n) {
        // define our results
        List<String> results = new ArrayList<>();
        // use StringBuilder to solve extra String memory
        backtrackTreee(results, new StringBuilder(), 0, 0, n);
        return results;
    }

    private void backtrackTreee(List<String> results, StringBuilder current, int left, int right, int max) {
        // exit condition
        if (current.length() == max * 2) {
            results.add(current.toString());
            return;
        }


        // add left
        if (left < max) {
            // add (
            current.append("(");
            backtrackTreee(results, current, left + 1, right, max);
            // manually trace back , for other branches
            current.deleteCharAt(current.length() - 1);
        }

        // add right , left has been addded
        if (right < left) {
            // add )
            current.append(")");
            backtrackTreee(results, current, left, right + 1, max);
            // manually trace back
            current.deleteCharAt(current.length() - 1);
        }
    }
}
