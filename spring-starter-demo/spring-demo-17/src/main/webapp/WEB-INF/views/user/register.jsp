
<?xml version="1.0" encoding="ISO-8859-1"?>

<taglib xmlns="http://java.sun.com/xml/ns/javaee"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
		version="2.1">
	<tlib-version>1.0</tlib-version>
	<short-name>myshortname</short-name>
	<uri>http://mycompany.com</uri>
	<!-- Invoke 'Generate' action to add tags or functions -->
</taglib>

<html>
<head>
<title>新增用户</title>
</head>
<body>
  <form method="post" action="<c:url value="/user.html"/>">
    <table>
	    <tr>
	       <td>用户名：</td>
	       <td><input type="text" name="userName"  value="${user.userName}"/></td>
	    </tr>
	    <tr>
	     <td>密码：</td>
	       <td><input type="password" name="password" value="${user.password}"/></td>
	    </tr>
	    <tr>
	     <td>姓名：</td>
	       <td><input type="text" name="realName" value="${user.realName}"/></td>
	    </tr>
	    <tr>
	     <td>生日：</td>
	       <td><input type="text" name="realName" value="${user.birthday}"/></td>
	    </tr>
	    	    	    	    <tr>
	     <td>工资：</td>
	       <td><input type="text" name="realName" value="${user.salary}"/></td>
	    </tr>
	    <tr>
	     <td colspan="2"><input type="submit" name="提交"/></td>
	    </tr>	    
    </table>
  </form>
</body>
</html>