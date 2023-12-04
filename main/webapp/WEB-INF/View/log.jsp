<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="resources/script/script.js"></script>
    <title>Sign in | Sign Up</title>
</head>

<body>
    <section>
        <div class="container">

            <!-- signin or login modal  -->
            <div class="user signin">

                <!-- image in left -->
                <div class="img"><img src="resources/images/image1.jpg" alt=""></div>
                <div class="form">
                    <form id="signIn" action="logIn" method="post">
                        <h2>Sign In</h2>
                        <span id="validationMsg"></span>
                        <label for="signInUserType">User Type:</label>
                            <select id="signInUserType" name="signInUserType">
                                <option value="admin">Admin</option>
                                <option value="student">Student</option>
                            </select>
                        <input name="signInId" id="signInId" type="text" placeholder="Your registered email">
                        <input name="signInPass" id="signInPass" type="text" placeholder="password">
                        <p class="forget"><a href="#" onclick="">Forget Password</a></p>
                        <input id="logIn" type="submit" value="Log In">
                        <p class="signupC">don't have an account? <a href="#" onclick="toggleForm();">Sign Up</a></p>
                    </form>
                </div>
            </div>

            <!-- signup or for 1st time Registration modal -->
            <div class="user signup">
                <div class="form">
                    <form id="myForm" action="">
                        <h2>Register Yourself</h2>
                        <span id = "successMsg"></span>
                        <label for="userType">User Type:</label>
                            <select id="userType" name="userType">
                            <option value="admin">Admin</option>
                            <option value="student">Student</option>
                        </select>
                        <input id="fullName" name = "fullName" type="text" placeholder="Full Name">
                        <input id="id" name = "id" type="email" placeholder="Email address"><span id="errMsg"></span>
                        <input id="uid" name = "uid" type="email" placeholder="University Email address">
                        <input id="password" name = "password" type="password" placeholder="Create password">
                        <input id="cnfPassword" name = "cnfPassword" type="password" placeholder="Confirm password">
                        <input type="submit" value="Sign up" id="submit">
                        <p class="signinC">already have an account? <a href="#" onclick="toggleForm();">Log In</a></p>
                    </form>
                </div>
                <!-- image in right -->
                <div class="img"><img src="resources/images/image2.jpg" alt=""></div>
            </div>

        </div>
    </section>


    <script>
        // javascript for login | signup page
        function toggleForm() {
            section = document.querySelector('section');
            container = document.querySelector('.container');
            container.classList.toggle('active');
            section.classList.toggle('active');
        }
    </script>
</body>

</html>