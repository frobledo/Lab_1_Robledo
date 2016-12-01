<?php

//Read request parameters
$message= $_POST[“message”];

// Store values in an array
$returnValue = array(“message”=>$message);

// Send back request in JSON format
echo json_encode($returnValue);

?>