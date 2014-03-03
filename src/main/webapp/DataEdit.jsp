<%@page import="java.sql.ResultSet"%>
<%@page import="com.billherry.servlets.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editing</title>
</head>
<body>
	<%
	String [] values = new  String [8];
	DBConn con = new DBConn();
	String id = request.getParameter("ID");
	ResultSet rs = con.getResultSet("select * from emp where "+id+" = empno");	
	while(rs.next()){
		values[0]= String.valueOf(rs.getInt("empno"));
		values[1]=(rs.getNString("ename"));
		values[2]=(rs.getNString("job"));
		values[3]= String.valueOf(rs.getInt("mgr"));
		values[4]=(rs.getDate("hiredate")).toString();
		values[5]=String.valueOf(rs.getInt("sal"));
		values[6]=String.valueOf(rs.getInt("comm"));
		values[7]= String.valueOf(rs.getInt("deptno"));
	}
	%>
	
	<div id="stylized" class="myform" >
	 <form action="Edit" method="post">
	
	<input type="hidden" type="text" name="ID" value='<%= values[0] %>'/>	
    <label>ID
	<span class="small"></span>
	</label>
    <input type="text" name='newID' value='<%= values[0] %>'/>
    
    <label>Name
	<span class="small"></span>
	</label>
	<input type="text" name="name" value='<%= values[1]%>'/>
	
	<label>Job
	<span class="small"></span>
	</label>
    <input type="text" name="job" value='<%= values[2]%>'/>
    
    <label>Boss
	<span class="small"></span>
	</label>
	<input type="text" name="boss" value='<%= values[3]%>'/>
	
	<label>Hire date
	<span class="small"></span>
	</label>
	<input type="text" name="hiredate" value='<%= values[4]%>'/>
	
	<label>Salary
	<span class="small"></span>
	</label>
    <input type="text" name="salary" value='<%= values[5]%>'/>
    
    <label>Benefits
	<span class="small"></span>
	</label>
	<input type="text" name="benefits" value='<%= values[6]%>'/>
	
	<label>Deptno
	<span class="small"></span>
	</label>
	<input type="text" name="deptno" value='<%= values[7]%>'/>
	
	<br>
	<input type="submit" value="Mentés" class="btn btn-primary">
	</form>
	<div class="spacer"></div>
	</div> 
</body>
</html>