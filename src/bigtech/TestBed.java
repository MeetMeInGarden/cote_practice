package bigtech;
public class TestBed {
	public static void main(String[] args) {
		// 1 은 소수가 아니다.
		int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		for(int num : arr) {
			if(prime(num)) {
				System.out.println(num + "은(는) 소수이다.");
			} else {
				System.out.println(num + "은(는) 소수가 아니다.");
			}
		}
	}
	
	// 소수 판별 함수
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