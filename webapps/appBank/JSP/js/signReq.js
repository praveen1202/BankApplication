function signup(form){
	if(form.password1.value == form.password2.value){
		return true;
	}
	alert("Passwords does not match!");
	form.reset();
	return false;
}