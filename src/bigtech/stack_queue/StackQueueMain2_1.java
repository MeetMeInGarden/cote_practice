package bigtech.stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 문제012 오큰수 - Stack을 이용한 정석 풀이
public class StackQueueMain2_1 {
	public static void main(String[] args) throws IOException {
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	    // 첫째 줄
	    int n = Integer.parseInt(bf.readLine());	    
	    int[] A		= new int[n];	// 수열 배열 생성
	    int[] ans	= new int[n];	// 정답 배열 생성
	    
	    // 둘째 줄
	    String[] str = bf.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	    	A[i] = Integer.parseInt(str[i]);
	    }
	    
	    Stack<Integer> myStack = new Stack<>();
	    myStack.push(0); // 처음에는 항상 스택이 비어있으므로 최초 값을 push하여 초기화
	    
	    for (int i = 1; i < n; i++) {
	    	// 스택이 비어있지 않고 && 현재 수열의 값이 A[스택TOP인덱스] 보다 크면
	        while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {  
	            ans[myStack.pop()] = A[i];  // 정답 배열에 오큰수를 현재 수열로 저장하기
	        }
	        myStack.push(i); // 신규데이터(신규인덱스) push  
	    }
	    
	    while (!myStack.empty()) {
	        // 위의 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지 stack에 쌓인 index에 -1을 넣는다.
	        ans[myStack.pop()] = -1;
	    }
	    
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    for (int i = 0; i < n; i++) {
	        bw.write(ans[i] + " ");
	    }
	    
	    bw.write("\n");
	    bw.flush();
	  }
}