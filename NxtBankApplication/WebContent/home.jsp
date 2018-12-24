<!DOCTYPE html>
<%@page import="com.nxtvision.bank.model.Account"%>
<%@page import="com.nxtvision.bank.model.LoginBean"%>
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

<%="Welcome: "+session.getAttribute("fullName") %>
<h1> Home screen</h1>
<p><a href="checkBalance">1. Check Balance</a></p>
<p><a href="deposit.jsp">2. Deposit</a></p>
<p><a href="withdraw.jsp">3. Withdraw</a></p>
<p><a href="transfer.jsp">4. Transfer</a></p>
<p><a href="exit">5. Exit/Logout</a></p>


</div>

<div>
<%@ include file="footer.html" %>
</div>
</body>
</html>