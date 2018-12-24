<!DOCTYPE html>
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
<h1> Login here</h1>
<form name="loginForm" action="login" method="POST">
Enter user ID: <input type="text" name="userId"/> <br/>
Enter password: <input type="password" name="password"/> <br/>
<input type="submit" value="Login" onclick="return validate()"/> &nbsp; &nbsp; <input type="reset" value="reset"/>

</form>
</div>

<div>
<%@ include file="footer.html" %>
</div>
</body>
</html>