package bigtech.dfs_bfs.question024;

import java.util.Scanner;

//====================== [정답] ======================
//문제024 신기한 소수 찾기
public class DfsBfsMain2_1 {
	// 자릿수
	static int figure = 0;
	// 둘째자리 부터 들어갈 숫자
	static int[] arr = {1, 3, 5, 7, 9};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		figure = sc.nextInt();
		
		// dfs(첫 째 짜리에 들어올 숫자, 한 자리 부터 시작)
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
	
	private static void dfs(int num, int start) {
		// System.out.println("num : " + num);
		// System.out.println("start : " + start);
		
		
		// 입력받은 자릿수 == 현재 소수 판별할 숫자의 자릿수
		if(figure == start) {
			if(prime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		// static int[] arr = {1, 3, 5, 7, 9};
		for(int i = 0; i < arr.length; i++) {
			int tmp = num * 10 + arr[i];
			
			if(prime(tmp)) {
				// start++, ++start 로 하면 망함
				dfs(tmp, start + 1);
			}
		}
		
	}
	
	private static boolean prime(int checkPNum) {
		double tmp = Math.sqrt(checkPNum);
		for(int i = 2; i <= tmp; i++) {
			if(checkPNum % i == 0) {
				return false; // 소수가 아니다.
			}
		}
		return true;
	}
}
/*
 * 입력값 = 2 일 때
 	23
	29
	31
	37
	53
	59
	71
	73
	79
 */
/*	(첫째자리) (둘째자리)
 * 0 X		 X
 * 1 X		 O	
 * 
 * 2 O		 X
 * 3 O		 O
 * 
 * 4 X		 X
 * 
 * 5 O		 O
 * 
 * 6 X		 X
 * 
 * 7 O		 O
 * 
 * 8 X		 X
 * 9 X		 O
 */
