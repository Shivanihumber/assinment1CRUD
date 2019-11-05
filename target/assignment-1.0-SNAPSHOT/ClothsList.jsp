<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Cloth Store Application</title>
</head>
<body>
    <div align="center">
		<h1>Cloths Management</h1>
        <h2>
        	<a href="new">Add New Cloths</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Cloths</a>
        </h2>
    </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of ClothsItem</h2></caption>
            <tr>
                <th>ID</th>
                <th>Color</th>

                <th>Name</th>
                <th>Price</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="clothesItem" items="${listClothesItem}">
                <tr>
                    <td><c:out value="${clothesItem.id}" /></td>
                    <td><c:out value="${clothesItem.color}" /></td>
                    <td><c:out value="${clothesItem.name}" /></td>
                    <td><c:out value="${clothesItem.price}" /></td>
                    <td><c:out value="${clothesItem.type}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${clothesItem.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${clothesItem.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
