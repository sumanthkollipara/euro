<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
 <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
  rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
<table border="1">
  <tr>
   <th>Currency</th>
    <th>Month 1</th>
    <th>Month 2</th>
    <th>Month 3</th>
    <th>Month 4</th>
    <th>Month 5</th>
    <th>Month 6</th>
  </tr>
  <tr>
   <c:forEach items="${allhisotry}" var="hisotry" varStatus="counter">
                    <tr>
                     <td>${hisotry.key}</td>
                    <c:forEach var='arrayItem' items='${hisotry.value}' > <td>${arrayItem}</td></c:forEach>
                       
                      
                    </tr>
     </c:forEach>
                

                
  </tr>
 
 
</table>

</body>
</html>