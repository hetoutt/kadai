<!DOCTYPE html>
<html>
<head>
<title>Top Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div id="wrapper">
		<h3>TOP PAGE welcome ${f:h(accountform.username)}!!</h3>

		<form:form action="${pageContext.request.contextPath}/search">
			<table>
				<tr><td><input name="submit" type="submit" id="search" value="検索" /></td></tr>
			</table>
		</form:form>
		<form:form action="${pageContext.request.contextPath}/logout">
		<p>Account page is <a id="createAccount" href="${pageContext.request.contextPath}/account/create?form">here</a></p>
		<input name="logout" type="submit" id="logout" value="logout" />
		</form:form>
		
	</div>
</body>
</html>