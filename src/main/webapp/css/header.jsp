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
                <li><a href="<%= request.getContextPath() %>/css/about-us.htm" title="">About Us</a></li>                
                <li><a href="<%= request.getContextPath() %>/css/gallery.htm" title="">Gallery</a></li>
                <li><a href="<%= request.getContextPath() %>/css/services.htm" title="">Services</a></li>
                <li><a href="<%= request.getContextPath() %>/css/components.htm" title=""><span>Features</span></a>
  			      <ul> <!-- Submenu -->
                      <li><a href="<%= request.getContextPath() %>/css/components.htm" title="">Components</a></li>
                      <li><a href="<%= request.getContextPath() %>/css/blog.htm" title="">Blog</a></li>
                      <li><a href="<%= request.getContextPath() %>/css/blog-detail.htm" title="">Blog Detail</a></li>
                      <li><a href="<%= request.getContextPath() %>/css/contact.htm" title="">Contact</a></li>
  		         </ul> <!-- End Submenu -->      
               </li>
	           </ul>
          </nav>
         </div> 
      </div> 
        <%@ include file="/css/slidebar.jsp" %> 
  </div> 
  
</header>