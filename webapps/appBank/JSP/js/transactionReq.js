document.querySelector("#viewtransaction").addEventListener("click",viewtransaction);
document.querySelector("#viewbalance").addEventListener("click",callBalance);


function viewtransaction(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET","transactdetails",true);
	xhr.onload = function(){
		if(this.status == 200){
			let line = this.responseText.split("\n");
			let tbl = document.createElement("table");
			let tr = document.createElement("tr");

			let th = document.createElement("th");
			th.appendChild(document.createTextNode("TransID"));
			tr.appendChild(th);
			
			th = document.createElement("th");
			th.appendChild(document.createTextNode("TransType"));
			tr.appendChild(th);
			
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Amount"));
			tr.appendChild(th);
			
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Balance"));
			tr.appendChild(th);
			
			tbl.appendChild(tr);
			
			document.querySelector(".response").appendChild(tbl);
			line.forEach(loop);
			function loop(item,index){
				// console.log(item);
				tr = document.createElement("tr");
				let str = item.split(",");
				let td;
				for(i = 0;i < str.length;i++){
					// console.log(str[i]);
					td = document.createElement("td");
					td.appendChild(document.createTextNode(str[i]));
					tr.appendChild(td);
				}
				tbl.appendChild(tr);

			}
			// let temp = document.querySelector(".response");
			// if(temp){
			// 	temp.textContent = this.responseText;	
			// }
			document.querySelector(".response").appendChild(tbl);
			document.querySelector("#viewtransaction").style.display = "none";			
		}
		else{
			let temp = document.querySelector(".response");
			if(temp){
				temp.textContent = "Error";	
			}
		}
	}
	xhr.send();
}		//IIFE's





function callBalance() {		//calls ViewBalance class via ajax and responsetext is JSON
	// console.log("hi");
	let xhr = new XMLHttpRequest();
	xhr.open("GET","viewbalance",true);
	xhr.send();
	
	xhr.onload = function() {
		// console.log("hi");
		if(this.status == 200){
			let Obj = JSON.parse(this.responseText);
			let ptag = document.createElement("p");
			ptag.appendChild(document.createTextNode("Your Balance is " + Obj.Balance));
			document.querySelector(".balance").appendChild(ptag);
			document.querySelector("#viewbalance").style.display = "none";
		}
		else{
			let temp = document.querySelector(".balance");
			if(temp){
				temp.addtextContent = "Error";	
			}
		}

		
	}

}

