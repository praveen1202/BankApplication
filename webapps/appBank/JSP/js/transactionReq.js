(function (){
	var xhr = new XMLHttpRequest();
	xhr.open("GET","transactdetails",true);
	xhr.onload = function(){
		if(this.status == 200){
			console.log(this.responseText);
			let temp = document.querySelector(".response");
			if(temp){
				temp.textContent = this.responseText;	
			}
			
		}
		else{
			let temp = document.querySelector(".response");
			if(temp){
				temp.textContent = "this.reczsczsponseText";	
			}
		}
	}
	
	xhr.send();
})();		//IIFE's