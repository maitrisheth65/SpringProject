
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Read Users</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Update</th>
            <th>Delete</th> 
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
              	
                <td><a href="/updateuser/${user.id}">Update</a></td>
                 <td><a href="/delete/${user.id}">Delete</a></td> 
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="/index">Create User</a>