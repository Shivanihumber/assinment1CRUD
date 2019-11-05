<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Cloth Store Application</title>
</head>
<body>
<div align="center">
	<h1 style="text-align: center">Cloths Management</h1>
	<h2>
		<a href="new">Add New Cloth</a>
		&nbsp;&nbsp;&nbsp;
		<a style="text-align: center" href="list">List All Cloth</a>
	</h2>
</div>
<div align="center">
	<c:if test="${clothesItem != null}">
	<form action="update" method="post">
		</c:if>
		<c:if test="${clothesItem == null}">
		<form action="insert" method="post">
			</c:if>
			<table border="1" cellpadding="5">
				<caption>
					<h2>
						<c:if test="${clothesItem != null}">
							Edit ClothItem
						</c:if>
						<c:if test="${clothesItem == null}">
							Add New ClothItem
						</c:if>
					</h2>
				</caption>
				<c:if test="${clothesItem != null}">
					<input type="hidden" name="id" value="<c:out value='${clothesItem.id}' />" />
				</c:if>
				<tr>
					<th>Name: </th>
					<td>
						<input type="text" name="name" size="45"
							   value="<c:out value='${clothesItem.name}' />"
						/>
					</td>
				</tr>
				<tr>
					<th>Color: </th>
					<td>
						<input type="text" name="color" size="45"
							   value="<c:out value='${clothesItem.color}' />"
						/>
					</td>
				</tr>
				<tr>
					<th>Price: </th>
					<td>
						<input type="text" name="price" size="5"
							   value="<c:out value='${clothesItem.price}' />"
						/>
					</td>
				</tr>
				<tr>

					<th>Type: </th>
					<td><select class="form-group" id="type" name="type" size="2">
						<% for (model.Type type :
								model.Type.values()) { %>
						<option><%out.print(type);%></option>
						<% } %>
					</select></td>

				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save" />
					</td>
				</tr>
			</table>
		</form>
</div>
</body>
</html>
