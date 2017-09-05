<?php 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 
 //Getting values

 $name = $_POST['name'];
 $desg = $_POST['description'];
 $sal = $_POST['price'];
 
 //Creating an sql query
 $sql = "INSERT INTO medicine (medname,description,price) VALUES ('$name','$desg','$sal')";
 
 //Importing our db connection script
 require_once('dbConnect.php');
 
 //Executing query to database
 if(mysqli_query($con,$sql)){
 echo 'Medicine Added Successfully';
 }else{
 echo 'Could Not Add Medicine';
 }
 
 //Closing the database 
 mysqli_close($con);
 }
