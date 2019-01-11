$(document).ready(function(){
	$("body").on("click",".btn-delete",function(){
		var personalID = $(this).closest("tr").find("#p-personalid").text();
		var self = $(this);
		var choice = confirm("Are you sure to delete this person?");
		
		if (choice == true){
			$.ajax({
				url : "/personal/delete",
				type : "POST",
				data : {
					personalID : personalID
				},
				success : function(value) {
					if ("true" == value.toString()) {
						alert("Delete Successfully !");
						self.closest("tr").remove();
					} else {
						alert("Delete Failed !");
					}

				}
			});
		}	
	});
	
	function hasNumber(myString) {
		  return /\d/.test(myString);
	}
	function validateEmail(email) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(String(email).toLowerCase());
	}
	function onlyHasNumber(myString){
		return /^[0-9]+$/.test(myString);
	}
	
	$("#btn-insert").click(function(){
		var self = $(this);
		$("#modelFormInsertPersonal").modal("show");
		
		$("#btn-save-insert").click(function(){
			var firstName = $("#modelFormInsertPersonal").find("#text-firstname").val();
			var lastName = $("#modelFormInsertPersonal").find("#text-lastname").val();
			var telephone = $("#modelFormInsertPersonal").find("#text-telephone").val();
			var email = $("#modelFormInsertPersonal").find("#text-email").val();
			var hobbies = $("#modelFormInsertPersonal").find("#text-hobbies").val();
			var description = $("#modelFormInsertPersonal").find("#text-description").val();
			
			if (hasNumber(firstName)){
				alert("Firstname không được có chữ số");
			}
			if (hasNumber(lastName)){
				alert("Lastname không được có chữ số");
			}
			if (onlyHasNumber(telephone) == false) {
				alert("Telephone phải là kiểu số");
			}
			if (validateEmail(email) == false) {
				alert("Email chưa đúng định dạng")
			}
			if (hasNumber(firstName) == false && hasNumber(lastName) == false &&  onlyHasNumber(telephone)
					&& validateEmail(email)){
				$.ajax({
					url : "/personal/insert",
					type : "POST",
					data : {
						firstName: firstName,
						lastName: lastName,
						telephone: telephone,
						email: email,
						hobbies: hobbies,
						description: description
						
					},
					success : function(value) {
						if ("true" == value.toString()) {
							$("#modelFormInsertPersonal").modal("hide");
							alert("Add person successfully ! ");
							
							document.location.reload(true);
							
						} else {
							$("#modelFormInsertPersonal").modal("hide");
							alert("Add person failed! ");
						}
					}
				});
				
			}
			
		});
	});
	
	
});