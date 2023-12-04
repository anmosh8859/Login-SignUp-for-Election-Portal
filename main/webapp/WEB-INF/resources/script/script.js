$(document).ready(function(){

            $("#signInId").change(function(){

                $.ajax({
                    url:"validateUserName",
                    data:{
                        signInId:$("#signInId").val(),
                        signInUserType:$("#signInUserType").val()
                    },
                    success:function(responseText){
                        $("#validationMsg").text(responseText);
                        if(responseText!==""){
                            $("#signInId").focus();
                        }
                    }
                });

            });
             
            $("#signInPass").change(function(){

                $.ajax({
                    url:"validatePass",
                    data:{
                        signInId:$("#signInId").val(),
                        signInUserType:$("#signInUserType").val(),
                        signInPass:$("#signInPass").val()
                    },
                    success:function(responseText){
                        $("#validationMsg").text(responseText);
                        if (responseText === "") {
                            // Correct password entered, enable form submission
                            $("#logIn").prop("disabled", false);
                        } else {
                            // Incorrect password, disable form submission
                            $("#logIn").prop("disabled", true);
                        }
                    }
                });

            });
            
            $("#id").change(function(){

                $.ajax({
                    url:"validate",
                    data:{
                        id:$("#id").val(),
                        userType:$("#userType").val()
                    },
                    success:function(responseText){
                        $("#errMsg").text(responseText);
                        if(responseText!==""){
                            $("#id").focus();
                        }
                    }
                });

            });

            $("#userType").change(function(){

                $("#myForm input[type='text'], #myForm input[type='password'], #myForm input[type='email']").val("");

            });

            $("#submit").click(function(event) {
                var pass = $("#password").val();
                var cnfPass = $("#cnfPassword").val();
                event.preventDefault();
                if(pass!==cnfPass){
                    alert("Password and Confirm Password do not match...");
                    $("#myForm input[type='password']").val("");
                }
                else if(pass.length<=3){
                    alert("Password is too small...");
                } else{
                    $.ajax({
                        url:"handle",
                        data:{
                            id:$("#id").val(),
                            userType:$("#userType").val(),
                            uid:$("#uid").val(),
                            password:$("#password").val(),
                            cnfPassword:$("#cnfPassword").val(),
                            fullName:$("#fullName").val()
                        },
                        success:function(responseText){
                            if($("#id").val()===responseText){
                                $("#successMsg").css("color","green");
                                $("#successMsg").text(responseText+" has been registered successfully");
                            }
                            else{
                                $("#successMsg").text("Registration failed, Please try again.");
                            }
                            $("#myForm input[type='text'], #myForm input[type='password'], #myForm input[type='email']").val("");
                        }
                    });
                }
            });
        });