package bigtech.stack_queue;

import java.util.Scanner;
import java.util.Stack;

// 문제011 스택으로 오름차순 수열 만들기
public class StackQueueMain {
	// ================================================================
	// ============================ [방법 1] ===========================
	// ================================================================
//	public static void main(String[] args) {
//		// 첫 째줄 입력
//		// 둘 째줄 입력 --> var arr = 배열[첫 째줄 입력 값]
//		// Stack 선언
//		// Stack +1 씩 push
//		// push 하면서 arr 값과 비교
//		
//		/*
//		 * 경우의 수
//		 * 증가하는 자연수 = arr 원소 값 -> pop
//		 * 증가하는 자연수 > arr 원소 값 -> No
//		 * 증가하는 자연수 < arr 원소 값 -> push
//		 * 
//		 * 4 3 6 8 7 5 2 1
//		 * 1 2 5 3 4
//		 * */
//		Scanner scanner = new Scanner(System.in);
//		int count = scanner.nextInt();
//		int[] arr = new int[count];
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = scanner.nextInt();
//		}
//		StringBuffer bf = new StringBuffer();
//		Stack<Integer> stack = new Stack<>();
//		int val = 0;
//		stack.push(val); // EmptyStackException 방지, 문제에서 (1이상 n이하의 정수)가 주어진다고 했으므로 이와 무관한 '0'을 넣었다.
//		int idx = 0;
//		boolean flag = true;
//		while(flag) {
//			int pekNum = stack.peek();
//			int arrNum = arr[idx];
//			
//			if(pekNum == arrNum) {
//				stack.pop();
//				bf.append("-\n");
//				idx++;
//			} else if(pekNum < arrNum) {
//				stack.push(++val); // 전위연산자(++val), 후위연산자(val++)에 따라 결과 다르니 주의
//				bf.append("+\n");
//			} else if(pekNum > arrNum) {
//				System.out.println("NO");
//				return;		
//			}
//			
//			if(idx == arr.length) {
//				flag = false;
//			}
//		}
//		scanner.close();
//		System.out.println(bf.toString());
//	}
	
	// =================================================================
	// ============================ [방법 2] ============================
	// =================================================================
//	public static void main(String[] args) {
//		// 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
//		// 스택에 push하는 순서는 반드시 '오름차순'을 지키도록 한다고 하자.
//		// 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지
//		// 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
//		// 이를 계산하는 프로그램을 작성
//		// push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
//		
//		// 첫 줄에 n (1 ≤ n ≤ 100,000)
//		// 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.
//		// push 연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력
//		
//		/*
//		 * Stack에 자연수룰 계속 넣는다.(1부터~) => push, +
//		 * Stack에 숫자가 들어가는 순간부터 주어진 수열의 값과 일치하는지 비교한다.
//		 * ==> 값 꺼낼 때 Exception 주의
//		 * ==> 일치 = pop, -
//		 * ==> 불일치
//		 * 			==> 현재 스택에 들어있는 값 > 수열에서 비교하려는 값 ===> No, 계속 오름차순으로 Stack에 값이 쌓이기 때문에 불가능
//		 * 			==> 현재 스택에 들어있는 값 < 수열에서 비교하려는 값 ===> 계속 push, + 하면서 값을 비교한다.
//		 * */
//		
//		// ================================================================================================
//		Scanner sc = new Scanner(System.in);
//		
//		// 첫 줄
//		int cnt = sc.nextInt();
//		
//		// 둘째 줄
//		int[] seq = new int[cnt];
//		
//		for(int i = 0; i < seq.length; i++) {
//			seq[i] = sc.nextInt();
//		}
//		
//		// 반복문 계속 돌겨 말겨
//		boolean flag = true;
//		
//		// seq 배열 인덱스
//		int idx = 0;
//		
//		// Stack에 넣을 값
//		int val = 1;
//		
//		// 정답 출력
//		StringBuffer buffer = new StringBuffer();
//		
//		Stack<Integer> stack = new Stack<>();
//		stack.push(0); // Exception 방지용
//		
//		while(flag) {
//			int stk_tmp = stack.peek();
//			int seq_tmp = seq[idx];
//			
//			if(stk_tmp == seq_tmp) {
//				stack.pop(); buffer.append("-\n");
//				++idx;
//			} else if(stk_tmp > seq_tmp) {
//				System.out.println("NO");
//				return;
//			} else if(stk_tmp < seq_tmp) {
//				stack.push(val);
//				buffer.append("+\n");
//				++val;				
//			}
//			
//			if(idx == seq.length) {
//				flag = false;
//			}
//		}
//		
//		System.out.println(buffer.toString());
//		sc.close();
//	}
	
	// ========================================================================
	// ============================ [방법 3 - 책 해답] ============================
	// ========================================================================
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num = 1; // 오름차순
		boolean result = true;
		for(int i = 0; i < A.length; i++) {
			int su = A[i];				// 현재 수열의 수
			if(su >= num) {				// 현재 수열의 값 >= 오름차순 자연수 : pop() 수행
				while(su >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			} else {					// 현재 수열의 값 < 오름차순 자연수 : pop() 수행
				int n = stack.pop();
				if(n > su) {			// 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없다.
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());
	}
}






























