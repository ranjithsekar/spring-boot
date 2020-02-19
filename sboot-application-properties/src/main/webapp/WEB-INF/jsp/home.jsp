<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>${welcomeMessage}

  <table>
    <c:forEach var="day" items="${weekDays}">
      <tr>
        <td>${day}</td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>