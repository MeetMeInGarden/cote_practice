package programmers.sort.two;

import java.util.Arrays;
import java.util.Comparator;

// 정렬 - 가장 큰 수
class 가장큰수 {
	public String solution(int[] numbers) {
        // Convert the numbers array to a String array
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // Sort the String array using a custom comparator
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare combined strings in reverse order
                System.out.printf("a : %s, b : %s \n", a, b);
                System.out.printf("b + a : %s  /  a + b : %s \n", (b + a), (a + b));
                return (b + a).compareTo(a + b);
            }
        });

        // If the highest number is 0, the entire number is 0
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // Combine sorted strings into a single string
        StringBuilder result = new StringBuilder();
        for (String str : strNumbers) {
            result.append(str);
        }

        return result.toString();
    }
}