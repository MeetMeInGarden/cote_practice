package bigtech.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 

// 문제012 오큰수 - Queue 이용해서 풀려고 했는데 도저히 안 됨
// 정확히 말해서 정답 자체는 나오는데 '시간초과'가 됨
public class StackQueueMain2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		// 첫째 줄
		int first = sc.nextInt(); sc.nextLine();
		// 둘째 줄
		String[] arr_str = sc.nextLine().split(" ");
		
		int[] arr = new int[arr_str.length];
		
		for(int i = 0; i < arr_str.length; i++) {
			int tmp = Integer.parseInt(arr_str[i]);
			arr[i] = tmp;
			queue.add(tmp);
		}
		
		// 출력
		StringBuffer br = new StringBuffer();
		
		for(int i = 1; i <= arr.length; i++) {
			// 오큰수 비교 기준 값
			int val = arr[i - 1];
			// Queue front에서 하나 삭제
			queue.poll();
			
			int lop = arr.length - i;
			int cnt = 0;
			
			if(lop == 0) {
				br.append("-1");
			} else {
				boolean flag = true;				
				while(cnt < lop) {
					int tmp = queue.poll();
					if(flag && (tmp > val)) {
						flag = false;
						br.append(tmp + " ");
					}
					cnt += 1;
					queue.add(tmp);
				}
				
				if(flag) {
					br.append("-1 ");
				}
			}
		}
		System.out.println(br.toString());
		sc.close();
	}
}