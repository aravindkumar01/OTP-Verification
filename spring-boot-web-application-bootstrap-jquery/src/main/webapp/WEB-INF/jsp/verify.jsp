<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Verify</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                  
                        <h2 class="form-title">Verification</h2>
                        <div class="form-group">
                            <input type="number" class="form-input" name="" id="code" placeholder="code"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                         <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sumbit"/>
                        </div>
                        <p class="loginhere">
                        If you don't get otp? <a href="/customer/resent" class="loginhere-link">Click me</a>
                    </p>
                 
                    
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		  $("#submit").click(function(){
			  var number=$("#code").val();
			  alert(number);
			  $.ajax({
				  type: "POST",
			      url: "/customer/verify/"+number,
			      success :function(result) {
			        alert(result);
			     },
	             error: function(e){          	   
	          	  
	          	   alert(e);
	          	   	        }
			  });
	         	
			  
	         });
		});

    </script>
     
    
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>