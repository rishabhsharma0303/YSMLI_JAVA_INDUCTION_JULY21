<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script type="text/javascript">
	function loadXMLDoc() {
		var xmlhttp;
		var k = document.getElementById("username").value;
		var urls = "checkusername.jsp?ver=" + k;

		xmlhttp = new XMLHttpRequest();
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				document.getElementById("err").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", urls, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	User Name:
	<input type="text" name="username" id="username" onkeyup="loadXMLDoc()">
	<span id="err"> </span>
</body>
</html>













