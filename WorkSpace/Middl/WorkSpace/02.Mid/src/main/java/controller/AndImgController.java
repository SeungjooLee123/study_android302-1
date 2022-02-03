package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import dto.AndImgDTO;

/**
 * Servlet implementation class AndImgController
 */
@WebServlet("*.amg")
public class AndImgController extends HttpServlet {
	String resource = "mybatis/config.xml";
	InputStream inputStream ;
	SqlSessionFactory sqlSessionFactory;
	SqlSession session;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("utf-8");

		Gson gson = new Gson();
		String rtnData = gson.toJson(initMybaties());
		System.out.println(rtnData);
		//MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/"), 3000000); //숫자=용량	
		// 안드로이드로 부터 파라미터를 입력받게 되면 처리해야할 부분.↑
		PrintWriter writer = res.getWriter();
		writer.print(rtnData);
	}
	
	
	public List<AndImgDTO> initMybaties() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session= sqlSessionFactory.openSession();
			
			List<AndImgDTO> list = session.selectList("and.mapper.select");
			session.close();
			return list;
		} catch (Exception e) {		
			e.printStackTrace();
		
		}
		return null ;
	}

}
