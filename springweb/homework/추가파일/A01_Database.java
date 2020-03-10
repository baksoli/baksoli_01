package springweb.a03_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import springweb.z01_vo.Emp;



// webprj.a05_database.A01_Database
// webprj.z02_vo.Emp
public class A01_Database {
	// database 연결 처리..
	// 1. jdbc driver 설정..(Web programming): 
	//    WebContent\WEB-INF\lib\ojdbc6.jar
	// 2. java로 연결 처리..
	private Connection con;
	// 3. db와 대화(sql)는 할 수 있는 객체 선언.
	private Statement stmt;
	private PreparedStatement pstmt;
	// 4. 대화를 통해서 db서버에서 결과 처리는 받는 객체..
	private ResultSet rs;
	
	// 연결 처리 메서드 선언..(Connection를 할당하기 위해서 처리)
	// ClassNotFoundException :memory에 driver가 정상적으로 호출을 하지 못할 때는 대비..
	// SQLException : 서버에 접속을 하지 못하거나, query 등 데이터를 조회/수정/삭제/등록시 문제발생을
	//   대비하여 예외 처리..
	
	// 왜? try catch 쓰지 않고 throws를 통해 처리하는 이유?
	public void setConn() throws ClassNotFoundException, SQLException {
		// 1) memory에 driver올리기..
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2) DriverManager를 통해서, 특정 database 서버에 접근..
		//   특정 서버 정보  : 드라이버:@ip:port번호:sid
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(url, "scott", "tiger");
		System.out.println("접속 성공!!");
	}
	// emp 데이터 가져오는 처리. method 구현..
	// 1) 외부 모듈(안드로이드, 웹-jsp)서 사용할 수 있게끔, 만들기..
	//    ArrayList<Emp>로 return되게 처리..
	// 2) 메서드로 정의하기를 조회을 할 것인가?
	//    메서드로 정의하기를 등록/수정/삭제를 할 것인가? 정의한다.
	// 3) 조회를 한다면?
	//    어떤 메서드가 결과로 처리되어야 하는지?
	//    - 로그인 처리는 결과 메서드는 어떻게 구현하여야 할까?
	//    - 회원 정보를 확인 - 상세회원(1명 회원정보)
	//    - 회원 정보를 확인 - 전체회원정보
	//      여러명의 회원 select id, pass, name, point... from member
	//      -- 리스트를 통해서 나타나는 데이터 정보를 하나씩 가져오는 처리를 하여야 한다.
	//      -- 한 회원 정보를 -- VO객체로 나올 수 있게 클래스를 선언..
	//      -- 한 회원를 모여서 list 형태로 나올 수 있는 ArrayList<VO>를 선언..
	//      public ArrayList<Member> getMember(){
	//         ArrayList<Member> mlist = new ArrayList<Member>();
	//         return mlist;
	//      }
	//    - 회원 정보를 확인 - 전체회원정보(검색 keyword를 통해서 처리)
	/*
	 * // SELECT * FROM MEMBER WHERE name LIKE '%홍%' 
	 * 			AND mid like '%g%';
	//      public ArrayList<Member> getMember(Member sch){
	//         ArrayList<Member> mlist = new ArrayList<Member>();
	 * 			sch.getName()
	 *          sch.getMid()
	 * 
	 * 
	//         return mlist;
	//      }
	 */
	/*	
	#list형태의 메서드 처리하기( db테이블 구성, vo,  ArrayList ), 연습
	1. 데이터베이스를 통해서 아래같이 처리하는 화면을 구성하고, 메서드를 선언할려고 한다.
		해당 내용을 테이블부터 메서드 선언까지 하세요..
		1) 문제 은행.
		   번호  구분(상식/수학/영어)  문제        정답        
		   
		2) 물품 리스트 (물품명과 원산지로 검색처리) (DB처리, VO, 메서드)
			물품id  물품명   현재재고량   물건가격   원산지
			
		3)  로그인 처리는 결과 메서드는 어떻게 구현하여야 할까?( sql 확인, 메서드 선언)
			로그인 id, pass를 입력을 통해 member의 데이터를 가져오는 내용 메서드 구현
		
		
		
			
			
			
			
			
		
		
		
		
		
		
	*/	
	
	
	
	
	//    - 현재 등록된 회원의 수를 확인
	
	
	
	// 4) 등록/수정/삭제
	
	
	
	
	
	public ArrayList<Emp> getEmpList() {
		ArrayList<Emp> elist = new ArrayList<Emp>();
		// 1. 연결..
		try {
			setConn();
		// 2. sql로 대화
			String sql = "SELECT * FROM EMP01 ";
			// setConn()에서 Connection에 메모리가 할당된 상황에서..
			// 대화객체(Statement 객체를 con.createStatement()를 통해서 처리)
			stmt = con.createStatement();
			// sql을 실행을 통해 결과를 ResultSet로 받음..
			// Statement객체 하위에 executeQuery( sql문 ) 
			// 결과값을 ResultSet 으로 받음.
			rs = stmt.executeQuery(sql);
			// ResultSet는  query를 통해서 나타는 2차원형태의 데이터이다.
			/*
			# ResultSet의 핵심 기능 요소들..
			1. next() : 커서단위로 이동처리.., 다음 행이 있는지 여부를 boolean return
			2. getString(), getInt(), getDate(), getDouble()
				해당 컬럼의 데이터 유형에 맞게 가져온다.  getString()으로 default로 가져온다.
				1) 매개값..
				 - "컬럼명"  데이터가 숫자나 날짜형이라도 getString("컬럼명")으로 가져올 수 있지만,
				 사용될 자바 변수 type으로 선언해주는 것이 유용하다..
				 	int num01 = rs.getInt("empno");
				 - index(순번이 1~~)
				 	rs.getInt(1).. select @, @, @  의 나열 순서대로 가져온다..
			*/			
			// 1. rs.next() : 행단위로 이동처리 해준다. 다음 데이터가 있으면 true/없으면 false
			int cnt=1;
			// 3. resultset 결과 가져오기..
			Emp emp=null;
			while(rs.next()) {
				// (int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno)
				emp = new Emp(
						rs.getInt("empno"),	rs.getString("ename"),rs.getString("job"),
						rs.getInt("mgr"),rs.getDate("hiredate"),rs.getDouble("sal"),
						rs.getDouble("comm"), rs.getInt("deptno")
				);
				/*
				emp = new Emp(
						rs.getInt(1),	rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getDate(5),rs.getDouble(6),
						rs.getDouble(7), rs.getInt(8)
				);
				*/				
				elist.add(emp);
			// 2. rs.get데이터type("컬럼명") : 해당 컬럼에 있는 데이터를 datatype에 맞게 가져올 수 있다.
				System.out.print((cnt++)+"번째행"+ rs.getInt("empno") +"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getInt("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
			}
			System.out.println("담기 elist 갯수:"+elist.size());
			// 4. 자원의 해제 : 마지막 생성된 자원 하나씩 자원을 해제 해준다. .close()
			rs.close();
			stmt.close();
			con.close();
			
		// 5. 예외 처리..
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			// 해제되지 않는 자원에 대하여 해제 처리..
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}

		return elist;
		
	}

	
	// emp 데이터 가져오는 처리. method 구현..
	// 1) 외부 모듈(안드로이드, 웹-jsp)서 사용할 수 있게끔, 만들기..
	//    ArrayList<Emp>로 return되게 처리..
	
	// 검색 모듈 작성시, 검색하는 param 객체를 가져온다.
	
	public ArrayList<Emp> getEmpList(Emp sch) {
		ArrayList<Emp> elist = new ArrayList<Emp>();
		// 1. 연결..
		try {
			setConn();
		// 2. sql로 대화
			String sql = "SELECT * \r\n" + 
					"FROM EMP01\r\n" + 
					"WHERE ename LIKE  '%'||UPPER('"+sch.getEname()+"')||'%'\r\n" + 
					"AND job LIKE '%'||UPPER('"+sch.getJob()+"')||'%' ";
			System.out.println("sql:"+sql);
			// setConn()에서 Connection에 메모리가 할당된 상황에서..
			// 대화객체(Statement 객체를 con.createStatement()를 통해서 처리)
			stmt = con.createStatement();
			// sql을 실행을 통해 결과를 ResultSet로 받음..
			// Statement객체 하위에 executeQuery( sql문 ) 
			// 결과값을 ResultSet 으로 받음.
			rs = stmt.executeQuery(sql);
			// ResultSet는  query를 통해서 나타는 2차원형태의 데이터이다.
			/*
			# ResultSet의 핵심 기능 요소들..
			1. next() : 커서단위로 이동처리.., 다음 행이 있는지 여부를 boolean return
			2. getString(), getInt(), getDate(), getDouble()
				해당 컬럼의 데이터 유형에 맞게 가져온다.  getString()으로 default로 가져온다.
				1) 매개값..
				 - "컬럼명"  데이터가 숫자나 날짜형이라도 getString("컬럼명")으로 가져올 수 있지만,
				 사용될 자바 변수 type으로 선언해주는 것이 유용하다..
				 	int num01 = rs.getInt("empno");
				 - index(순번이 1~~)
				 	rs.getInt(1).. select @, @, @  의 나열 순서대로 가져온다..
			*/			
			// 1. rs.next() : 행단위로 이동처리 해준다. 다음 데이터가 있으면 true/없으면 false
			int cnt=1;
			// 3. resultset 결과 가져오기..
			Emp emp=null;
			while(rs.next()) {
				// (int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno)
				emp = new Emp(
						rs.getInt("empno"),	rs.getString("ename"),rs.getString("job"),
						rs.getInt("mgr"),rs.getDate("hiredate"),rs.getDouble("sal"),
						rs.getDouble("comm"), rs.getInt("deptno")
				);
				/*
				emp = new Emp(
						rs.getInt(1),	rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getDate(5),rs.getDouble(6),
						rs.getDouble(7), rs.getInt(8)
				);
				*/				
				elist.add(emp);
			// 2. rs.get데이터type("컬럼명") : 해당 컬럼에 있는 데이터를 datatype에 맞게 가져올 수 있다.
				System.out.print((cnt++)+"번째행"+ rs.getInt("empno") +"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getInt("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
			}
			System.out.println("담기 elist 갯수:"+elist.size());
			// 4. 자원의 해제 : 마지막 생성된 자원 하나씩 자원을 해제 해준다. .close()
			rs.close();
			stmt.close();
			con.close();
			
		// 5. 예외 처리..
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			// 해제되지 않는 자원에 대하여 해제 처리..
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}
	
		return elist;
		
	}

	// emp 데이터 가져오는 처리. method 구현..
	// 1) 외부 모듈(안드로이드, 웹-jsp)서 사용할 수 있게끔, 만들기..
	//    ArrayList<Emp>로 return되게 처리..
	
	// 검색 모듈 작성시, 검색하는 param 객체를 가져온다.
	
	public ArrayList<Emp> getPrepareEmpList(Emp sch) {
		ArrayList<Emp> elist = new ArrayList<Emp>();
		// 1. 연결..
		try {
			setConn();
		// 2. sql로 대화
			String sql = "SELECT * \r\n" + 
					"FROM EMP01\r\n" + 
					"WHERE ename LIKE  '%'||UPPER( ? )||'%'\r\n" + 
					"AND job LIKE '%'||UPPER( ? )||'%' " +
					"ORDER BY empno desc ";
//				    "and deptno = ?"
		/*  PreparedStatement 객체 활용..
		 * 1. sql 문 부터 사전에 서버 컴파일에 넘기고,
		 * 2. 이 후에 ? 부분을 매핑하여 데이터 처리하는 방식..
		 * 3. sql injection을 방지하여 보안에 유리하다..
		 * 4. 속도가 빨라진다.
		 * */
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, sch.getEname());
			pstmt.setString(2, sch.getJob());
			
			rs = pstmt.executeQuery();
			int cnt=1;
			// 3. resultset 결과 가져오기..
			Emp emp=null;
			while(rs.next()) {
				// (int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno)
				emp = new Emp(
						rs.getInt("empno"),	rs.getString("ename"),rs.getString("job"),
						rs.getInt("mgr"),rs.getDate("hiredate"),rs.getDouble("sal"),
						rs.getDouble("comm"), rs.getInt("deptno")
				);
				/*
				emp = new Emp(
						rs.getInt(1),	rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getDate(5),rs.getDouble(6),
						rs.getDouble(7), rs.getInt(8)
				);
				*/				
				elist.add(emp);
			// 2. rs.get데이터type("컬럼명") : 해당 컬럼에 있는 데이터를 datatype에 맞게 가져올 수 있다.
				System.out.print((cnt++)+"번째행"+ rs.getInt("empno") +"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getInt("mgr")+"\t");
				System.out.print(rs.getDate("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.print(rs.getInt("deptno")+"\n");
			}
			System.out.println("담기 elist 갯수:"+elist.size());
			// 4. 자원의 해제 : 마지막 생성된 자원 하나씩 자원을 해제 해준다. .close()
			rs.close();
			stmt.close();
			con.close();
			
		// 5. 예외 처리..
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			// 해제되지 않는 자원에 대하여 해제 처리..
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}
	
		return elist;
		
	}
	
	
	// 등록 메서드 선언..
	public void insertEmp(Emp ins) {
	// INSERT INTO emp01 values(emp_seq.nextval, '홍길동','사원',7698, sysdate, 3000, 100, 10)
	/* DB 처리 프로세스..
	1. 연결/기본 예외처리
	2. autocommit부분을 false 처리..
	3. sql문 선언(prepare 기반 )
	4. preparedStatement 객체로 sql 실행..
	5. pstmt.setString(1, ins.getEname())  : ?에 해당 하는 데이터를 mapping 처리..
	6. commit() 확정처리..
	7. 자원해제.. close();
	8. 예외처리 중에, commit전에 발생한 문제는 rollback되게 처리..
	9. 예외 처리로 자원해제가 되지 않는 부분에 대한 자원해제..
	*/
		try {
			// 1. 연결/기본 예외처리
			setConn();
			// 2. autocommit부분을 false 처리..
			con.setAutoCommit(false);
			// 3. sql문 선언(prepare 기반 )
			String sql = "INSERT INTO emp01 values(emp_seq.nextval, ?,?,?, sysdate, ?, ?, ?)";
			// 4. preparedStatement 객체로 sql 실행..
			pstmt = con.prepareStatement(sql);
			// 5. pstmt.setString(1, ins.getEname())  : ?에 해당 하는 데이터를 mapping 처리..
			// // INSERT INTO emp01 values(emp_seq.nextval, '홍길동','사원',7698, sysdate, 3000, 100, 10)
			pstmt.setString(1, ins.getEname()); // mybatis #{ename}
			pstmt.setString(2, ins.getJob());
			pstmt.setInt(3, ins.getMgr());
			pstmt.setDouble(4, ins.getSal());
			pstmt.setDouble(5, ins.getComm());
			pstmt.setInt(6, ins.getDeptno());
			pstmt.executeUpdate();// DML  등록/수정/삭제 처리시 수행 메서드..
			// 6. commit() 확정처리..
			con.commit();
			// 7. 자원해제.. close();
			pstmt.close();
			con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			// 중간에 입력하다가 commit()전에 에러에 대하여 rollback처리.
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("롤백예외 발생..");
			}
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//9. 예외 처리로 자원해제가 되지 않는 부분에 대한 자원해제..
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
	}
	

	// 1개의 상세 내용을 조회할때..
	// VO를 1개를 return  입력값을 int empno
	public Emp getEmp(int empno) {
		Emp emp=null;
		// 각 단계는 서로 상호간에 연결고리로 연결하여야 한다.
		// 객체.메서드()
		// Connection  ==> PreparedStatment ==> ResultSet
		
		
		// 1. 연결 (Connection)
		try {
			setConn();
			// 2. 대화 (PreparedStatment)
			//     1) PreparedStatment 생성
			//     2) ? 에 대한 mapping 처리..
			//     4) PreparedStatment의 실행
			// 
			String sql = "SELECT * \r\n" + 
					"FROM emp01\r\n" + 
					"WHERE empno = ? ";
			pstmt =con.prepareStatement(sql);
			// pstmt.set데이터type(순서, 데이터)
			pstmt.setInt(1, empno);
		
			// 3. 결과 (ResultSet)
			rs = pstmt.executeQuery();
			// ResultSet은 조회한 결과와 동일..
			if(rs.next()) {
				System.out.println("데이터 있음");
				// select * from emp 순서..
				// SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
				emp = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),
							  rs.getInt(4), rs.getDate(5),rs.getDouble(6), 
							  rs.getDouble(7),rs.getInt(8));
			}
			// 4. 종료 : 연결종료, 자원해제, (.close() 결과, 대화, 연결 순으로 종료)		
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			// 5. 예외상황에 대한 처리..(Exception 처리, 메모리가 남았있을 때, 재 종료처리)
			// 중간에 예외가 발생해서 자원해제 되지 못한 것을 자원해제 처리..
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		
		
		
		
		return emp;
	}
/*
# 데이터 베이스 처리시, 개발 프로세스
1. 화면 UI에 데이터 어떻게 나타나는지 구상?
2. 필요한 테이블 구성과 sql문 작성..
3. sql 실행에 맞는 database 처리 메서드 구현.. 
	1) 한개의 통계데이터를 가져올때?
		ex) 사원이 2019에 접속한 사원수를 가져오는 메서드 구현..
		select count(*) from emp where to_char('YYYY',hiredate) = '2019'
		if(rs.next()) cnt = rs.getInt(1)
		public int getCountPerYear(int year){
			int cnt=0;
			return cnt
		}
	2) 한 row의 데이터를 가져올 때
		ex) 물건종류에 따라 물품 상세 정보를 가져오는 메서드 구현..
		public Product getProdInf(String kind){
			Product prod=null;
			return prod;
		}
	3) 다중의 list 데이터를 가져올 때
		ex) 게시물을 title과 내용에 따라 정보를 조회하는 메서드 구현..
		public ArrayList<Board> getBoardList(Board sch){
		}
	4) 등록/수정/삭제 할때..
		ex) 회원 등록 처리..
		public void insertMember( Member insert ){
		}
		ex) 물품 정보를 수정 처리한다.
		public void updateProd( Product prod){}
		
		ex) 등록된 회원 탈퇴 및 삭제 처리.
		delete from member 
		where mno = ?
		public void deleteMember( int mno/String key )
	
	
4. 처리 메서드 구현 
 	1) 입력값, return 객체/변수 어떻게 되는지 결정..
 	2) 기본 처리 패턴
 		- 접속객체? Connection
 		- 대화객체? sql PreparedStatement psmt
 				   매핑  pstmt.setString(1, 매핑데이터)
 		- 결과객체? ResultSet
			결과객체를 통해 처리할 메서드.
				if,while(rs.next(), rs.getString("컴럼명") rs.getString(1) select 순서
				commit();등록/수정/삭제
		- 자원해제
			rs.close(), pstmt.close(), con.close
		- 예외처리 내용
			try{
			}catch(SQLException)
				등록/수정/삭제  ...
				rollback();
			}finally{
				//자원이 해제 되지 못한 내용을 close if(rs!=null)
			}	
	
 * */	
	// 수정 처리 메서드 구현..
	public void updateEmp(Emp upt) {
		// 1. 접속
		try {
			setConn();
			con.setAutoCommit(false);
			// 2. 대화
			String sql = "UPDATE EMP01\r\n" + 
					"	SET ename= ?,\r\n" + 
					"		job = ?,\r\n" + 
					"		mgr = ?,\r\n" + 
					"		sal = ?,\r\n" + 
					"		comm = ?,\r\n" + 
					"		deptno= ?\r\n" + 
					"	WHERE empno = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getEname());
			pstmt.setString(2, upt.getJob());
			pstmt.setInt(3, upt.getMgr());
			pstmt.setDouble(4, upt.getSal());
			pstmt.setDouble(5, upt.getComm());
			pstmt.setInt(6, upt.getDeptno());
			pstmt.setInt(7, upt.getEmpno());
			pstmt.executeUpdate();
			// 3. commit
			con.commit();
			// 4. 자원해제
			pstmt.close();
			con.close();
			// 5. 예외 : rollback, 자원해제 점검			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			// sql예외시 자원 해제 재확인..
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}

	}
	
	
	
	/*
	# 데이터 베이스 처리시, 개발 프로세스
	1. 화면 UI에 데이터 어떻게 나타나는지 구상?
	2. 필요한 테이블 구성과 sql문 작성..
	3. sql 실행에 맞는 database 처리 메서드 구현.. 
		1) 한개의 통계데이터를 가져올때?
			ex) 사원이 2019에 접속한 사원수를 가져오는 메서드 구현..
			select count(*) from emp where to_char('YYYY',hiredate) = '2019'
			if(rs.next()) cnt = rs.getInt(1)
			public int getCountPerYear(int year){
				int cnt=0;
				return cnt
			}
		2) 한 row의 데이터를 가져올 때
			ex) 물건종류에 따라 물품 상세 정보를 가져오는 메서드 구현..
			public Product getProdInf(String kind){
				Product prod=null;
				return prod;
			}
		3) 다중의 list 데이터를 가져올 때
			ex) 게시물을 title과 내용에 따라 정보를 조회하는 메서드 구현..
			public ArrayList<Board> getBoardList(Board sch){
			}
		4) 등록/수정/삭제 할때..
			ex) 회원 등록 처리..
			public void insertMember( Member insert ){
			}
			ex) 물품 정보를 수정 처리한다.
			public void updateProd( Product prod){}
			
			ex) 등록된 회원 탈퇴 및 삭제 처리.
			delete from member 
			where mno = ?
			public void deleteMember( int mno/String key )
		
		
	4. 처리 메서드 구현 
	 	1) 입력값, return 객체/변수 어떻게 되는지 결정..
	 	2) 기본 처리 패턴
	 		- 접속객체? Connection
	 		- 대화객체? sql PreparedStatement psmt
	 				   매핑  pstmt.setString(1, 매핑데이터)
	 		- 결과객체? ResultSet
				결과객체를 통해 처리할 메서드.
					if,while(rs.next(), rs.getString("컴럼명") rs.getString(1) select 순서
					commit();등록/수정/삭제
			- 자원해제
				rs.close(), pstmt.close(), con.close
			- 예외처리 내용
				try{
				}catch(SQLException)
					등록/수정/삭제  ...
					rollback();
				}finally{
					//자원이 해제 되지 못한 내용을 close if(rs!=null)
				}	
		
	 * */	
		// 삭제 처리 메서드 구현..
		public void deleteEmp(int empno) {
			// 1. 접속
			try {
				setConn();
				con.setAutoCommit(false);
				// 2. 대화
				String sql = "DELETE FROM emp01 WHERE empno = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, empno);
				pstmt.executeUpdate();
				// 3. commit
				con.commit();
				// 4. 자원해제
				pstmt.close();
				con.close();
				// 5. 예외 : rollback, 자원해제 점검			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
				// sql예외시 자원 해제 재확인..
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
	
		}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A01_Database db = new A01_Database();
		db.getEmpList();
//		db.getEmpList(new Emp("a","man"));
		System.out.println("## PreparedStatement로 처리 ##");
//		db.getPrepareEmpList(new Emp("a","man"));
		// 등록할 Emp 객체 생성..
		// Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) 
		System.out.println("## 등록 ##");
		db.insertEmp(new Emp(0, "신길동","대리",7839,null,4000,100,20));
		System.out.println("## 등록 후 조회 ##");
//		db.getPrepareEmpList(new Emp("",""));	
		/* 
UPDATE EMP01
	SET ename= '수정1',
		job = '수정2',
		mgr = 9999,
		sal = 9999,
		comm = 100,
		deptno= 55
	WHERE empno = 7975 
	Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno)
		 * */
		Emp upt = new Emp(7975,"수정3","수정4",8888,null, 8888,800,88);
		db.updateEmp(upt);
		
		System.out.println("## 1개 데이터 조회 test ##");
		Emp dt = db.getEmp(7975);
		System.out.println("데이터 여부?"+(dt!=null));
		System.out.println("7975의 사원이름:"+dt.getEname());
		System.out.println("7975의 사원이름:"+dt.getSal());
		//dt = db.getEmp(7777);
		//System.out.println("데이터 여부?"+(dt!=null));
		//System.out.println("7777의 사원이름:"+dt.getEname());
		
			
		
		
		
		
		
	}

}
