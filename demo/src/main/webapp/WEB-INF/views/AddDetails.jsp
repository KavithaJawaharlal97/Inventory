<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Details</title>
</head>
<body style="background-color:grey;">
<form action="/addproducts" method=post>
<center>
Name: <input type="text" name="name" placeholder="Type product name here"/><br>
Price: <input type ="text" name="price" placeholder="Type product price here"/><br>
Quantity: <input type="text" name="quantity" placeholder="Type product quantity here"/>
<br>
<button>ADD PRODUCT</button>
</center>

</form>
</body>
</html>