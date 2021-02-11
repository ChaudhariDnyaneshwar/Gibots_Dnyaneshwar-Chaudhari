
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
<form action="insert">
Enter name:
<input type="text" name="name"/>
<br>Enter the Age
<input type="text" name="age"><br>
Enter the Marks
<input type="text" name="marks"><br><br>
<input type="submit" value="insert">
</form>
<a href="getAdditionMarks">Addition of marks</a>
<b>Addition is  : ${addition }</b>
<br><br>
<a href="getlist">list</a>
<table>
<tbody>
<jstl:forEach var="list" items="${list}">

   <tr>

   <td>${list.name}</td>
   <td>${list.age }</td>
   <td>${list.marks }</td>
 </tr>
</jstl:forEach>
 
</tbody>
 </table>
</body>
</html>
