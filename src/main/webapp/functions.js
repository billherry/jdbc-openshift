function trClick(id)
{
	var form = document.createElement("form");
    input = document.createElement("input");

	form.action = "DataEdit.jsp";
	form.method = "post";

	input.name = "ID";
	input.value = id;
	form.appendChild(input);

	document.body.appendChild(form);
	form.submit();	
}
function addNew()
{
	document.location.assign("AddEmp.jsp");
	
}
function addSalClerk()
{
	document.location.assign("Edit");	
}