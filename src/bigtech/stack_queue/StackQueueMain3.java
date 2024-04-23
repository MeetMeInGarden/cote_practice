package bigtech.stack_queue;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

// 문제013 카드 게임
public class StackQueueMain3 {
	public static void main(String[] args) {
		/*
		 * 1(가장 위) ~ N(가장 아래) 까지의 카드
		 * 
		 * 가장 위 카드 버린다. ==> poll
		 * 그 다음 카드는 맨 뒤로 ==> poll, add
		 * size()는 계속 체크
		 * 
		 * 1장 남을때까지 반복 후 출력 ==> size(), peek() 이용하면 될 듯
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= cnt; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {			// Queue에 데이터 1개 남을 때까지
			queue.poll();					// 가장 위 카드는 버린다.
			queue.add(queue.poll());		// 그 다음 위 카드는 맨 뒤로 옮긴다.
		}
		
		sc.close();
		System.out.println(queue.peek()); 	// 출력
	}
}