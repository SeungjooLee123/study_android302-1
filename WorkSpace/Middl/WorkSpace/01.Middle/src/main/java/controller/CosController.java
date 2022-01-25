package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

//Spring  .. @Controller   -> 스피링 프레임워크가 콘트롤러 라는 것을 인식함(class)
//지금은 cos 가 아니라 Common.io(Apatch) MutipartResolver <- Xml로 한번 설정하면 손댈 필요없음
//매번 인코딩, 
@WebServlet("*.Cos")
public class CosController extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("key"));  //이 상태는 null
		// URL에 ?key=dd 넣으면 
		//http://localhost/01.Middle/CosController?key=dd   하면 dd  //따라서 String타입만 가능
		MultipartRequest multi = new MultipartRequest(req, req.getRealPath("/"), 3000000); //숫자=용량		
		System.out.println(multi.getParameter("key"));  //null, value 찍힘
	}

}
