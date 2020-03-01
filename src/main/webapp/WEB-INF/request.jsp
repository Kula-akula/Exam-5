<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="unicode-range: UTF-8">
<head>
	<meta charset="utf-8">
	<title>IT Academy lesson</title>
</head>
<body style="background-color: grey">
<form action="${pageContext.request.contextPath}/request" method="Post">
	Full name:   <input type=" text" name="full_Name" style="background-color: green"/>
	<br>
	Birth date:   <input type=" text" name="birth_date" style="background-color: grey"/>

    <br>
    Gender: <input type="text" name="gender"/>
    <br>

	<input type="submit" value="Отправить"style="background-color: red"/>
</form>
</body>
</html>