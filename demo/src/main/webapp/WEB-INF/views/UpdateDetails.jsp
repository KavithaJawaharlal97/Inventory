<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
</head>
<body>

<form action="/updateproducts" method=post>
Provide the ID for which the product details need to be updated
<br>

ID: <input type="text" name="id" />
<br>
Name: <input type="text" name="name" />
<br>

Price: <input type ="text" name="price"/>
<br>

Quantity: <input type="text" name="quantity" />
<br>
<button>UPDATE PRODUCT</button>


</form>
</body>
</html>