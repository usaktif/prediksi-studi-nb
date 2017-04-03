<?php
require("./includes/notice.php"); 
require("./includes/koneksi.php"); 
?>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>Rekomendasi Konsentrasi - RKM1</title>
	<meta name="description" content="">
	<meta name="author" content="cuongv">
	<meta name="robots" content="index, follow">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
			
	<!-- CSS styles -->
	<link rel='stylesheet' type='text/css' href='asset/theme/blue_strap/css/bootstrap.min.css'>
	<link rel='stylesheet' type='text/css' href='asset/theme/blue_strap/css/bootstrap-responsive.min.css'>
	<link rel='stylesheet' type='text/css' href='asset/theme/blue_strap/css/main.css'>
	
	<!-- JS Libs -->
	<script src="asset/theme/blue_strap/js/jquery.js"></script>
	<script src="asset/theme/blue_strap/js/bootstrap.min.js"></script>
	<script src="asset/theme/blue_strap/js/bootstrap-carousel.js"></script>
<script src="asset/theme/blue_strap/js/redactor/jquery-1.7.min.js" type="text/javascript"></script>

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
				<!--<ul class="nav pull-left">
                            <li><a href="index.php"><i class="icon-home"></i> HOME</a></li>
					<li><a href="?page=data_uji"><i class="icon-user"></i> DATA UJI</a></li>
					</ul>
					-->
				</div>
			</div>		
		</div>		
          
		<div class="container-fluid content-body" style="padding-top:20px;">
        <?php //require("includes/bukaprogram.php"); ?>
         <?php if(!isset($_POST["nama"])){?>
			<form action="" class='search_top_form' method="post" accept-charset="utf-8">					
				<div class="row-fluid">	
					<div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-user"></i>
								</span>
								<input id="nama" class="span9" type="text" name="nama" placeholder="Masukkan Nama" value=""  required />
							</div>
						</div>
					</div>
                    	<div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<input id="nim" class="span9" type="text" name="nim" placeholder="Masukkan NIM" value=""  required />
							</div>
						</div>
					</div>
                    </div>
                    <div class="row-fluid">
					<div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="Angkatan">
                                    <option value="" selected="selected">Angkatan</option>
                                    <?php for($x=2010;$x<=2020;$x++){?>
                                    <option value="<?php echo $x;?>"><?php echo $x;?></option>
                                    <?php }?>
                                 
                                </select>							
                             </div>
						</div>
					</div>
                    <div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="JenisKelamin">
                                    <option value="" selected="selected">Jenis Kelamin</option>
                                     <option value="Perempuan">Perempuan</option>
                                    <option value="Laki-laki">Laki-laki</option>
                                </select>	
                             </div>
						</div>
					</div>
                    <div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="IPK">
                                    <option value="" selected="selected">IPK</option>
                                    <?php
										$query="SELECT * FROM ket_ipk ";
										$result= $mysqli->query($query);
										while($data=$result->fetch_assoc()){
									echo "	
                                    <option value=".$data[IDIPK].">".$data[KetIPK]."</option>
									";
										}
										?>
                                </select>
                            </div>
						</div>
					</div>
                    
                    </div>
                    <div class="row-fluid">	
                    <div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="NilaiIKH413">
                                    <option value="" selected="selected">Nilai IKH413</option>
                                     <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($data=$result->fetch_assoc()){
									echo "	
                                    <option value=".$data[IDNilai].">".$data[KetNilai]."</option>
									";
										}
										?>
                                </select>
                           </div>
						</div>
					</div>
                    <div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="NilaiIKL435">
                                    <option value="" selected="selected">Nilai IKL435</option>
                                    <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($data=$result->fetch_assoc()){
									echo "	
                                    <option value=".$data[IDNilai].">".$data[KetNilai]."</option>
									";
										}
										?>
                                </select>
                            </div>
						</div>
					</div>
                    
					<div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="NilaiIUM462">
                                    <option value="" selected="selected">Nilai IUM462</option>
                                     <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($data=$result->fetch_assoc()){
									echo "	
                                    <option value=".$data[IDNilai].">".$data[KetNilai]."</option>
									";
										}
										?>
                            	</select>
                             </div>
						</div>
					</div>
                    </div>
                    <div class="row-fluid">	
					<div class="span3">
						<button class="btn btn-info" type="submit" name="proses"><i class="icon-pencil icon-white"></i> <strong>PROSES</strong></button>
                        <a href="index.php" class="btn btn-danger "><i class="icon-refresh icon-white"></i> <strong>RESET</strong></a>

					</div>
                    <div class="span3">
					</div>
				</div>
			</form>		</div><div class="container-fluid content-body">
            <div class="row-fluid">
				<div class="span12">
					<div class="main_content">
                   
						<h3 class="title"><span class="pull-left"><i class="icon-briefcase"></i> Keterangan</span><span class="pull-right"></span></h3>
						<div class="container-fluid">
                         <div class="span6">
                            <h3><strong>IPK</strong></h3>
                            <ul>
                            <li> >= 3.00 = Sangat Baik</li>
                            <li> 2.0 - 2.99 = Baik</li>
                            <li>1.00 - 1.99 = Cukup</li>
                            <li> <= 0.99 = Tidak Baik </li>
                            </ul>
                       </div>
                       <div class="span6">
                            <h3><strong>NILAI</strong></h3>
                            <ul>
                            <li>A, A-, B+, B = Sangat Baik</li>
                            <li>B-, C+, C = Baik</li>
                            <li>D = Cukup</li>
                            <li>E, MG, NR, IN, FR = Tidak Baik</li>
                            </ul>
						</div>
						</div>
						
						
				</div>	
                </div>		
                		
		</div>
          <?php }else{?>
			<div class="row-fluid">
				<div class="span12">
					<div class="main_content">
						<h3 class="title"><span class="pull-left"><i class="icon-briefcase"></i> HASIL</span></h3>
						<div class="container-fluid content-body">
                          <?php 
	  $Angkatan = $_POST['Angkatan'];
	  $JenisKelamin = $_POST['JenisKelamin'];
	  $IPK = $_POST['IPK'];
	  $NilaiIKH413 = $_POST['NilaiIKH413'];
	  $NilaiIKL435 = $_POST['NilaiIKL435'];
	  $NilaiIUM462 = $_POST['NilaiIUM462'];
	  $Konsentrasi = $_POST['Konsentrasi'];
	   if($Angkatan=="" || $JenisKelamin=="" || $IPK=="" || $NilaiIUM462=="" || $NilaiIKL435=="" || $NilaiIKH413==""){
echo "<script>alert('Data Harus Diisi Semua');document.location.href='index.php';</script>";
	  }else{
	  ?>
						<h4>Nama : <?php echo $_POST["nama"];?><br>
                        NIM : <?php echo $_POST["nim"];?><br>

</h4>
<hr>
    
<?php
$query=$mysqli->query("TRUNCATE temp_hasil");

//hitung probabilitas Kemunculan dari Kesimpulan
$sql2="select count(KodeTraining) as total from data_mahasiswa";
$result= $mysqli->query($sql2);
$lRow2=$result->fetch_assoc();
$total=$lRow2['total'];

//$total=$total-1;
$total=$total;
$kategori="";
$tertinggi=0;
$nilaiM =4;
$jumTotal="";


 $sql="select * from ket_konsentrasi";
$result= $mysqli->query($sql);
$no=0;
while($lRow=$result->fetch_assoc()){
	$no++;
$sql2="select count(KodeTraining) as total from data_mahasiswa where Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result2= $mysqli->query($sql2);
$lRow2=$result2->fetch_assoc();
$totalkat=$lRow2['total'];
$n=$totalkat;
$nilai=$n/$total;//hitung probabilitas konsentrasi, banyaknya data konsentrasi RPL/total data
 
//Hitung Angkatan
$sql4="select count(KodeTraining) as total from data_mahasiswa where Angkatan='". $Angkatan ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result4= $mysqli->query($sql4);
$lRow4=$result4->fetch_assoc();
$jumlahAng=$lRow4['total'];
$ncAng=$jumlahAng;


$sql4xx="select distinct(Angkatan) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PAngxx=$result4xx->num_rows;

$PAng=1/$PAngxx;
$mp=$ncAng+($nilaiM*$PAng);
$mp2=$n+$nilaiM;
$PBAng=$mp/$mp2;

//Hitung JenisKelamin
$sql5="select count(KodeTraining) as total from data_mahasiswa where JenisKelamin='". $JenisKelamin ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result5= $mysqli->query($sql5);
$lRow5=$result5->fetch_assoc();
$jumlahJK=$lRow5['total'];
$ncJK=$jumlahJK;


$sql4xx="select distinct(JenisKelamin) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PJKxx=$result4xx->num_rows;

$PJK=1/2;
$mp=$ncJK+($nilaiM*$PJK);
$mp2=$n+$nilaiM;
$PBJK=$mp/$mp2;


//HITUNG IPK
$sql6="select count(KodeTraining) as total from data_mahasiswa where IPK='". $IPK ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result6= $mysqli->query($sql6);
$lRow6=$result6->fetch_assoc();
$jumlahIPK=$lRow6['total'];
$ncIPK=$jumlahIPK;

$sql4xx="select distinct(IPK) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PIPKxx=$result4xx->num_rows;

$PIPK=1/4;
$mp=$ncIPK+($nilaiM*$PIPK);
$mp2=$n+$nilaiM;
$PBIPK=$mp/$mp2;



//Hitung nilaiIKH413
$sql7="select count(KodeTraining) as total from data_mahasiswa where NilaiIKH413='". $NilaiIKH413 ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result7= $mysqli->query($sql7);
$lRow7=$result7->fetch_assoc();
$jumlahIKH=$lRow7['total'];
$ncNilaiIKH413=$jumlahIKH;

$sql4xx="select distinct(NilaiIKH413) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PNilaiIKH413xx=$result4xx->num_rows;

$PNilaiIKH413=1/4;
$mp=$ncNilaiIKH413+($nilaiM*$PNilaiIKH413);
$mp2=$n+$nilaiM;
$PBNilaiIKH413=$mp/$mp2;


/*
$NilaiIUM462='Barik';
*/
$sql8="select count(KodeTraining) as total from data_mahasiswa where NilaiIKL435='". $NilaiIKL435 ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result8= $mysqli->query($sql8);
$lRow8=$result8->fetch_assoc();
$jumlahIKL=$lRow8['total'];

$ncNilaiIKL435=$jumlahIKL;
$sql4xx="select distinct(NilaiIKL435) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PNilaiIKL435xx=$result4xx->num_rows;

$PNilaiIKL435=1/4;
$mp=$ncNilaiIKL435+($nilaiM*$PNilaiIKL435);
$mp2=$n+$nilaiM;
$PBNilaiIKL435=$mp/$mp2;



//Hitung NilaiIUM462
$sql9="select count(KodeTraining) as total from data_mahasiswa where NilaiIUM462='". $NilaiIUM462 ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result9= $mysqli->query($sql9);
$lRow9=$result9->fetch_assoc();
$jumlahIUM=$lRow9['total'];
$nilaiIUM=($nilaiM*$jumlahIUM)/($totalkat+$nilaiM);

$ncNilaiIUM462=$jumlahIUM;
$sql4xx="select distinct(NilaiIUM462) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PNilaiIUM462xx=$result4xx->num_rows;

$PNilaiIUM462=1/4;
$mp=$ncNilaiIUM462+($nilaiM*$PNilaiIUM462);
$mp2=$n+$nilaiM;
$PBNilaiIUM462=$mp/$mp2;



$jumTotal=$nilai*$PBAng*$PBJK*$PBIPK*$PBNilaiIKH413*$PBNilaiIKL435*$PBNilaiIUM462;
//$jumTotal=round($jumTotal,6);
			$query=$mysqli->query("INSERT INTO temp_hasil (`konsentrasi`,`nilai`) VALUES ('".$lRow["IDKonsentrasi"]."','$jumTotal')");}


?>
<h2>Urutan Rekomendasi Konsentrasi Untuk Anda</h2>
<table class="table table-bordered table-striped table-condensed flip-content" id="mytable">
							<thead class="flip-content">
                <tr>
                    <th width="80px">No</th>
		
		    <th>Konsentrasi</th>
                </tr>
            </thead>
	    <tbody>
            <?php
            $start = 0;
			 $query="SELECT * FROM temp_hasil order by `nilai` desc ";
		$result= $mysqli->query($query);
		while($data=$result->fetch_assoc())
		 {
                ?>
                <tr>
		    <td><?php echo ++$start ?></td>

		    <td><?php echo getName('ket_konsentrasi','IDKonsentrasi',$data["konsentrasi"],'KetKonsentrasi'); ?></td>
		  
	        </tr>
                <?php
            }
            ?>
            </tbody>
        </table>

                        </h3><br>

					 <a href="index.php" class="btn btn-success "><i class="icon-refresh icon-white"></i> <strong> Coba Lagi</strong></a>

						</div>
						
						
				</div>	
                </div>		
                		
		</div>
        <?php }//if cek kosong
        }?>
        
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