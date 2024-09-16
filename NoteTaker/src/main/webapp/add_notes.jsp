<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Add Notes</title>
		<%@include file="all_js_css.jsp" %>
	</head>
	
<body>
<body>
   	<div class="container-fluid p-0 m-0">
   	<%@include file="navbar.jsp" %>
   	<br>
   	<h1>Please fill your notes details </h1>
   	<br>
   	<!-- this is add form -->
   	<form action="SaveNoteServlet" method="post">
  <div class="mb-3">
    <label for="tile" class="form-label">Note Title</label>
    <input required type="text" name="titledata" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter here">
  </div>
  <div class="mb-3">
    <label for="notecontent" class="form-label">Note Content</label>
    <textarea required id ="content" name="contentdata" placeholder="Enter your content here" class="form-control"></textarea>
  </div>
  <div class="container text-center">
   <button type="submit" class="btn btn-primary">Add</button>
  </div>
 
</form>
   	</div>
    
</body>
</html>