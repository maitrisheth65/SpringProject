<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Create User</h1>
<form:form method="post" action="/register">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><form:input path="password"/></td>
        </tr>
       
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form:form>
<a href="/login">Already have a account?Login</a>