package day16;
/*
   data.txt 파일을 읽어서 Map으로 저장해보자

 */
import java.io.*;
import java.util.*;

public class Test08 {

	public Test08() {
		Properties prop = new Properties();
		//이 Map을 외부 파일과 연결할 예정이다.
		
		//나중에 배울 거니까 그렇구나 하고 넘어가기
		FileInputStream fin = null;//파일 위치가 없으면 예외가 발생할 테니까
		try {
			fin = new FileInputStream("src/day16/data_ko.txt");//통로
			// 여기 경로는 전체 절대 경로를 사용해도 된다.
			// 이클립스 안에 데이터를 만들면 이것은 이클립스 자신이 경로를 새롭게 정해서 처리하므로
			// 위 규칙을 따르면 된다.
			
			//이제 이 파일의 내용을 Properties가 읽도록 한다.
			prop.load(fin);
			
			// 위 작업이 완료되면 파일의 내용을 읽어서 Map으로 만들어 놓은 것.
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (Exception e) {}
		}
		
		//위 작업이 아무 이상없이 완료 되면 HashMap에 데이터가 저장된 것처럼 사용하면 된다.
		String name = (String) prop.get("name");
		//출력
		System.out.println("저장된 이름 : " + name);
	}

	public static void main(String[] args) {
		new Test08();
	}

}
