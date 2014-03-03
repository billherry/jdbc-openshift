package com.billherry.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConn {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public static final String MYSQL_USERNAME = System
			.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	public static final String MYSQL_PASSWORD = System
			.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
	public static final String MYSQL_DATABASE_HOST = System
			.getenv("OPENSHIFT_MYSQL_DB_HOST");
	public static final String MYSQL_DATABASE_PORT = System
			.getenv("OPENSHIFT_MYSQL_DB_PORT");
	public static final String MYSQL_DATABASE_NAME = System
			.getenv("OPENSHIFT_APP_NAME");
	public static final String MYSQL_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	public static final String url ="jdbc:mysql://" + MYSQL_DATABASE_HOST + ":"+ MYSQL_DATABASE_PORT + "/" + MYSQL_DATABASE_NAME;
	
	public DBConn(){
		try {			
			Class.forName("com.mysql.jdbc.Driver");			
			con = DriverManager.getConnection(url,MYSQL_USERNAME,MYSQL_PASSWORD);
			st = con.createStatement();
			System.out.println("kapcsolat létrejött");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public Statement getStatement() throws SQLException {
		return this.st;
	}
	
	public ResultSet getResultSet(String query) throws SQLException {
		rs = st.executeQuery(query);
		return this.rs;
	}
	
	public String getTableData(){
		String ret="";
		try {
			rs = st.executeQuery("select * from emp");
			System.out.println("Record from database");
			ret="<table class='table table-striped table-border table-hover table-collapsed''>";
			ret+="<thead>";
			ret+="<th>ID</th>";
			ret+="<th>Name</th>";
			ret+="<th>Job</th>";
			ret+="<th>Boss</th>";
			ret+="<th>Hire date</th>";
			ret+="<th>Salary</th>";
			ret+="<th>Benefits</th>";
			ret+="<th>Department</th>";
			ret+="</thead>";
			while(rs.next()){
				int id = rs.getInt("empno");
				ret+="<tr id="+id+" onClick='trClick("+id+")'>";
				ret+="<td>"+id+"</td>";
				ret+="<td>"+rs.getNString("ename")+"</td>";
				ret+="<td>"+rs.getNString("job")+"</td>";
				ret+="<td>"+rs.getInt("mgr")+"</td>";
				ret+="<td>"+rs.getDate("hiredate")+"</td>";
				ret+="<td>"+rs.getInt("sal")+"</td>";
				ret+="<td>"+rs.getInt("comm")+"</td>";
				ret+="<td>"+rs.getByte("deptno")+"</td>";
				ret+="</tr>";
			}
			ret+="</table>";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return ret;
	}
	
	public String getMaxSal() throws SQLException {		
		String ret="";
		String sql = "SELECT max(sal) from emp;";
		rs = st.executeQuery(sql);
		if(rs.next())
		    ret = rs.getInt(1)+"";
		return ret;
	}
	public String getMinSal() throws SQLException {		
		String ret="";
		String sql = "SELECT min(sal) from emp;";
		rs = st.executeQuery(sql);
		if(rs.next())
		    ret = rs.getInt(1)+"";
		return ret;
	}

	public String getAvgSal() throws SQLException {		
		String ret="";
		String sql = "SELECT avg(sal) from emp where job not in ('PRESIDENT');";
		rs = st.executeQuery(sql);
		if(rs.next())
		    ret = String.format("%.2f", rs.getFloat(1));		
		return ret;
	}
}

