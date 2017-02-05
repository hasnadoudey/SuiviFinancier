<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:ui="http://java.sun.com/jsf/facelets">

<head>
<meta name="description" content="ucorpora demo - Free Business Corporate HTML Template"/>
	<meta name="keywords" content="ucorpora, ucorpora demo, free, template, corporate, clean, modern, bootstrap, creative, design"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<link href="<%= request.getContextPath() %>/css/images/cni.ico.jpg" rel="icon" type="image/png"/>

  <!-- Styles -->
  <link href="<%= request.getContextPath() %>/css/styles.css" rel="stylesheet"/>
  <link href="<%= request.getContextPath() %>/css/bootstrap-override.css" rel="stylesheet"/>

  <!-- Font Avesome Styles -->
  <link href="<%= request.getContextPath() %>/css/font-awesome/font-awesome.css" rel="stylesheet"/>
	

 
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/flexslider.css" type="text/css" media="screen" />

</head>
<body>
 <!-- Header -->
  <header id="header">
    <div class="container">
      <div class="row t-container">

        <!-- Logo -->
        <div class="span3">
          <div class="logo">
            <a href="<%= request.getContextPath() %>/css/index.htm"><img src="<%= request.getContextPath() %>/css/images/logo-header.png" alt=""/></a>
          </div>            
        </div>

        <div class="span9">
          <div class="row space60"></div>
             <nav id="nav" role="navigation">
               	<a href="#nav" title="Show navigation">Show navigation</a>
	            <a href="#" title="Hide navigation">Hide navigation</a>
	            <ul class="clearfix">
	           	<li class="active"><a href="<%= request.getContextPath() %>/css/index.htm" title="">Home</a></li>
                <li><a href="<%= request.getContextPath() %>/pages/ProjetList.jsf" title="">About Us</a></li>                
                <li><a href="<%= request.getContextPath() %>/css/gallery.htm" title="">Gallery</a></li>
                <li><a href="<%= request.getContextPath() %>/css/components.htm" title=""><span>Features</span></a>
  			      <ul> <!-- Submenu -->
                      <li><a href="<%= request.getContextPath() %>/css/components.htm" title="">Components</a></li>
                      <li><a href="<%= request.getContextPath() %>/css/blog.htm" title="">Blog</a></li>
                      <li><a href="<%= request.getContextPath() %>/css/blog-detail.htm" title="">Blog Detail</a></li>
                      <li><a href="<%= request.getContextPath() %>/WEB-INF/flows/main/welcome.jsf" title="">Contact</a></li>
  		         </ul> <!-- End Submenu -->      
               </li>
               <li><a href="<%= request.getContextPath() %>/app/main" title="">LOGIN</a></li>
	           </ul>
          </nav>
         </div> 
      </div> 
       <div class="row space40"></div>
        
  </div> 
  
</header>
<div id="content">
				 <%@ include file="/pages/OperateurList.xhtml" %> 
			</div>


</body>
</html>
