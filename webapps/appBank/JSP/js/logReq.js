// document.querySelector(".form-for-login").addEventListener("submit",sample);


function sample(form){
	// let num = Number(form.custID.value);
	if(Number.isNaN(num) == false){
		return true;
	}
	alert("Invalid Entry!");
	form.reset();
	return false;
}