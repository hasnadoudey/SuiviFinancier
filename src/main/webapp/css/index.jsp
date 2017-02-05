<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Refresh" content="0; URL=" />
<%@ include file="/css/css.jsp" %> 
 
</head>
<body>


  <%@ include file="/css/header.jsp" %> 


  <!-- Content -->
  <div id="content">
    <div class="container">
       <div class="f-center">
              <h2>why choose us ?</h2>
              <div class="head-info">
                Magna in pulvinar tempor montes pulvinar habitasse parturient? Elementum facilisis sit et, dolor placerat, turpis auctor. Lundium ultricies augue urna arcu aliquet velit?
            </div>  
       </div>
       <div class="f-hr"></div>
      <div class="row space40"></div>
      <div class="row">
        <div class="span12">
          <div class="row">
            <!-- Service Container --> 
            <div class="span4">
              <!-- Service Icon --> 
              <div class="ic-1"><i class="icon-lightbulb"></i></div>
              <!-- Service Title --> 
              <div class="title-1"><h4>Powerful clean design</h4></div>
              <!-- Service Content --> 
              <div class="text-1"> 
                On sait depuis longake apple pie. Gingerbread cotton candy icing ice cream applicake wafetemps nnaire de plus de 200 mots pluskan rlatin
              </div>
            </div>
            <!-- Service Container End --> 
            <div class="span4">
              <div class="ic-1"><i class="icon-resize-small"></i></div>
              <div class="title-1"><h4>Fully responsive</h4></div>
              <div class="text-1">         
                Iil utilise un dictionnaire de plus de 200 mots kan rlarem as Ipsumtiotins, en combiake apple pie. Gingerbread icing ice cream applicake wafenaison.
              </div>
            </div>
            <div class="span4">
              <div class="ic-1"><i class="icon-eye-open"></i></div>
              <div class="title-1"><h4>Retina Ready</h4></div>
              <div class="text-1">
                Contrairement à une opinion répandue, Lorem as Ipsumtionnaire de plus n'est pas simplake apple pie. Gingerbread cotton  ice cream applicake wafeement.
              </div>
            </div>    
          </div>   
        </div>   
       
        <div class="span12">
          <h2>We have provide best consulting service</h2>
        </div> 
        <div class="span8">        
          <img src="<%= request.getContextPath() %>/css/images/image01.png" alt=""/>
        </div>
        <div class="span4">
          <div class="ic-1"></div>
          <div class="title-1"><h4>Our Service:</h4></div>
          <!-- List -->
          <div class="text-1"> 
            <ul class="list-b">
              <!-- List Items -->
              <li><i class="icon-ok"></i> Tax Consulting.</li>
              <li><i class="icon-ok"></i> Business Consulting.</li>
              <li><i class="icon-ok"></i> Data analysis methods.</li>
              <li><i class="icon-ok"></i> On demand consulting.</li>
              <li><i class="icon-ok"></i> Private consultant.</li>
            </ul>     
          </div>
          <!-- List End -->
        </div>
               
      </div>

      <div class="space40"></div>  
              
      <!-- Our Clients -->
      <div class="row">
        <div class="span12">
          <h3>Our Clients</h3>
        </div>
      </div> 
    
      <div id="our-clients" class="slider2 flexslider">
        <ul class="slides">
          <li>
            <div class="row">
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/1.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/2.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/3.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/4.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/5.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/6.png" alt=""/>
                </a>
              </div>
            </div>  
          </li>
          <li>
            <div class="row">
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/4.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/3.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/1.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/2.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/5.png" alt=""/>
                </a>
              </div>
              <div class="span2">
                <a href="#" rel="external">
                    <img src="<%= request.getContextPath() %>/css/images/our-clients/6.png" alt=""/>
                </a>
              </div>
            </div>  
          </li>
        </ul>
      </div> 
      <!-- Our Clients End -->
      
      <div class="space50"></div> 
       
    </div>
  </div>
  <!-- Content End -->
     
       <%@ include file="/css/footer.jsp" %>
 

</body>
  <%@ include file="/css/js.jsp" %> 
</html>