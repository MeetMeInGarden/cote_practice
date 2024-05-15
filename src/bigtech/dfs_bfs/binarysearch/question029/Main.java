package bigtech.dfs_bfs.binarysearch.question029;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

// 문제 029. 수 찾기(1920)
public class Main {
	// 자료를 정렬할 리스트
	static ArrayList<Integer> list = new ArrayList<>();
	// 자료를 정렬할 리스트의 사이즈(-1 해야 함)
	static int sizeMinusOne = 0;
	// 결과값을 저장할 배열
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫째 줄 자연수
		int N = Integer.parseInt(br.readLine());
		// N개의 정수 A[1], A[2], …, A[N] 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 리스트에 값 넣기
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		// 리스트 정렬
		Collections.sort(list);
		sizeMinusOne = list.size() - 1;
		// =========================================================
		// 다음 줄 M
		int M = Integer.parseInt(br.readLine());
		// 결과값을 저장할 배열 길이 설정
		result = new int[M];
		// M개의 수들 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			binarySearch(i, Integer.parseInt(st.nextToken()), sizeMinusOne / 2);
		}
		
		for(int tmp : result) {
			System.out.println(tmp);
		}
		br.close();
	}
	
	/**
	 * @param index 	result 배열에 값을 넣을 때 사용
	 * @param num		존재 여부를 체크할 값
	 * @param centerIdx	중앙 값을 뽑기 위한 인덱스
	 */
	// binary search method
	public static void binarySearch(int index, int num, int centerIdx) {
		boolean flag = false;
		while(centerIdx <= sizeMinusOne) {
			int val = list.get(centerIdx);
			if(num == val) {
				result[index] = 1;
				flag = true;
				return;
			} else if(num > val) {
				centerIdx = (int) Math.ceil(((centerIdx + sizeMinusOne) / 2)) + (((centerIdx + sizeMinusOne) % 2));
			} else {
				if(centerIdx == 0) {
					break;
				}
				centerIdx = (centerIdx + 0) / 2;
			}
		}
		
		if(!flag) {
			result[index] = 0;
		}
	}
	
//	public static void binarySearch(int index, int num, int centerIdx) {
//		int val = list.get(centerIdx);
//		if(num == val) {
//			result[index] = 1;
//			return;
//		} else if(num > val) {
//			// 존재여부체크값 > 중앙값 => 오른쪽 탐색
//			if(centerIdx == sizeMinusOne) {
//				result[index] = 0;
//				return;
//			} else {
//				binarySearch(index, num, (int) Math.ceil(((centerIdx + sizeMinusOne) / 2)) + (((centerIdx + sizeMinusOne) % 2)));
//			}
//		} else {
//			// 존재여부체크값 < 중앙값 => 왼쪽 탐색
//			if(centerIdx == 0) {
//				result[index] = 0;
//				return;				
//			} else {
//				binarySearch(index, num, (centerIdx + 0) / 2);
//			}
//		}
//		
//	}
}






















