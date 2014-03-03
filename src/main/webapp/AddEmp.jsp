<%@page import="com.billherry.servlets.EditNew"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New employees</title>
</head>
<body>

<% if(!EditNew.Error.equals("")){
	out.write("Hiba:</br>"+EditNew.Error);	
}
EditNew.Error="";
%>
<div id="stylized" class="myform" >
	 <form action="EditNew" method="post">
	
    <label>ID
	<span class="small"></span>
	</label>
    <input type="text" name='newID' />
    
    <label>Name
	<span class="small"></span>
	</label>
	<input type="text" name="name" />
	
	<label>Job
	<span class="small"></span>
	</label>
    <input type="text" name="job" />
    
    <label>Boss
	<span class="small"></span>
	</label>
	<input type="text" name="boss" />
	
	<label>Hire date
	<span class="small"></span>
	</label>
	<input type="text" name="hiredate" />
	
	<label>Salary
	<span class="small"></span>
	</label>
    <input type="text" name="salary" />
    
    <label>Benefits
	<span class="small"></span>
	</label>
	<input type="text" name="benefits" />
	
	<label>Deptno
	<span class="small"></span>
	</label>
	<input type="text" name="deptno" />
	
	<br>
	<input type="submit" value="Mentés">
	</form>	
	</div> 
</body>
</html>