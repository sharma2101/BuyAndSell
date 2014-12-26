<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">

<head profile="http://gmpg.org/xfn/11">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="imagetoolbar" content="no" />

	<link rel="stylesheet" href="layout.css" type="text/css" />

	<script src="https://code.jquery.com/jquery-2.1.0.min.js" type="text/javascript"></script>
	<script src="index.js" type="text/javascript"></script>
	<script type="text/javascript" src="jquery.jcarousel.pack.js"></script>
	<script type="text/javascript" src="jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="jquery.jcarousel.setup.js"></script>
	<title>Home</title>
</head>

<body id="top">
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
      <h1><a href="#">Buy & Sell</a></h1>
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
<div class="wrapper col4">
  <div id="featured_slide">
    <div id="featured_content">
      <ul>
        <li><a href="#"><img src="images/IPhone5.jpg" alt="" /></a></li>
        <li><a href="#"><img src="images/nexus10.jpg" alt="" /></a></li>
        <li><a href="#"><img src="images/nokiatablet.jpg" alt="" /></a></li>
        <li><a href="#"><img src="images/windowsrt.jpg" alt="" /></a></li>
        <li><a href="#"><img src="images/Dell_Latitude.jpg"alt="" /></a></li>
        <li><a href="#"><img src="images/experia.jpg" alt="" /></a></li>
        <li><a href="#"><img src="images/macair.jpg" alt="" /></a></li>
         </ul>
    </div>
    
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col5">
  <div id="container">
    <div id="content">
      <h2>About Buy & Sell Electronic Store</h2>
      <img class="imgl" src="images/logo.jpg" alt="" width="125" height="125" />
      <p><strong>Your Personal Online electronic Store</strong></p>
      <p>This site is a joint venture started by three students of Illinois State University <a href="http://www.ilstu.com/">Illinois State University</a>.</p>
      <p>This site features electronic products by Apple, Samsung, Google and others. Consumers can not only purchase electronics but also upload products to sell.</p>
      <p>Development of this online store was carried out over a period of one month. This site will continue to be updated by our team as more advertisers associate with us.</p>
    </div>
    <div id="column">
    </div>
    <br class="clear" />
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
          <input type="text" value="Enter Email Here&hellip;"  onfocus="this.value=(this.value=='Enter Email Here&hellip;')? '' : this.value ;" />
          <input type="submit" name="news_go" id="news_go" value="GO" />
        </fieldset>
      </form>
      <p>To unsubscribe please <a href="#">click here &raquo;</a></p>
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
    <p class="fl_left">Copyright &copy; 2011 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <br class="clear" />
  </div>
</div>
</body>

</html>