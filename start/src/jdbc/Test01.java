package jdbc;
// JDBC 사용을 위한 클래스 준비한 패키지를 임포트
import java.sql.*;

public class Test01 {

	public Test01() {
		try {
			/*
			 	1. JDBC와 외부 데이터 베이스를 연결할 드라이버를 프로그램에서 가지고 와야 한다.
			 	   
			 	   외부 클래스를 로딩하는 함수 : Class.forName()
			 	   
			 	   드라이버마다 외부 클래스의 이름이 조금씩 다르다.
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/*
			 	위 명령이 실행되면 JDBC가 해당 드라이버를 이용해서 연결을 시도한다.
			 */
			System.out.println("*** 드라이버 로딩 성공 ***");
			
			/*
			 	2. 오라클에 접속 시도한다.
			 		각각의 데이터베이스마다 접속하는 방법(URL)이 조금씩 차이가 난다.
			 		이때는 구글에 검색..
			 		
			 		접속하는 명령어는 JDBC에게 명령하면 된다.
			 			DirverManager.getConnection(url, id, pw);
			 				uril : 데이터베이스 서버 주소
			 				id : 계정 이름
			 				pw : 계정 비번
			 		
			 		[참고]
			 			오라클에서는 DBMS와의 연결을 세션이라고 표현했지만
			 			JDBC에서는 커넥션(Connection)이라고 부른다.
			 			
			 			계정, 비번, 서버주소, 포트, sid
			 */
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//url은 데이터베이스마다 조금씩 달라진다.
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("### 접속 성공 ###");
			/*
			 	이처럼 접속을 하면 접속자를 관리하는 세션을 제공하게 된다.
			 	이 세션을 관리하는 클래스가 바로 Connection 이다.
			 	
			 */
			//여기까지 데이터베이스마다 조금씩 달라지고 이후의 과정은 거의 비슷
			
			/*
			  	3. 명령 전달 도구를 만든다.
			  	
			  	[형식]
			  		Statement stmt = con.createStatement();
			 */
			Statement stmt = con.createStatement();
			
			// emp 테이블의 사원 이름을 모두 조회해보자
			String sql = "SELECT * FROM emp";
			
			// 4. 질의명령이 준비됐으면 전달도구에 실어서 JDBC에게 보내면 된다.
			ResultSet rs = stmt.executeQuery(sql);
			/*
			 	명령을 전달하고 조회된 결과를 받아오는 함수
			 		stmt.executeQuery(sql);
			 	
			 	함수 실행의 결과는 ResultSet 타입의 데이터로 반환된다.
			 	ResultSet은 조회질의명령의 결과를 관리하는 클래스..
			 	
			 */
			
			//한 사람만 꺼내와보기
			rs.next();//꺼낼 사람 쪽으로 커서를 한 칸 내린다.
			int empno = rs.getInt("empno");
			String name = rs.getString("ename");//문자든 문자열이든 문자열로만 꺼내온다.
			
			//출력
			System.out.printf("%6d - %10s\n", empno, name);

			//결과가 여러 행이므로 반복해서 처리한다.
			/*
			while(rs.next()) {// 다음 줄에 꺼내올 데이터가 있으면 true, 없으면 false
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");//문자든 문자열이든 문자열로만 꺼내온다.
				
				//출력
				System.out.printf("%6d - %10s\n", empno, name);
			}
			*/
			
			// 자원 반환
			rs.close();
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test01();
	}

}
