<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$name = $_POST['name'];
		$desg = $_POST['desc'];
		$price = $_POST['price'];
		
		require_once('dbConnect.php');
		
		$sql = "UPDATE medicine SET medname = '$name', desc = '$desg', price = '$price' WHERE id = $id;";
		
		if(mysqli_query($con,$sql)){
			echo 'Medicine Updated Successfully';
		}else{
			echo 'Could Not Update Medicine Try Again';
		}
		
		mysqli_close($con);
	}