package day05;

/*
   정수를 입력받아서 



   그 숫자가 짝수인지 홀수인지를 판별해서 출력하세요.
   단, 0인 경우는 0으로 출력하세요.
   
   if ~ else 구문으로 처리하세요.
   
 */
import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력받을 준비
		Scanner sc = new Scanner(System.in);
		
		//입력 메세지 출력
		System.out.print("정수 입력 : ");
		
		//입력 받아서 변수에 기억
		int no = sc.nextInt();
		
		String result = "정수";
		
		if(no == 0) {
			//no가 0인 경우
			result = "영";
		} else {
			//no가 0이 아닌 경우
			if(no % 2 == 0) {
				//짝수인 경우
				result = "짝수";
			} else {
				//홀수인 경우
				result = "홀수";
				
			}
		}
		
		System.out.println("입력한 정수 " + no + " 는 " + result + "입니다.");
		
	}
	

}
