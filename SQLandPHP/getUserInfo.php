<?php 
	$username = $_GET['username'];
	
	require_once('dbConnect.php');
	
	$sql = "SELECT * FROM users WHERE username='$username'";
	
	$r = mysqli_query($con,$sql);
	
	$result = array();
	
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"name"=>$row['name'],
			"username"=>$row['username'],
			"password"=>$row['password'],
			"email"=>$row['email']
			
		));

	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);