<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="no-js oldie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="no-js oldie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>

   <!--- basic page needs
   ================================================== -->
   <meta charset="utf-8">
	<title>MyBlog</title>
	<meta name="description" content="">  
	<meta name="author" content="">

   <!-- mobile specific metas
   ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

 	<!-- CSS
   ================================================== -->
   <link rel="stylesheet" href="css/back/base.css">
   <link rel="stylesheet" href="css/back/vendor.css">  
   <link rel="stylesheet" href="css/back/main.css">
        

   <!-- script
   ================================================== -->
	<script src="js/back/modernizr.js"></script>
	<script src="js/back/pace.min.js"></script>

   <!-- favicons
	================================================== -->
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
	<link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body id="top">

<!-- header 
   ================================================== -->
   <header class="short-header">   

   	<div class="gradient-block"></div>	

   	<div class="row header-content">

   		<div class="logo">
	         <a href="index.html">Author</a>
	      </div>

	   	<nav id="main-nav-wrap">
				<ul class="main-navigation sf-menu">
					<li><a href="Connect" title="">Accueil</a></li>									
					<li class="has-children"><a href="single-standard.html" title="">Blog</a></li>
					<li><a href="about.html" title="">Mes posts</a></li>	
					<li class="current"><a href="CreerArticle" title="">Rediger un post</a></li>										
					<li><a href="contact.html" title="">Adminisration</a></li>
				</ul>
			</nav> <!-- end main-nav-wrap -->

			<div class="search-wrap">
				
				<form role="search" method="get" class="search-form" action="#">
					<label>
						<span class="hide-content">Search for:</span>
						<input type="search" placeholder="Oezfj"  class="search-field" value="" name="s" title="Search for:" autocomplete="off">
					</label>
					<input type="submit" class="search-submit" value="Search">
				</form>

				<a href="#" id="close-search" class="close-btn">Close</a>

			</div> <!-- end search wrap -->	

			<div class="triggers">
				<a class="search-trigger" href="#"><i class="fa fa-search"></i></a>
				<a class="menu-toggle" href="#"><span>Menu</span></a>
			</div> <!-- end triggers -->	
   		
   	</div>     		
   	
   </header> <!-- end header -->


   <!-- content
   ================================================== -->
   <section id="content-wrap" class="blog-single">

		
			<div id="comments" class="row">
				<div class="col-full">

               <center><h3>Ecrire un article</h3></center>
				

               <!-- respond -->
               <div class="respond">

                  <form name="contactForm" id="contactForm" method="post" action="CreerArticle">
  					   <fieldset>

                     <div class="form-field">
  						      <input name="cTitre" type="text" id="cTitre" class="full-width" placeholder="Titre de l'article" value="" maxlength="100">
                     </div>

                     <div class="form-field">
  						      <input name="cEmail" type="text" id="cEmail" class="full-width" placeholder="Email" value="" maxlength="30">
                     </div>

                     <div class="message form-field">
                        <textarea name="cMessage" id="cMessage" class="full-width" placeholder="Votre article" maxlength="240"></textarea>
                     </div>

                     <button type="submit" class="submit button-primary">Envoyer</button>

  					   </fieldset>
  				      </form> <!-- Form End -->

               </div> <!-- Respond End -->

         	</div> <!-- end col-full -->
         </div> <!-- end row comments -->


   </section> <!-- end content -->
<script type="text/javascript">
  <%

  
  if (request.getAttribute("Creation") != null)
  {
    String message = (String) request.getAttribute("Creation");
    request.removeAttribute("Creation");  
    out.println("alert('"+message+"');");   
  }
	%></script>


   <div id="preloader"> 
    	<div id="loader"></div>
   </div> 

   <!-- Java Script
   ================================================== --> 
   <script src="js/back/jquery-2.1.3.min.js"></script>
   <script src="js/back/plugins.js"></script>
   <script src="js/back/main.js"></script>

</body>

</html>