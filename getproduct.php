<?php
$HOST_NAME="localhost";
$HOST_USER="root";
$HOST_PASS="";
$HOST_DBNAME="project";
$conn=mysqli_connect($HOST_NAME,$HOST_USER,$HOST_PASS, $HOST_DBNAME);
	$query="SELECT * FROM images;";
	$result=mysqli_query($conn,$query);
	$response=array();
	while($row=mysqli_fetch_array($result))
	{
		
		array_push($response,array('Id'=>$row[0],'ProductName'=>$row[1],'ProductDiscription'=>$row[2],'Image'=>$row[3]));
	}
	
	mysqli_close($conn);
	
	echo json_encode(array('Data'=>$response));
	
	
?>