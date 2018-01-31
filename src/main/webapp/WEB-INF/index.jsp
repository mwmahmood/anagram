<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h2>Add New Cake!</h2>
    <form method="post">
        Title : <input type="text" name="title" />
        Description : <input type="text" name="desc" /> 
        Image : <input type="text" name="image" /> 
        <input type="submit" value="Add cake" />
    </form>
	<h2></h2>
	<h2>Existing Cakes</h2>
	<table>
		<tr>
			<th></th>
			<th>Title</th>
			<th>Description</th>
			<th>Count</th>
		</tr>
		<c:forEach items="${cakes}" var="cake">
			<tr>
				<td><img src=${cake.image } style="width: 50px; height: 60px;" />
				</td>
				<td>${cake.title}</td>
				<td>${cake.desc}</td>
				<td>${cake.cakeCount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
