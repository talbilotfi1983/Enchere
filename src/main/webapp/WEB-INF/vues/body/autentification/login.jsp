/Login

<%@page import="fr.encheres.bo.User"%>
<%User user7 = (User)session.getAttribute("userSuccess");
if(user7!=null){
	request.getRequestDispatcher("/home").forward(request, response);
}
%>





<form class="needs-validation row container img-thumbnail offset-3 mt-5  col-lg-6" novalidate
	action="loginServlet" method="post">
	<div class=" col-lg-6 p-3">
		<img src="resources/img/autentification/login.png"
			class="img-fluid img-thumbnail">
	</div>
	<div class="col-lg-6 p-3">
		<div class="form-group row">
			<input type="text" class="form-control " id="pseudo"
				placeholder="Enter your pseudo ..." name="pseudo"
				title="Accepted characters : a-zA-Z0-9-_\. "
				pattern="^[a-zA-Z][a-zA-Z0-9-_\. @$!?]{4,30}$" required
				maxlength="30">
			<div class="invalid-feedback">Sorry, your pseudo must start
				with an alphabitic letter and be between 4 and 30 characters long</div>
		</div>
		<div class="form-group row ">
			<input name="password" type="password" class="form-control"
				id="password" placeholder="********" required
				pattern="^[a-zA-Z0-9-_\.@$!?]{8,30}$">
			<div class="invalid-feedback">Sorry, invalid password</div>
		</div>
		<div class="form-group">
			<div class="custom-control custom-checkbox small">
				<input type="checkbox" class="custom-control-input" id="customCheck"
					name="remember_me"> <label class="custom-control-label"
					for="customCheck">Remember Me</label>
			</div>
		</div>

		<div class="form-group row ">
			<button class="btn btn-primary btn-user btn-block" type="submit"
				id="btnRegister">Login</button>
		</div>
		<hr>
		<div class="text-center ">
			<a class="small" href="forgotServlet">Forgot Password ?</a>
		</div>
		<div class="text-center ">
			<a class="small " href="registerServlet">Create an Account !</a>
		</div>
	</div>
</form>



<div class="error_connect">
	<%
String msg = (String) request.getAttribute("message");
if (msg != null) {
	out.print(msg);
}
%>
</div>


<script src="resources/js/validation_register.js"></script>