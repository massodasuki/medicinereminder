<?php 
	$id = $_GET['id'];
	
	require_once('dbConnect.php');
	
	$sql = "SELECT * FROM medicine WHERE id=$id";
	$r = mysqli_query($con,$sql);
	
	$result = array();
	
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"medname"=>$row['medname'],
			"desc"=>$row['desc'],
			"price"=>$row['price']
		));

	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);