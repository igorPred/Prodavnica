<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin strana</title>
</head>
<body>


<h1>  Dobrodosli Admin</h1>

<p>Dodaj proizvode : </p>
<form action "../AdminAddProductServlet" method ="get">

<input type ="text"  placeholder ="Product name"  name ="name"><br><br>
<input type ="text"  placeholder ="Product price"  name ="price"><br><br>
<input type ="text"  placeholder ="Product name"  name ="name"><br><br>
<input type ="text"  placeholder ="Product stock"  name ="stock"><br><br>
<input type ="text"  placeholder ="Product quantity"  name ="quantity"><br><br>
<input type ="text"  placeholder ="Product discont"  name ="discont"><br><br>

<input type ="submit" value ="ubaci"><br><br>

</form>


</body>
</html>