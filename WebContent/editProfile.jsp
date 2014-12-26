<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN"
	dir="ltr">

<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="imagetoolbar" content="no" />

<link rel="stylesheet" href="layout.css" type="text/css" />

<script src="https://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="index.js" type="text/javascript"></script>
<script type="text/javascript" src="jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="jquery.easing.1.3.js"></script>
<script type="text/javascript" src="jquery.jcarousel.setup.js"></script>
<script src="editProfile.js" type="text/javascript"></script>
<title>My Profile</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>


<body id="top">
  <c:if test="${sessionScope.user == null}">
      	  <c:redirect url="logIn.jsp"></c:redirect>
  </c:if>
	<div class="wrapper col1">
  <div id="topbar">
    <p>Tel:309-333-4444 | Mail: 353Demo@itk.com</p>
    <ul>
     <c:if test="${sessionScope.user == null}">
      	 <li><a href="logIn.jsp" >Log In</a></li>
      	 <li><a href="register.jsp">Register</a></li>
	  </c:if>
	  
	   <c:if test="${sessionScope.user != null}">
      	<li><a onclick="logout()" href="#">Logout</a></li>
	  </c:if>
     
    </ul>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
	<div class="wrapper col2">
		<div id="header">
			<div class="fl_left">
				<h1>
					<a href="#">Buy & Sell</a>
				</h1>
				<p>Your Personal Electronic Store</p>
			</div>
			<br class="clear" />
		</div>
	</div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col3">
  <div id="topnav">
    <ul>
      
      <c:if test="${sessionScope.user != null}">
      	<p>Welcome,${user.firstName}</p><br>
	  </c:if>
	  <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="products.jsp">Products</a></li>
        <c:if test="${sessionScope.user != null}">
      	<li><a href="myProducts.jsp">My Products</a></li>
		<li><a href="editProfile.jsp">Edit Profile</a></li>
		<li><a href="insertItem.jsp">Sell Product</a></li>
		<li><a href="myCart.jsp">My Cart</a></li>
		
		</c:if>
		
    </ul>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->

	<div class="wrapper col5">
		<div id="container">
<h1>Edit Your Profile</h1>
		<div id="userDiv">
		<form id="edit">
<table>
	<tr>
		<td>Last Name</td> 
		<td><input type="text" name="last_name" id="last_name" value=${user.lastName }></td> 
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="first_name" id="first_name" value=${user.firstName }></td>
	</tr>
	
	<tr>
		<td>User ID</td>
		<td><input type="text" name="userID" id="userID" value="${user.userID }" readonly></td>
	</tr>
	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" id="password" value=${user.password }></td>
	</tr>
	<tr>
		<td>Email</td>
		<td> <input type="text" name="email" id="email" value=${user.emailID }></td>
	</tr>
	<tr>

		<td>Phone Number</td>
		<td><input type="text" name="phoneNum" id="phoneNum" value=${user.phoneNumber } ></td>
	</tr>
</table>

<input type="submit" name="Submit">
</form>
</div>

<div id="editResult"></div>

			<div class="clear"></div>
		</div>
	</div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col6">
		<div id="footer">
			<div id="newsletter">
				<h2>Stay In The Know !</h2>
				<p>Please enter your email to join our mailing list</p>
				<form action="#" method="post">
					<fieldset>
						<legend>News Letter</legend>
						<input type="text" value="Enter Email Here&hellip;"
							onfocus="this.value=(this.value=='Enter Email Here&hellip;')? '' : this.value ;" />
						<input type="submit" name="news_go" id="news_go" value="GO" />
					</fieldset>
				</form>
				<p>
					To unsubscribe please <a href="#">click here &raquo;</a>
				</p>
			</div>
			<div class="footbox">
				<h2>Srishti Sharma</h2>

			</div>
			<div class="footbox">
				<h2>Sudhanshu Mehrotra</h2>

			</div>
			<div class="footbox">
				<h2>Emma Xi</h2>
			</div>
			<br class="clear" />
		</div>
	</div>
	<!-- ####################################################################################################### -->
	<div class="wrapper col7">
		<div id="copyright">
			<p class="fl_left">
				Copyright &copy; 2011 - All Rights Reserved - <a href="#">Domain
					Name</a>
			</p>
			<p class="fl_right">
				Template by <a href="http://www.os-templates.com/"
					title="Free Website Templates">OS Templates</a>
			</p>
			<br class="clear" />
		</div>
	</div>
</body>
</html>





