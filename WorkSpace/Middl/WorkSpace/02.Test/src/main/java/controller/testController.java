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

@WebServlet("*.te")
public class testController extends HttpServlet {
		
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//oracle.jdbc.driver. //자동완성 됬는지
			//Sqlsessiopn  ////자동완성 됬는지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("안드로이드 미들웨어 접근함");  //엔터키 친거
		System.out.println(request.getServletPath());  
		
		//? 
		PrintWriter writer = response.getWriter();
		writer.print("servlet => g");
	
	}
	
}
