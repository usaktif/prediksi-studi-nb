<?php
require("../includes/notice.php"); 
require("../includes/koneksi.php"); 
?>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>Rekomendasi Konsentrasi - ADMIN</title>
	<meta name="description" content="">
	<meta name="author" content="cuongv">
	<meta name="robots" content="index, follow">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
			
	<!-- CSS styles -->
	<link rel='stylesheet' type='text/css' href='../asset/theme/blue_strap/css/bootstrap.min.css'>
	<link rel='stylesheet' type='text/css' href='../asset/theme/blue_strap/css/bootstrap-responsive.min.css'>
	<link rel='stylesheet' type='text/css' href='../asset/theme/blue_strap/css/main.css'>
	
	<!-- JS Libs -->
	<script src="../asset/theme/blue_strap/js/jquery.js"></script>
	<script src="../asset/theme/blue_strap/js/bootstrap.min.js"></script>
	<script src="../asset/theme/blue_strap/js/bootstrap-carousel.js"></script>
<script src="../asset/theme/blue_strap/js/redactor/jquery-1.7.min.js" type="text/javascript"></script>

	</head>
	<body>
	<div class="container">
		<!-- Main page container -->
		<div class="container-fluid content-body" id="top-bar">
			<div class="row-fluid">
				<div class="span7">
					<a class="brand pull-left" href="">
						<h1>Rekomendasi Konsentrasi</h1>
						<h4>Teknik Informatika</h4><h4> Universitas Trisakti</h4>
					</a>								
				</div>
				<div class="span5">
						
				</div>
			</div>
		</div>
		<div class="navbar">
			<div class="navbar-inner main-menu">
				<div class="container-fluid">
					<div class="row-fluid">			
						<div class="nav-collapse collapse">							 		                 
							<ul class="nav pull-left">
                            <li><a href="index.php"><i class="icon-home"></i> HOME</a></li>
                            <li><a href="?page=data_mahasiswa"><i class="icon-fire"></i> DATA TRAINING</a></li>
                            <li><a href="?page=data_uji"><i class="icon-user"></i> DATA UJI</a></li>
                            
                            </ul>							 		                 
                           
						</div>
                      
					</div>
				</div>
			</div>		
		</div>		
        
		<div class="container-fluid content-body">
           <br>

			 <?php require("../includes/bukaprogram.php"); ?>
       
        </div>
		<div class="container-fluid footer">	
		<div class="container">		
			<div class="row-fluid">	
								
			</div>	
			<div class="cleaner_h20"></div>
			Copyright © 2016 . All Rights Reserved.<br>
	</div>
		</div>
		</div>
		<!-- /Main page container -->		
	</body>	
</html>