<html>
<head>
<title>Hello</title>
</head>
<body>

	<%
	Integer id = (Integer)request.getAttribute("id");
	String name = (String)request.getAttribute("name");
	Integer salary = (Integer)request.getAttribute("salary");
	out.println("ID:- "+id);
	out.println("NAME:- "+name);
	out.println("SALARY:- "+salary);
	%>
	<h1> ${id} </h1>
	<h1> ${name} </h1>
	<h1> ${salary} </h1>
</body>
</html>