package day13;
/*
   25를 -3에서부터 3까지의 정수로 나눈 결과를 
   출력하는 프로그램을 작성하라
   
   필요하면 예외처리도 하라.
 */
public class Test04 {//for문 안에 try{}이 들어간 경우

	public Test04() {
		int no = 25;
		int result = 0;
		
		for(int i = -3 ; i <= 3 ; i++) {
			try {
				result = no / i;
			} catch(Exception e) {
				System.out.println(" ###예외 발생 : 0으로 나누는 연산을 시도했습니다.");
				result = no;
			}
			
			System.out.println(no + " 를 " + i + " 로 나눈 결과는 " + result + " 입니다. ");
		}
		
	}
	
	public static void main(String[] args) {
		new Test04();

	}

}
