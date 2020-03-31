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


<script type="text/javascript">
function getHistory(key) {
	debugger;
	$("#base").val(key);
	alert($("#base").val());
	$("#converter1").submit();
	$("#converter2").submit();
}
	//$("#converter").submit();
	
	/* $.ajax
    ({ 
        url: '/history',
        data: {
        	"id": key
        	},
        type: 'get',
        success: function(result)
        {
        	$("#historyDiv").html(result);
        }
    });
	} */
	
	

</script>


<form:form  modelAttribute="currencyConversionBean"   method="GET"  action="/history" id ="converter2" >
<input type ="hidden" id = "base" value =""></input>
</form:form>
 
 <form:form  modelAttribute="currencyConversionBean"   method="GET"  action="" id ="converter1" >
 
 
  
 
<table border="1">
  <tr>
    <th>Currency type</th>
    <th>Euro value</th>
    <th>History</th>
  </tr>
  
   <c:forEach items="${currencyMap}" var="currencyMap" varStatus="counter">
                    <tr>
                        <td>${currencyMap.key}</td>
                        <td>${currencyMap.value}</td>
                        <td> <button onclick="getHistory('${currencyMap.key}');">History</button><td>
                    </tr>
                </c:forEach>
  
</table>
</form:form>

 
 
 
 <div id ="historyDiv">
 
 </div>