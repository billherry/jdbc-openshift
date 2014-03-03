package com.billherry.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//csak a js-ből hívom
		try {
			DBConn con = new DBConn();
			Statement st;
			st = con.getStatement();
			String query ="UPDATE emp SET sal = 1.1*sal WHERE LOWER(job) = 'clerk';";
			st.executeUpdate(query );
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect(request.getContextPath()+"/main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String ID = request.getParameter("ID");
			String newID = request.getParameter("newID");
			String name = request.getParameter("name");
			String job = request.getParameter("job");
			String boss = request.getParameter("boss");
			String hiredate = request.getParameter("hiredate");
			String benefits = request.getParameter("benefits");
			String deptno = request.getParameter("deptno");	
			
			DBConn con = new DBConn();
			String query= " UPDATE emp SET ename = UPPER('"+name+"') , empno="+newID+", mgr="+boss+",hiredate='"+hiredate+"',deptno="+deptno+", job='"+job+"' , comm="+benefits+" WHERE empno = "+ID+";";		
			Statement st = con.getStatement();
			st.executeUpdate(query);
			
			response.sendRedirect(request.getContextPath()+"/main");
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}

}
