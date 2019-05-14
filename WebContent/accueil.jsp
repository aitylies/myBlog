<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

		<meta charset="UTF-8">
		<title>MyBlog</title>

   <!--- basic page needs
   ================================================== -->
   <meta charset="utf-8">
	<title>Scooter électrique</title>
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
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
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
					<li class="current"><a href="index.html" title="">Accueil</a></li>									
					<li class="has-children"><a href="single-standard.html" title="">Blog</a></li>
					<!-- <li><a href="style-guide.html" title="">Styles</a></li> -->
					<li><a href="about.html" title="">Mes posts</a></li>	
					<li><a href="CreerArticle" title="">Rediger un post</a></li>										
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


   <!-- masonry
   ================================================== -->
   <section id="bricks">

   	<div class="row masonry">

   		<!-- brick-wrapper -->
         <div class="bricks-wrapper">

         	<div class="grid-sizer"></div>
<script type="text/javascript">
  <%
	

    // String message = (String) request.getAttribute("Article");
  	//List<Blog> blog = request.getAttribute("Article"); 

      out.println("alert('"+request.getAttribute("ListeBLog")+"');");   
  
		
  	
  	
	%></script>

 <!-- Beginning article -->
         	<article class="brick entry format-standard animate-this">

               <div class="entry-text">
               	<div class="entry-header">

               		<div class="entry-meta">
               			<span class="cat-links">
               				<a href="#" style="color:grey">20/09/2019 - </a> 
               				<a href="#">Ylies</a>               				
               			</span>			
               		</div>

               		<h1 class="entry-title"><a href="single-standard.html">Just a Standard Format Post.</a></h1>
               		
               	</div>
						<div class="entry-excerpt">
							Lorem ipsum Sed eiusmod esse aliqua sed incididunt aliqua incididunt mollit id et sit proident dolor nulla sed commodo est ad minim elit reprehenderit nisi officia aute incididunt velit sint in aliqua cillum in consequat consequat in culpa in anim.
						</div>
               </div>
        		</article> 
<!-- end article -->

 <!-- Beginning article -->
         	<article class="brick entry format-standard animate-this">

               <div class="entry-text">
               	<div class="entry-header">

               		<div class="entry-meta">
               			<span class="cat-links">
               				<a href="#" style="color:grey">20/09/2019 - </a> 
               				<a href="#">Ylies</a>               				
               			</span>			
               		</div>

               		<h1 class="entry-title"><a href="single-standard.html">Just a Standard Format Post.</a></h1>
               		
               	</div>
						<div class="entry-excerpt">
							Lorem ipsum Sed eiusmod esse aliqua sed incididunt aliqua incididunt mollit id et sit proident dolor nulla sed commodo est ad minim elit reprehenderit nisi officia aute incididunt velit sint in aliqua cillum in consequat consequat in culpa in anim.
						</div>
               </div> 
        		</article> 
<!-- end article -->

 <!-- Beginning article -->
         	<article class="brick entry format-standard animate-this">

               <div class="entry-text">
               	<div class="entry-header">

               		<div class="entry-meta">
               			<span class="cat-links">
               				<a href="#" style="color:grey">20/09/2019 - </a> 
               				<a href="#">Ylies</a>               				
               			</span>			
               		</div>

               		<h1 class="entry-title"><a href="single-standard.html">Just a Standard Format Post.</a></h1>
               		
               	</div>
						<div class="entry-excerpt">
							Lorem ipsum Sed eiusmod esse aliqua sed incididunt aliqua incididunt mollit id et sit proident dolor nulla sed commodo est ad minim elit reprehenderit nisi officia aute incididunt velit sint in aliqua cillum in consequat consequat in culpa in anim.
						</div>
               </div>
        		</article> 
        		
       
<!-- end article -->







         </div> <!-- end brick-wrapper --> 

   	</div> <!-- end row -->


   </section> <!-- end bricks -->

   
   <!-- footer
   ================================================== -->
   <footer>

   	<div class="footer-main">

   		<div class="row">  

	      	<div class="col-four tab-full mob-full footer-info">            

	            <h4>Notre blog</h4>

	               <p>
		          	Notre blog a vocation ....
		          	</p>

		      </div> <!-- end footer-info -->

	      	<div class="col-two tab-1-3 mob-1-2 site-links">

	      		<h4>Liens</h4>

	      		<ul>
	      			<li><a href="#">A propos</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Mentions légales</a></li>
					</ul>

	      	</div> <!-- end site-links -->  

	      	<div class="col-two tab-1-3 mob-1-2 social-links">

	      		<h4>Social</h4>

	      		<ul>
	      			<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
						<li><a href="#">Dribbble</a></li>
						<li><a href="#">Google+</a></li>
						<li><a href="#">Instagram</a></li>
					</ul>
	      	           	
	      	</div> <!-- end social links --> 

	      	<div class="col-four tab-1-3 mob-full footer-subscribe">

	      		<h4>Newsletter</h4>

	      		<p>Restez branché(e)(s). Inscrivez-vous à notre newletter</p>

	      		<div class="subscribe-form">
	      	
	      			<form id="mc-form" class="group" novalidate="true">

							<input type="email" value="" name="dEmail" class="email" id="mc-email" placeholder="Votre email" required=""> 
	   		
			   			<input type="submit" name="subscribe" >
		   	
		   				<label for="mc-email" class="subscribe-message"></label>
			
						</form>

	      		</div>	      		
	      	           	
	      	</div> <!-- end subscribe -->         

	      </div> <!-- end row -->

   	</div> <!-- end footer-main -->

      <div class="footer-bottom">
      	<div class="row">

      		<div class="col-twelve">
	      		<div class="copyright">
		         	<span>© Copyright 2018 Movinnov. All rights reserved</span> 
		         	<span>Design by <a href="http://www.styleshout.com/">styleshout</a></span>		         	
		         </div>

		         <div id="go-top">
		            <a class="smoothscroll" title="Back to Top" href="#top"><i class="icon icon-arrow-up"></i></a>
		         </div>         
	      	</div>

      	</div> 
      </div> <!-- end footer-bottom -->  

   </footer>  

   <div id="preloader"> 
    	<div id="loader"></div>
   </div> 

   <!-- Java Script
   ================================================== --> 
   <script src="js/back/jquery-2.1.3.min.js"></script>
   <script src="js/back/plugins.js"></script>
   <script src="js/back/jquery.appear.js"></script>
   <script src="js/back/main.js"></script>

</body>

</html>