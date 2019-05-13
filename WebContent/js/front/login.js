$(document).ready(function() {

	/**
	 * Variables
	 */
	const signupButton = document.getElementById('signup-button'),
	    loginButton = document.getElementById('login-button'),
	    userForms = document.getElementById('user_options-forms')

	/**
	 * Add event listener to the "Sign Up" button
	 */
	signupButton.addEventListener('click', () => {
	  userForms.classList.remove('bounceRight')
	  userForms.classList.add('bounceLeft')
	}, false)

	/**
	 * Add event listener to the "Login" button
	 */
	loginButton.addEventListener('click', () => {
	  userForms.classList.remove('bounceLeft')
	  userForms.classList.add('bounceRight')
	}, false)
	
	/**
	 * Check mdp identiques
	 */
	
	var password = document.getElementById("password_signup1"); 
	var confirm_password = document.getElementById("password_signup2");

	function validatePassword()
	{
	  if(password.value != confirm_password.value) 
	  {
	    confirm_password.setCustomValidity("Passwords Don't Match");
	  } 
	  else 
	  {
	    confirm_password.setCustomValidity('');
	  }
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
	
	
});