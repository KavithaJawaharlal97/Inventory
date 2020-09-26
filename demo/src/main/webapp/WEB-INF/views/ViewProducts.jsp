<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Products</title>
<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
 <div class="starter-template">
<table border="2" cellpadding="10" bordercolor="blue">
    <tr>
     <th>Product ID</th>
     <th>Product Name</th>
     <th>Price</th>
     <th>Quantity</th>
    </tr>
    <c:forEach var="product" items="${productss}">
     <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.quantity}</td> 
     </tr>
    </c:forEach>
   </table>
  </div>
</body>
</html>