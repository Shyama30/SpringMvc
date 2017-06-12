function validate() {
	var name = myform.name.value;
	var age = myform.age.value;
	
	if (name == "") {
		alert("please enter name ");
		return false;
	}
	if (age < 18 || age > 90) {
		alert("please enter age between 18 to 75");
		return false;

	}
}
function login() {
	var id= loginform.empid.value;
	var password= loginform.password.value;
	if(id==null || password==null)
		{
		alert("please register your information");
		}
}
