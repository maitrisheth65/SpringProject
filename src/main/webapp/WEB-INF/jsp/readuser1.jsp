
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">





<style>
body{
    background: linear-gradient(rgba(35, 43, 85, 0.75), rgba(35, 43, 85, 0.95)) no-repeat center center;
	color:white
}
body a{
color:white
}

</style>
</head>
<body>
<h1>Read Users</h1>
    <table class="table table-bordered" border="2" width="70%" cellpadding="2">
        <tr>
            <th>Username</th>
             <th>First Name</th>
             <th>Last Name</th>
           
        </tr>
        <c:forEach var="user" items="${users1}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.userFirstName}</td>
              	 <td>${user.userLastName}</td>
              
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/">Create User</a>
<a href="/login">Logout</a>
</body>
</html>