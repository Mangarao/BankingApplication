<!DOCTYPE html>
<%@page import="com.nxtvision.bank.model.Account"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login screen</title>
<script type="text/javascript">
	function validate(){
		var userId = document.loginForm.userId.value;
		var password = document.loginForm.password.value;
		if(userId==''){
			alert("User Id can't be blank");
			return false;
		}
		
		if(password==''){
			alert("Password can't be blank");
			return false;
		}
		
		if(password.length<6){
			alert("Password lenght should be minimum 6 characters");
			return false;
		}
		
		return true;
	}
</script>
<style>
div{
border:1px solid black;
background-color: cyan;

}

</style>
</head>
<body style='margin: 10% 20%;background: #DCDCDC'>
<div >
<%@ include file="header.html" %>
</div>
<div>
<h1> Account Details</h1>
<%
	Account account = (Account) request.getAttribute("account");
%>
<p> Account number: <%=account.getAccountNumber()%></p>
<p> Full Name: <%=account.getFirstName()+" "+account.getLastName() %></p>
<p> Balance : <%=account.getBalance() %></p>
<p> <a href='home.jsp'>Home</a> </p>
</div>
<div>
<%@ include file="footer.html" %>
</div>
</body>
</html>