package bigtech.array_list;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

// 문제001 숫자의 합 구하기
public class ArrayListMain {
	public static void main(String[] args) {
		System.out.println("===== [시작] =====");
		
		// ============ 내 풀이 ============
//		Scanner scanner = new Scanner(System.in);
//		// 첫째 줄
//		int first = scanner.nextInt();
//		// 둘째 줄
//		String number_str = scanner.next();
//		
//		long result = 0;
//		String[] str_arr = number_str.split("");
//		for(int i = 0; i < str_arr.length; i++) {
//			result += Long.parseLong(str_arr[i]);
//		}
//		
//		System.out.println("result : " + result);
//		scanner.close();
		
		// ============ 책 보고 난 후 정리 ============
		Scanner scanner = new Scanner(System.in);
		// 첫째 줄
		int first = scanner.nextInt();
		// 둘째 줄
		String two = scanner.next();
		// from String to char[]
		char[] char_arr = two.toCharArray();
		
		long result = 0;
		for (int i = 0; i < char_arr.length; i++) {
			result += char_arr[i] - '0'; // 아스키코드 값 활용
		}
		System.out.println(result);
		scanner.close();
		System.out.println("===== [끝] =====");
	}
}