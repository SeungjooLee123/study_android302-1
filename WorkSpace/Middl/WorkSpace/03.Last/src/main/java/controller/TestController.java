package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
public class TestController extends HttpServlet {
	String resource = "mybatis/config.xml";
	InputStream inputStream ;
	SqlSessionFactory sqlSessionFactory;
	SqlSession session;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("접근완료");
		initMybaties();
	}
	
	
	
	public void initMybaties() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session= sqlSessionFactory.openSession();
			
			int test = session.selectOne("mybatis.test.select");
			System.out.println("조회완료" + test);
			session.close();
		} catch (Exception e) {		
			e.printStackTrace();
		
		}
	}

}
