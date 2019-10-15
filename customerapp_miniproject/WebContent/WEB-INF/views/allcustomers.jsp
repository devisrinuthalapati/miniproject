<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
</head>

<body>
	welcome ${emp.name}
	<br />
	<a href="logout">logout</a>
	<br />
	<br />
	<br />
	<div class="container"></div>
	<div class="row"></div>
	<div class="col-sm-6"></div>

	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>mobile</th>
				<th>delete</th>
				<th>update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.custid}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.mobile}</td>
					
					<%-- <td>${book.pubDate}</td> --%>
					<c:if test="${emp.profile == 'admin'}">
						<td><a href="delete?id=${customer.custid}">delete</a></td>
						<td><a href="update?id=${customer.custid}">update</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${emp.profile == 'admin' || emp.profile == 'manager'}">
		<a href="addcustomer">addcustomer</a>
	</c:if>

</body>
</html>