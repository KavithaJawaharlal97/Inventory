<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
</head>
<body style="background-color:grey;">

<form action="/updateproducts" method=post>
<center>
Provide the ID for which the product details need to be updated
<br>

ID: <input type="text" name="id" placeholder="Type product id here"/>
<br>
Name: <input type="text" name="name" placeholder="Type product name here"/>
<br>

Price: <input type ="text" name="price" placeholder="Type product price here"/>
<br>

Quantity: <input type="text" name="quantity" placeholder="Type product quantity here"/>
<br>
<button>UPDATE PRODUCT</button>

</center>
</form>
</body>
</html>