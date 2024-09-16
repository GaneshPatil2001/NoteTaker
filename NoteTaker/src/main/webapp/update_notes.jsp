<%@page import="com.helper.FactoryProvider" %>
<%@page import="org.hibernate.*" %>
<%@page import="org.hibernate.query.*" %>
<%@page import="java.util.*" %>
<%@page import="com.entities.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container-fluid p-0 m-0">
   	<%@include file="navbar.jsp" %>
   	<h1>Edit your note</h1>
   	<br>
   	<%
		   	int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			Session s=FactoryProvider.getFactory().openSession();	
			NoteTaker note=s.get(NoteTaker.class,noteId);
			
   	%>
   	<form action="updateServlet" method="post">
   		  <input value="<%= note.getId()%>" name="noteId" type="hidden"/>
		  <div class="mb-3">
				    <label for="tile" class="form-label">Note Title</label>
				    <input required type="text" 
						    name="titledata" class="form-control" 
						    id="title" aria-describedby="emailHelp" 
						    value="<%= note.getTitle() %>">
		  </div>
		  <div class="mb-3">
				    <label for="notecontent" class="form-label">Note Content</label>
				    <textarea required id ="content" 
						    name="contentdata" 
						   
						    class="form-control">
						     <%= note.getContent() %> 
				    </textarea>
		  </div>
		  <div class="container text-center">
		  		    <button type="submit" class="btn btn-success">Add</button>
		  </div>
 
</form>
</div>
</body>
</html>