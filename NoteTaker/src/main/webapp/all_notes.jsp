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
<title>All Notes</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container-fluid p-0 m-0">
   	<%@include file="navbar.jsp" %>
   	<br>
   		<h1 class="text-uppercase">All Notes</h1>
   		
   	<div class="row">
   		<div class="col-12">
   		<%
   			Session s=FactoryProvider.getFactory().openSession();
   			Query q=s.createQuery("from NoteTaker");
   			List<NoteTaker> list=q.list();
   			for(NoteTaker note:list)
   			{%>
   				<div class="card mt-3">
   						<img class="card-img-top m-1 mx-auto" style ="max-width: 100px; max-height:100px;" src="IMG/pencil.png" alt="Card image cap">
					  <div class="card-body px-5">
						    <h5 class="card-title"><%= note.getTitle() %></h5>
						    	<p class="card-content"><%= note.getContent() %></p>
						    <div class="container text-center mt-2"><a href="update_notes.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Edit</a>
						     <a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a></div>
						    
					  </div>
				</div>
   		  <%}
   			s.close();
   		%>
   		
   		
   		</div>
   	</div>
   		
   	</div>
</body>
</html>