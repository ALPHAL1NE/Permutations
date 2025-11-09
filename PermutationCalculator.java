import java.util.ArrayList;
import java.util.List;

public class PermutationCalculator {

    // Method to calculate factorial
    public long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    // Swap helper method (used in permutation generation)
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // Recursive method to generate linear permutations
    private void generatePermutations(char[] arr, int start, int end, List<String> results) {
        if (start == end) {
            results.add(String.valueOf(arr));
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                generatePermutations(arr, start + 1, end, results);
                swap(arr, start, i); // backtrack
            }
        }
    }


    // Public method to return list of all linear permutations
    public List<String> getLinearPermutations(String input) {
        char[] elements = input.toCharArray();
        List<String> results = new ArrayList<>();
        generatePermutations(elements, 0, elements.length - 1, results);
        return results;
    }


    // Returns total number of linear permutations
    public long getLinearPermutationCount(int n) {
        return factorial(n);
    }


    // Returns total number of circular permutations
    public long getCircularPermutationCount(int n) {
        if (n <= 1) return 1;
        return factorial(n - 1);
    }
}