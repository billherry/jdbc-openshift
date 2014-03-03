package com.billherry.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditNew
 */
@WebServlet("/EditNew")
public class EditNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String Error="";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String newID = request.getParameter("newID");
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String boss = request.getParameter("boss");
		String hiredate = request.getParameter("hiredate");
		String salary = request.getParameter("salary");
		String benefits = request.getParameter("benefits");
		String deptno = request.getParameter("deptno");
		
		DBConn con = new DBConn();
		String query= " INSERT INTO emp VALUES ("+newID+",UPPER('"+name+"'),UPPER('"+job+"'),"+boss+",'"+hiredate+"',"+salary+","+benefits+","+deptno+");";
		System.out.println(query);				
		Statement st = con.getStatement();
		st.executeUpdate(query);		
		
		response.sendRedirect(request.getContextPath()+"/main");
		
		} catch (SQLException e) {			
			PrintWriter out = response.getWriter();
			Error=e.getMessage();
			response.sendRedirect(request.getContextPath()+"/AddEmp.jsp");
		}
	} 
}
