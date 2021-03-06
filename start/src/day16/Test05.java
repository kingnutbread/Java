package day16;
//맵은 정렬 시 데이터가 아니라 키값 기준이다
import java.util.*;
public class Test05 {

	public Test05() {
		TreeMap map = new TreeMap();
		//맵에 이름은 키값으로 하고 나이를 데이터로 입력해보자
		map.put("제니", 27);// a < ab, aA > a 문자는 정렬이 가능하다.
		map.put("리사", 28);
		map.put("로제", 26);
		map.put("지수", 27);
		
		//키값과 데이터 출력
		//키값만 먼저 출력
		Set keys = map.keySet();
		//변환 안 하고 키값으로 데이터 출력
		for(Object key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println("====================================");
		
		//이름(키값) 기준 내림차순 정렬해서 맵에 넣어보자
		TreeMap map1 = new TreeMap(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				String name1 = (String) o1;
				String name2 = (String) o2;
				
				//문자열로 숫자를 어떻게 만들까?
				//Comparable을 구현한 String 클래스에 int compareTo() 있다.
				
				int result = name1.compareTo(name2);//오름차순
				
				return -result;//내림차순이니까 부호 반전
				
			}
			
		});
		
		//맵에 이름은 키값으로 하고 나이를 데이터로 입력해보자
		map1.put("제니", 27);// a < ab, aA > a 문자는 정렬이 가능하다.
		map1.put("리사", 28);
		map1.put("로제", 26);
		map1.put("지수", 27);
		
		//출력
		Set keys1 = map1.keySet();
		for(Object key : keys1) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("==============================================================");
		
		
		
		// Map.Entry로 꺼내서 처리하는 방법
		
		Set set = map1.entrySet(); // 이 Set 안에는 데이터 갯수만큼 map.entry 객체가 들어있다.
		// 추가된 데이터 갯수만큼 Map.Entry를 만들어서 Set에 추가해서 반환해준 것
		Iterator itor = set.iterator();// Set을 순차적으로 꺼낼 목적으로 Iterator로 변환시켜둔 것, 내용물은 그대로 map.entry가 들어있다.
		while(itor.hasNext()) {
			Object obj = itor.next();//Iterator는 버퍼메모리에 쌓이며 한 번 꺼내면 사라지므로 변수에 기억시켜둔다.
			Object key = ((Map.Entry) obj).getKey();//object를 원래로 강제형변환-> vo클래스 안에 key라는 변수에 접근하기 위해 getKey() 이용
			Object value = ((Map.Entry) obj).getValue();//위와 마찬가지
			
			String name = (String) key;
			int age = (int) value;
			
			//출력
			System.out.println(name + " : " + age);
		}
		
		
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
