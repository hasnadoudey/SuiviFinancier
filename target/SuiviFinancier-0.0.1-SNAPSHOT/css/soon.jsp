<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta name="description" content="ucorpora demo - Free Business Corporate HTML Template"/>
	<meta name="keywords" content="ucorpora, ucorpora demo, free, template, corporate, clean, modern, bootstrap, creative, design"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<link href="<%= request.getContextPath() %>/css/images/favicon.ico" rel="icon" type="image/png"/>

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
	           	<li class="active"><a href="<%= request.getContextPath() %>/css/index.htm" title="">Acceuil</a></li>
                <li><a href="<%= request.getContextPath() %>/pages/ProjetList.jsf" title=""><span>Programme</span></a>
                		<ul> <!-- Submenu -->
                      <li><a href="<%= request.getContextPath() %>/pages/ProjetList.jsf" title="">Fiche Signalétique</a></li>
                       <li><a href="<%= request.getContextPath() %>/pages/comp.jsf" title="">Décomposition</a></li>
                       <li><a href="<%= request.getContextPath() %>/pages/Contact.jsf" title="">Contact</a></li>
                       </ul> <!-- End Submenu --> 
                        </li>
                      <li><a href="<%= request.getContextPath() %>/pages/Fe.jsf" title=""><span>Financement</span></a>
                      			<ul> <!-- Submenu -->
                      <li><a href="<%= request.getContextPath() %>/pages/Fe.jsf" title="">Financements Extérieurs</a></li>
                      <li><a href="<%= request.getContextPath() %>/pages/EtatList.jsf" title="">Contribution de l'Etat</a></li>
                     
  		         </ul> <!-- End Submenu -->  
                </li> 
                      
                     
                     <li><a href="<%= request.getContextPath() %>/pages/OperateurList.jsf" title="">Opérateur</a></li>
                     
  		                        
             
               <li><a href="<%= request.getContextPath() %>/app/main" title="">LOGIN</a></li>
	           </ul>
          </nav>
         </div> 
      </div> 
       <div class="row space40"></div>
          <div class="slider1 flexslider">  <!-- Slider -->
            <ul class="slides">
              <li>
    	    	    <img src="<%= request.getContextPath() %>/css/images/slider/1.jpg" alt=""/>
    	    		</li>
    	    		<li>
    	    	    <img src="<%= request.getContextPath() %>/css/images/slider/2.jpg" alt=""/>
    	    		</li>
    	    		<li>
    	    	    <img src="<%= request.getContextPath() %>/css/images/slider/3.jpg" alt=""/>
    	    		</li>
                    <li>
    	    	    <img src="<%= request.getContextPath() %>/css/images/slider/4.jpg" alt=""/>
    	    		</li>
            </ul>
          </div>  <!-- Slider End -->
  </div> 
  
</header>
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
          <h3>Nos clients</h3>
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
  <!-- Footer -->
  <footer id="footer">
    <div class="container">
      <div class="row">
        <div class="span5">
        <h3>Contact</h3>
        <div>         
          <form class="form-main" name="ajax-form" id="ajax-form" action="#" method="post">
            <div id="ajaxsuccess">E-mail was successfully sent.</div> 
            <div class="error" id="err-name">Please enter name</div>
            <input name="name" id="name" type="text" value="name"
           onfocus="if(this.value == 'Name') this.value='';" onblur="if(this.value == '') this.value='Name';"/>
            
            <div class="error" id="err-email">Please enter e-mail</div>
		        <div class="error" id="err-emailvld">E-mail is not a valid format</div>
            <input  name="email" id="email" type="text" value="E-mail" onfocus="if(this.value == 'E-mail') this.value='';" onblur="if(this.value == '') this.value='E-mail';"/>

            <div class="error" id="err-message">Please enter message</div>
            <textarea  name="message" id="message" onfocus="if(this.value == 'Message') this.value='';" onblur="if(this.value == '') this.value='Message';">Message</textarea><br>
            <div>
            	<div class="error" id="err-form">There was a problem validating the form please check!</div>
            	<div class="error" id="err-timedout">The connection to the server timed out!</div>
            	<div class="error" id="err-state"></div>
            </div>
            <button id="send" class="btn f-right">Send Message <i class="icon-ok"></i></button>
          </form>
        </div>
        </div>
        <div class="span3 offset3">
          <h3>Addresse</h3>
          Centre National de l’Informatique</br>
            17, rue Belhassen Ben Chaabane, 1005 El Omrane, </br>
          Tunis Tunisie.</br>
          </br>
          <i class="icon-phone"></i>tel : + 216 71 783 055</br>
          <i class="icon-envelope"></i><a href="mailto:support@example.com"> mail:webcni@cni.tn</a></br>
          <i class="icon-home"></i><a href="#"> website : http://www.cni.tn</a>
          
          <div class="row space40"></div>  

          <a href="#" class="social-network sn2 behance"></a>
          <a href="#" class="social-network sn2 facebook"></a>
          <a href="#" class="social-network sn2 pinterest"></a>
          <a href="#" class="social-network sn2 flickr"></a>
          <a href="#" class="social-network sn2 dribbble"></a>
          <a href="#" class="social-network sn2 lastfm"></a>
          <a href="#" class="social-network sn2 forrst"></a>
          <a href="#" class="social-network sn2 xing"></a>      
        </div>
      </div>
      
      <div class="row space50"></div>
      <div class="row">
       
        <div class="span6 right">
        <center>
          &copy;  2016 Centre National de l'Informatique tous droits réservés.
          </center>
        </div>
      </div>

    </div>
  </footer>
  <!-- Footer End -->
 <!-- JavaScripts -->
  <script type="text/javascript" src="<%= request.getContextPath() %>/css/js/jquery-1.8.3.min.js"></script> 
  <script type="text/javascript" src="<%= request.getContextPath() %>/css/js/bootstrap.min.js"></script>  
  <script type="text/javascript" src="<%= request.getContextPath() %>/css/js/functions.js"></script>
  <script type="text/javascript" defer src="<%= request.getContextPath() %>/css/js/jquery.flexslider.js"></script>





</body>



</html>