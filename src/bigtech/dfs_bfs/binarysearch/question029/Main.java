package bigtech.dfs_bfs.binarysearch.question029;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Run 			ctrl + f11
// Run Debug 	f11
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ==================== N ====================
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N];
		// N 개의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) nArr[i] =  Integer.parseInt(st.nextToken());
		Arrays.sort(nArr);
		// ==================== M ====================
		int M = Integer.parseInt(br.readLine());
		int[] mArr = new int[M];
		// M 개의 수
		st = new StringTokenizer(br.readLine());
		// 이렇게하면 틀림(N 이 아니라 M 을 입력해야함)
		// for(int i = 0 ; i < N; i++) mArr[i] =  Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M; i++) mArr[i] =  Integer.parseInt(st.nextToken());

		// ===============================================
		for(int i = 0 ; i < mArr.length; i++) {
			int end 		= nArr.length - 1;	// 이진탐색 포인트 끝
			int start 		= 0;				// 이진탐색 포인트 시작
			int target 		= mArr[i]; 			// 이 숫자가 존재하는 숫자니
			Boolean flag 	= false;			// 존재하는지 여부 최종

			while(start <= end) {
				int midIdx = (start + end) / 2;	// 중앙값 인덱스
				int midval = nArr[midIdx];		// 중앙값
				if(target == midval) {
					flag = true; break;
				} else if(target > midval) {
					// 찾으려는값 > 중앙값
					start = midIdx + 1;
				} else {
					// 찾으려는값 < 중앙값
					end = midIdx - 1;
				}
			}

			if(flag) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}