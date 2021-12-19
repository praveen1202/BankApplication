document.getElementById("withDraw").addEventListener("click",enable);
document.querySelector("#deposit").addEventListener("click",enable);
document.querySelector("#neft").addEventListener("click",enable);


function enable(){

	if (this.id === "withDraw"){
		document.getElementById("depositDiv").style.display = "none";
		document.getElementById("neftDiv").style.display = "none";
		document.getElementById("withdrawDiv").style.display = "block";
	}
	else if (this.id === "deposit"){
		document.getElementById("depositDiv").style.display = "block";
		document.getElementById("neftDiv").style.display = "none";
		document.getElementById("withdrawDiv").style.display = "none";
	}
	else {
		document.getElementById("depositDiv").style.display = "none";
		document.getElementById("neftDiv").style.display = "block";
		document.getElementById("withdrawDiv").style.display = "none";
	}
}