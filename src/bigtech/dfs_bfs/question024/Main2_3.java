package bigtech.dfs_bfs.question024;

import java.util.Scanner;

//====================== [정답] ======================
// 문제024 신기한 소수 찾기
// 해답 따라 치기
public class Main2_3 {
	static int figure = 1;
	static int[] arr = {1, 3, 5, 7, 9};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		figure = sc.nextInt();
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		sc.close();
	}
	
	static void dfs(int num, int fNum) {
		if(figure == fNum) {
			if(prime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			int tmp = num * 10 + arr[i];
			if(prime(tmp)) {
				dfs(tmp, fNum + 1);
			}
		}
	}
	
	static boolean prime(int test) {
		double sqr = Math.sqrt(test);
		for(int i = 2; i <= sqr; i++) {
			if(test % i == 0) {
				return false; // 소수 아님
			}
		}
		return true; // 소수 맞음
	}
}
