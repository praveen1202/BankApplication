function amtt(form){
	let amt = Number(form.amt.value);
	// console.log(amt);
	if(amt > 0){
		return true;
	}
	alert("Invalid input!");
	form.reset();
	return false;
}