<?php

    include('connection.php');

    session_start();





    if($_SERVER["REQUEST_METHOD"] == "POST") {

        $Name = $_POST['Name'];
        $Surname = $_POST['Surname'];

        if(substr($Name, 0,1) == 'B'){
            echo ':)';
        }
        /*$myusername = mysqli_real_escape_string($database, $_POST['username']);
        $mypassword = mysqli_real_escape_string($database, $_POST['password']);


        if ($statement = mysqli_prepare($database,  "SELECT name, cid 
                      FROM customer 
                      WHERE name = '$myusername' and cid = '$mypassword' ")) {


            $name = $myusername;


            if (mysqli_stmt_execute($statement)) {

                mysqli_stmt_store_result($statement);

                if (mysqli_stmt_num_rows($statement) == 1) {

                    mysqli_stmt_bind_result($statement, $myusername, $cid);

                    if (mysqli_stmt_fetch($statement)) {

                        if ($cid == $mypassword) {
                            session_start();
                            $_SESSION['name'] = $myusername;
                            $_SESSION['cid'] = $mypassword;
                            header("location: customer_welcome.php");
                        }
                        else{
                            echo  "<script type='text/javascript'>
                                    window.alert('Customer ID that you entered is wrong');
                                    window.location.href = 'index.php'
                                    </script>";
                        }

                    }
                } else {
                    echo  "<script type='text/javascript'>
                            window.alert('Please Check the Name and Customer Id that you entered');
                            window.location.href = 'index.php'
                           </script>";
                }
            }
            else{
                echo  "<script type='text/javascript'>
                                    
                                            window.alert('Both Name and Customer ID that you entered is wrong');
                                            window.location.href = 'index.php'
                                        </script>";
            }

        }
        mysqli_stmt_close($statement);

    }

    mysqli_close($database);
    */

?>



<!DOCTYPE html>
<html lang="en">
<head>
    <title>Index</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=divice-width, inital-scale=1, shrink-to-fit= no">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <style>
        .button {
            display: inline-block;
            padding: 10px 25px;
            font-size: 24px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #4CAF50;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }

        .button:hover {background-color: #3e8e41}

        .button:active {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

        .button1 {padding: 2px 25px;
            background-color: red;}
    </style>

    <style type="text/css">
        body{ font: 14px sans-serif; }
        .wrapper{ width: 350px; padding: 20px; }
    </style>

</head>
<body>

<nav class="navbar navbar-inverse ">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand " href="index.php">Banking Application</a>
        </div>


    </div>
</nav>

    <div class="container">


        <form id = "form" class="form-signin" action="index.php" method='post' accept-charset='UTF-8' style='width: 30%;margin-left: auto;margin-right: auto;margin-top: 100px;'>
            <table>
                <h2 class="form-signin-heading, text-center" class="text-center">Log In</h2>
                    </br>
                        <p class="text-center">
                            <b>
                                Enter your name and your customer id
                            </b>
                        </p>
                    </br>
                <div class="form-group">
                    <label for="name" class="sr-only">Name</label>
                    <input type="text" name="Name" class="form-control" id="Name" placeholder="Name"  required autofocus>
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">Surname</label>
                    <input type="text" name="Surname"  class="form-control" id="Surname" placeholder="Surname"  required>
                </div>
               
                <div class="form-group">
                    <button style="width: 100%;margin-top: 20px " class="button"  value="login" style="margin-top: 20px"   >
                        Sign up
                    </button>
                </div>

            </table>
        </form>



    </div>

</body>
</html>