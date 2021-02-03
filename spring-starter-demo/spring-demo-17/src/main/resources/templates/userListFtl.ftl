<#import "spring.ftl" as spring />
<html>
	<head>
		<title>Spring Ftl Demo</title>
	</head>
	<body>
  <table>
    <#list userList as user>
      <tr>
        <td>
          <a href="<@spring.url '/user/showUser/${user.userName}'/>">
            ${user.userName}
          </a>
        </td>
        <td>${user.realName}</td>
        <td>${user.birthday?string("yyyy-MM-dd")}</td>
      </tr>
    </#list>
    </table>
	  </body>
</html>
