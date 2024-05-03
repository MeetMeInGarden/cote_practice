package bigtech.dfs_bfs.question024;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main2_2 {
	// 입력받은 자릿수
	static int figure = 0;
	static int startNum = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		figure = sc.nextInt();
		
		// 시작 숫자
		// int startNum = 1;
		for(int i = 1; i < figure; i++) {
			startNum *= 10;
		}
		
		int[] arr = {startNum * 2 + 1, startNum * 3 + 1, startNum * 5 + 1, startNum * 7 + 1};
		
		for(int i = 0; i < arr.length; i++) {
			dfs(arr[i], figure);
		}
		
		sc.close();
	}
	
	private static void dfs(int start, int figure) {
		
		if(figure == 0) {
			System.out.println(start);
			return;
		}
		
		if(start > 2 && start % 2 == 0) {
			return;
		}
		
		for(int i = start; i <= (start + startNum - 1); i++) {
			if(start > 2 && start % 2 != 0 && prime(i)) {
				dfs(i / 10, (figure - 1));
			}
		}
	}
	
	private static boolean prime(int num) {
		double sqrtNum = Math.sqrt(num);
		for(int i = 2; i <= sqrtNum; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

/**
 * 첫 째 자리 숫자가 (1, 4, 6, 8 ,9) 면 신기한 소수가 어차피 X
 * 두 자리 숫자 이상부터 끝자리가 (0, 2, 4 ,6 , 8) 이면 신기한 소수가 어차피 X 
 */

/**			(첫째자리)(신기한 소수 어차피 X)
 * 1~~~		X
 * 2~~~
 * 3~~~
 * 4~~~		X
 * 5~~~
 * 6~~~		X
 * 7~~~
 * 8~~~		X
 * 9~~~		X
 */













