<?php
if (version_compare(phpversion(), "5.3.0", ">=")  == 1)
  error_reporting(E_ALL & ~E_NOTICE & ~E_DEPRECATED);
else
  error_reporting(E_ALL & ~E_NOTICE);
  function getName($tb,$primary,$parameter,$field){
	global $mysqli;
	$selectArg="select * from `".$tb."` where `".$primary."`='$parameter'";
	$selectDB=mysqli_query($mysqli,$selectArg);
			$d=mysqli_fetch_assoc($selectDB);
 $d[$field];
return $d[$field];
}
  ?>