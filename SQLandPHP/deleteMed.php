<?php 
	$id = $_GET['id'];
	
	require_once('dbConnect.php');
	
	$sql = "DELETE FROM medicine WHERE id=$id;";
	
	if(mysqli_query($con,$sql)){
		echo 'Medicine Deleted Successfully';
	}else{
		echo 'Could Not Delete Medicine Try Again';
	}
	
	mysqli_close($con);
