package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet("*.te")
public class testController extends HttpServlet {
		
	String resource = "mybatis/config.xml";
	InputStream inputStream ;
	SqlSessionFactory sqlSessionFactory;
	SqlSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//oracle.jdbc.driver. //자동완성 됬는지
			//Sqlsessiopn  ////자동완성 됬는지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("안드로이드 미들웨어 접근함");  //엔터키 친거
		System.out.println(request.getServletPath());  
		initMybaties();
		//? 
		PrintWriter writer = response.getWriter();
		writer.print("servlet => g");
		
			//접근하는 방법 체크하려면
			//뭘 접근해도 연결이 되나 크롬 열어서(무조건 URL로 해야됨)
			//http://localhost/01.Middle/1135432432,jdsnfkfdsjfdjwqlfew.te 
			//하면  -> getServletPath -> 컴솔창 연결해주는지
		
		if(request.getServletPath().equals("/qlfew.te")) {
			//	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//	rd.forward(request, response);
			//MvC패턴 Model, View, Controller
			//안드로이드에서 필요한거 view 가 아니라 응답 (필요한 데이터를 주는 것)
		}
	}
	public void initMybaties() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session= sqlSessionFactory.openSession();
			int testInt = session.selectOne("mybatis.test.select");
			System.out.println(testInt);
			session.close();
		} catch (Exception e) {			
		}
	}	
}
