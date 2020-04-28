<?php


$HOST_NAME="localhost";
$HOST_USER="root";
$HOST_PASS="";
$HOST_DBNAME="project";
$conn=mysqli_connect($HOST_NAME,$HOST_USER,$HOST_PASS, $HOST_DBNAME);

$target_dir= "upload/images";
$image=$_POST["image"];
$productName=$_POST["productname"];
$productDiscription=$_POST["productDis"];


if(!file_exists($target_dir)){
    mkdir($target_dir,0777,true);
}

$target_dir=$target_dir ."/". rand() . "_". time() . ".jpeg";
if(file_put_contents($target_dir,base64_decode($image))){

    $first=$target_dir;
    $second="http://192.168.43.59/project/";
    $imagess=$second."".$first;


$sql="INSERT INTO images(Productname,productDiscription,Image) VALUES ('$productName','$productDiscription','$imagess')";
$run=mysqli_query($conn,$sql);
if($run=true){
	echo "Data Inserted Successfully";
}
else{
	echo "Data Insert Failed";
}
mysqli_close($conn);

}else{
        echo json_encode([

    "Message"=> "The File has been uploaded",
    "Status"=> "Ok"

        ]);
 }

?>