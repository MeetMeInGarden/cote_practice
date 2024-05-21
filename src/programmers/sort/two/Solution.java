package programmers.sort.two;

// 정렬 - 가장 큰 수
class Solution {
    public String solution(int[] numbers) {
        double[] ill = new double[numbers.length];
        double[] ten = new double[numbers.length];
        double[] bac = new double[numbers.length];
        double[] chn = new double[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            ill[i] = (numbers[i] / 1.0)     + (numbers[i] % 1.0);
            ten[i] = (numbers[i] / 10.0)    + (numbers[i] % 10.0);
            bac[i] = (numbers[i] / 100.0)   + (numbers[i] % 100.0);
            chn[i] = (numbers[i] / 1000.0)  + (numbers[i] % 1000.0);
        }

        for(double tmp : ill) {
            System.out.println(tmp);
        }
        System.out.println("---------------------------------");
        for(double tmp : ten) {
            System.out.println(tmp);
        }
        System.out.println("---------------------------------");
        for(double tmp : bac) {
            System.out.println(tmp);
        }
        System.out.println("---------------------------------");
        for(double tmp : chn) {
            System.out.println(tmp);
        }
        
        String answer = "";
        return answer;
    }
}