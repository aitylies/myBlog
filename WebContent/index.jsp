<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBlog</title>

 <link rel="stylesheet" type="text/css" href="css/styles.css">
 <link href="https://fonts.googleapis.com/css?family=Montserrat:300, 400, 500" rel="stylesheet">
</head>
<body>

<section class="user">
  <div class="user_options-container">
    <div class="user_options-text">
      <div class="user_options-unregistered">
        <h2 class="user_unregistered-title">Pas encore de compte ?</h2>
        <p class="user_unregistered-text">Inscrivez-vous et rejoignez notre communauté de bloggueur !</p>
        <button class="user_unregistered-signup" id="signup-button">S'inscrire</button>
      </div>

      <div class="user_options-registered">
        <h2 class="user_registered-title">Déjà un compte ?</h2>
        <p class="user_registered-text">Connectes-toi vite !</p>
        <button class="user_registered-login" id="login-button">Login</button>
      </div>
    </div>

<!-- Connexion  -->      
    <div class="user_options-forms" id="user_options-forms">
      <div class="user_forms-login">
        <h2 class="forms_title">Login</h2>
        <form class="forms_form" action="Connect" method="post">
          <fieldset class="forms_fieldset">
            <div class="forms_field">
              <input name="email" type="email" placeholder="Email" class="forms_field-input" required autofocus />
            </div>
            <div class="forms_field">
              <input name="password" type="password" placeholder="Mot de passe" class="forms_field-input" required />
            </div>
          </fieldset>
          <div class="forms_buttons">
            <button type="button" class="forms_buttons-forgot">Mot de passe oublié ?</button>
            <input type="submit" value="Go" class="forms_buttons-action">
          </div>
        </form>
      </div>
      
<!-- Inscription  -->    
      <div class="user_forms-signup">
        <h2 class="forms_title">S'inscrire</h2>
        <form class="forms_form" method="post" action="SignUp">
          <fieldset class="forms_fieldset">
            <div class="forms_field">
              <input type="text" placeholder="Nom" class="forms_field-input" required />
            </div>
            <div class="forms_field">
              <input name="email" type="email" placeholder="Email" class="forms_field-input" required />
            </div>
            <div class="forms_field">
              <input name="password" type="password" placeholder="Mot de passe"" class="forms_field-input" required />
            </div>
          </fieldset>
          <div class="forms_buttons">
            <input type="submit" value="Let's go !" class="forms_buttons-action">
          </div>
        </form>
      </div>
    </div>
  </div>
</section><script type="text/javascript">
  <%
	
  if (request.getAttribute("Erreur") != null)
  {
    String message = (String) request.getAttribute("Erreur");
    System.out.println("coucou"+message);
    //out.print("alert( "+message+")");
//    out.println("<script type=\"text/javascript\">");
      out.println("alert('User or password incorrect');");
      request.removeAttribute("Erreur");
 //   out.println("location='index.jsp';");
//    out.println("</script>");
  }
%></script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/login.js"></script>
</body>
</html>