<?php
    
    $servername = 'dijkstra.ug.bcc.bilkent.edu.tr';
    $username ='burak.korkmaz';
    $password ='BqGpEqx1';
    $databasename ='burak_korkmaz';
    
    $database = mysqli_connect($servername, $username, $password, $databasename);
    
    if(!$database){
        die("Database is not connected. ". mysqli_connect_error());
    }
    
?>
