package bigtech.dfs_bfs.question024;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// 문제024 신기한 소수 찾기
public class Main2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 짝수는 볼 것도 없이 pass
		 * 2. 각 자릿수 별 소수여부를 따지기전에 전체 숫자가 소수인지 파악하는게 먼저 ==> 전체 숫자가 소수가 아니라면 각 자릿수별 소수를 따져볼 필요도 없다.
		 * 3. 전체 자릿수가 소수인 경우 그때부터 각 자릿수별 소수 따지기 시작
		 * 4. N자리 --> N-1 자리 --> N-2 자리 --> N-3 자리.. 순으로 소수 여부를 판단해야 할 듯
		 * ==> 자릿수가 크면 클 수록 약수가 있을 확률이 높으니까
		 * ==> 계산하는 경우의 수를 최대한 줄이기
		 * 
		 * 5. N자리 숫자 중 단 하나라도 짝수가 있으면 완벽한 소수가 아니다.
		 * 
		 * 8자리
		 * 10,000,000 ~ 99,999,999 => 5,000,000 ~ 49,999,999.5
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		// N자리
		int figure = sc.nextInt();
		
		// 시작 숫자
		int startNum = 1;
		for(int i = 1; i < figure; i++) {
			startNum *= 10;
		}
		// 종료 숫자
		int finalNum = startNum * 10 - 1;
		startNum *= 2; // 맨 앞자리가 1 이면 어차피 소수가 아니다.
		
		// 나눌 숫자
		int dividNum = startNum / 2;
		
		// System.out.println("startNum : " + startNum);
		// System.out.println("finalNum : " + finalNum);
		// System.out.println("dividNum : " + dividNum);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = startNum; i <= finalNum; i++) {
			double sqrtNum = Math.sqrt(i);
			double divdNum = Math.floor(i / dividNum);
			if((i > 2 && i % 2 == 0) || sqrtNum == Math.floor(sqrtNum)) {
				// 불필요한 계산을 최대한 줄이기 위해 해당 조건문 추가
				// 짝수 or 제곱근이 정수인 숫자는 어차피 소수가 아님
				continue;
			} else if((i > 2 && divdNum > 2.0  && divdNum % Math.sqrt(divdNum) == 0) || (i > 2 && divdNum % 2 == 0 && divdNum > 2.0)) {
				// System.out.println("test : " + divdNum);
				continue;
			} else {
				int result = prime(i);
				if(result > 0) {
					list.add(i);
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int num : list) {
			System.out.println(num);
		}

		bw.flush();
		sc.close();
	}
	
	static int prime(int num) {
		System.out.println("numnum : " + num);
		// 완벽한 소수 O : return 해당 숫자
		// 완벽한 소수 X : return 0
		
		// 일의 자리 부터 검사, 일의 자리가 꽝이면 굳이 재귀함수 자체를 시작할 필요가 없다.
		
		
		if(num <= 1) {
			return 0;
		} else if(num > 2 && num % 2 == 0) {
			return 0;
		} else {
			// (1과 자기 자신)을 제외한 약수가 있는 경우 완벽한 소수가 아니다.
			double tmp = Math.sqrt(num);
			for(int i = 2; i <= tmp; i++) {
				if(num % i == 0) {
					return 0; // 완벽한 소수가 아니다.
				}
			}
		}
		
		// 마지막 남은 1자리수 숫자가 모든 소수판별 검사를 통과하고 이 자리까지 온 거면 그 놈은 완전한 소수이다.
		if(num < 10) {
			return num;
		}
		return prime((int) Math.floor(num / 10));
		
		
	}
}
// 23, 29, 31, 37, 53, 59, 71, 73, 79
// 
/*
 * 1 ==> 1
 * 
 * 2 ==> 1.xxxx
 * 3 ==> 1.xxxx
 * 
 * 4 ==> 2
 * 
 * 5 ==> 2.xxxx
 * 6 ==> 2.xxxx
 * 7 ==> 2.xxxx
 * 8 ==> 2.xxxx
 * 
 * 9 ==> 3
 * 
 * 10 ==> 3.xxxx
 * 11 ==> 3.xxxx
 * 12 ==> 3.xxxx
 * 13 ==> 3.xxxx
 * 14 ==> 3.xxxx
 * 15 ==> 3.xxxx
 * 
 * 16 ==> 4
 * 
 * 15 ==> 4.xxxx
 * 17 ==> 4.xxxx
 * 18 ==> 4.xxxx
 * 19 ==> 4.xxxx
 * 20 ==> 4.xxxx
 * 21 ==> 4.xxxx
 * 22 ==> 4.xxxx
 * 23 ==> 4.xxxx
 * 24 ==> 4.xxxx
 * 
 * 
 * 25 ==> 5
 * 
 * 
 * 
 * */
