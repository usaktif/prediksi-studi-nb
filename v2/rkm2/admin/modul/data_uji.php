<div class="row-fluid">
    <div class="span12">
        <div class="main_content">
            <h3 class="title"><span class="pull-left"><i class="icon-briefcase"></i> DATA UJI</span><span class="pull-right"></span></h3>
          <div class="container-fluid">
			<?php
// proses hapus data
if (isset($_GET['aksi'])) {
    if ($_GET['aksi'] == 'hapus') {
        // baca ID dari parameter ID  yang akan dihapus
		$id = $_GET['id'];
        // proses hapus data berdasarkan ID
        $sql=$mysqli->query("DELETE FROM data_uji WHERE `KodeUji`= '$id'");
		echo "<script>document.location='?page=data_uji';</script>";
	 } elseif ($_GET['aksi'] == 'tambah' || $_GET['aksi'] == 'edit') {
		 $id = $_GET['id'];
		if($id==''){$button="Save";}else{$button='Update';}
		 $query="SELECT * FROM data_uji WHERE `KodeUji`= '$id'";
		$result= $mysqli->query($query);
		$data=$result->fetch_assoc();
		?>


       
  

<?php } elseif ($_GET['aksi'] == 'prosesSubmit') {
?>
<div class="row-fluid">
				<div class="span12">
					<div class="main_content">
						<h3 class="title"><span class="pull-left"><i class="icon-briefcase"></i> HASIL</span><span class="pull-right"></span></h3>
						<div class="container-fluid">
						<h4>
                        <?php
						$Angkatan = $_POST['Angkatan'];
	  $JenisKelamin = $_POST['JenisKelamin'];
	  $IPK = $_POST['IPK'];
	  $NilaiIKB411 = $_POST['NilaiIKB411'];
	  $NilaiIUM462 = $_POST['NilaiIUM462'];
	  $NilaiIKL435 = $_POST['NilaiIKL435'];
	  $NilaiUBA403 = $_POST['NilaiUBA403'];
	  $NilaiIKH413 = $_POST['NilaiIKH413'];
	  $NilaiIKH451 = $_POST['NilaiIKH451'];

	  $Konsentrasi = $_POST['Konsentrasi'];
	   if($Angkatan=="" || $JenisKelamin=="" || $IPK=="" || $NilaiIUM462=="" || $NilaiIKL435=="" || $NilaiIKH413=="" || $Konsentrasi=="" || $NilaiIKH451=="" || $NilaiUBA403=="" || $NilaiIKB411==""){
echo "<script>alert('Data Harus Diisi Semua');document.location.href='?page=data_uji';</script>";
	  }else{
	  ?>
               <h4>
               
                        Angkatan : <?php echo $Angkatan;?><br />
Jenis Kelamin : <?php echo $JenisKelamin;?><br />
IPK : <?php echo getName('ket_ipk','IDIPK',$IPK,'KetIPK');?><br />
Nilai IKH423: <?php echo getName('ket_nilai','IDNilai',$NilaiIKH413,'KetNilai');?><br />
Nilai IKL435: <?php echo getName('ket_nilai','IDNilai',$NilaiIKL435,'KetNilai');?><br />
Nilai IUM462: <?php echo getName('ket_nilai','IDNilai',$NilaiIUM462,'KetNilai');?><br />

Nilai IKB411: <?php echo getName('ket_nilai','IDNilai',$NilaiIKB411,'KetNilai');?><br />
Nilai UBA403: <?php echo getName('ket_nilai','IDNilai',$NilaiUBA403,'KetNilai');?><br />
Nilai IKH451: <?php echo getName('ket_nilai','IDNilai',$NilaiIKH451,'KetNilai');?><br />
Konsentrasi: <?php echo getName('ket_konsentrasi','IDKonsentrasi',$Konsentrasi,'KetKonsentrasi');?><br />

</h4>
<hr>


<?php

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
$jumarr=array();
echo "<strong> Jumlah Data $total</strong><hr>
<ol>
";

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
$nilai=$n/$total;
echo "<b> <li> ". getName('ket_konsentrasi','IDKonsentrasi',$lRow["IDKonsentrasi"],'KetKonsentrasi') ."</b><br> ";
echo "PRPL ". getName('ket_konsentrasi','IDKonsentrasi',$lRow["IDKonsentrasi"],'KetKonsentrasi') ."=".$nilai."<br>";
echo "N ". getName('ket_konsentrasi','IDKonsentrasi',$lRow["IDKonsentrasi"],'KetKonsentrasi') ."=".$n."<br>";


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
echo "Pertanyaan Angkatan = <b>". $Angkatan ."</b><br>";
echo "NC =".$ncAng."<br>";
echo "P =".$PAng."<br>";
echo "Probabilitas (<b>$Angkatan | ". $lRow['KetKonsentrasi'] .") = ".$PBAng."</b><br>";

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
echo "Pertanyaan Jenis Kelamin = <b>". $JenisKelamin ."</b><br>";
echo "NC =".$ncJK."<br>";
echo "P =".$PJK."<br>";
echo "Probabilitas (<b>$JenisKelamin | ". $lRow['KetKonsentrasi'] .") = ".$PBJK."</b><br>";

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
echo "Pertanyaan IPK = <b>". $IPK ."</b><br>";
echo "NC =".$ncIPK."<br>";
echo "P =".$PIPK."<br>";
echo "Probabilitas (<b>$IPK | ". $lRow['KetKonsentrasi'] .") = ".$PBIPK."</b><br>";
echo "<br>";
//============================================================================================================================================
//Hitung NilaiIKH413
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
echo "Pertanyaan NilaiIKH413 = <b>". $NilaiIKH413 ."</b><br>";
echo "NC =".$ncNilaiIKH413."<br>";
echo "P =".$PNilaiIKH413."<br>";
echo "Probabilitas (<b>$NilaiIKH413 | ". $lRow['KetKonsentrasi'] .") = ".$PBNilaiIKH413."</b><br>";
echo "<br>";
// Hitung NilaiIKL435
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
echo "Pertanyaan NilaiIKL435 = <b>". $NilaiIKL435 ."</b><br>";
echo "NC =".$ncNilaiIKL435."<br>";
echo "P =".$PNilaiIKL435."<br>";
echo "Probabilitas (<b>$NilaiIKL435 | ". $lRow['KetKonsentrasi'] .") = ".$PBNilaiIKL435."</b><br>";
echo "<br>";// Hitung NilaiIKL435

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
echo "Pertanyaan NilaiIUM462 = <b>". $NilaiIUM462 ."</b><br>";
echo "NC =".$ncNilaiIUM462."<br>";
echo "P =".$PNilaiIUM462."<br>";
echo "Probabilitas (<b>$NilaiIUM462 | ". $lRow['KetKonsentrasi'] .") = ".$PBNilaiIUM462."</b><br>";
echo "<br>";

//+++++++++++++++++
//Hitung NilaiIKB411
$sql7="select count(KodeTraining) as total from data_mahasiswa where NilaiIKB411='". $NilaiIKB411 ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result7= $mysqli->query($sql7);
$lRow7=$result7->fetch_assoc();
$jumlahIKH=$lRow7['total'];
$ncNilaiIKB411=$jumlahIKH;

$sql4xx="select distinct(NilaiIKB411) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PNilaiIKB411xx=$result4xx->num_rows;

$PNilaiIKB411=1/4;
$mp=$ncNilaiIKB411+($nilaiM*$PNilaiIKB411);
$mp2=$n+$nilaiM;
$PBNilaiIKB411=$mp/$mp2;
echo "Pertanyaan NilaiIKB411 = <b>". $NilaiIKB411 ."</b><br>";
echo "NC =".$ncNilaiIKB411."<br>";
echo "P =".$PNilaiIKB411."<br>";
echo "Probabilitas (<b>$NilaiIKB411 | ". $lRow['KetKonsentrasi'] .") = ".$PBNilaiIKB411."</b><br>";
echo "<br>";
// Hitung NilaiUBA403
$sql8="select count(KodeTraining) as total from data_mahasiswa where NilaiUBA403='". $NilaiUBA403 ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result8= $mysqli->query($sql8);
$lRow8=$result8->fetch_assoc();
$jumlahIKL=$lRow8['total'];

$ncNilaiUBA403=$jumlahIKL;
$sql4xx="select distinct(NilaiUBA403) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PNilaiUBA403xx=$result4xx->num_rows;

$PNilaiUBA403=1/4;
$mp=$ncNilaiUBA403+($nilaiM*$PNilaiUBA403);
$mp2=$n+$nilaiM;
$PBNilaiUBA403=$mp/$mp2;
echo "Pertanyaan NilaiUBA403 = <b>". $NilaiUBA403 ."</b><br>";
echo "NC =".$ncNilaiUBA403."<br>";
echo "P =".$PNilaiUBA403."<br>";
echo "Probabilitas (<b>$NilaiUBA403 | ". $lRow['KetKonsentrasi'] .") = ".$PBNilaiUBA403."</b><br>";
echo "<br>";

//Hitung NilaiIKH451
$sql9="select count(KodeTraining) as total from data_mahasiswa where NilaiIKH451='". $NilaiIKH451 ."' and Konsentrasi='". $lRow['IDKonsentrasi'] ."'";
$result9= $mysqli->query($sql9);
$lRow9=$result9->fetch_assoc();
$jumlahIUM=$lRow9['total'];
$nilaiIUM=($nilaiM*$jumlahIUM)/($totalkat+$nilaiM);

$ncNilaiIKH451=$jumlahIUM;
$sql4xx="select distinct(NilaiIKH451) from data_mahasiswa";
$result4xx= $mysqli->query($sql4xx);
$PNilaiIKH451xx=$result4xx->num_rows;

$PNilaiIKH451=1/4;
$mp=$ncNilaiIKH451+($nilaiM*$PNilaiIKH451);
$mp2=$n+$nilaiM;
$PBNilaiIKH451=$mp/$mp2;
echo "Pertanyaan NilaiIKH451 = <b>". $NilaiIKH451 ."</b><br>";
echo "NC =".$ncNilaiIKH451."<br>";
echo "P =".$PNilaiIKH451."<br>";
echo "Probabilitas (<b>$NilaiIKH451 | ". $lRow['KetKonsentrasi'] .") = ".$PBNilaiIKH451."</b><br>";
echo "<br>";

//===============================================================================================================================

$jumTotal=$nilai*$PBAng*$PBJK*$PBIPK*$PBNilaiIKH413*$PBNilaiIKL435*$PBNilaiIUM462 *$PBNilaiIKB411*$PBNilaiUBA403*$PBNilaiIKH451;
$totalx=$totalx+$jumTotal+0;
$jumarr[$no]=$jumTotal;
//$jumTotal=round($jumTotal,6);
echo "<b>Jumlah Total Untuk ". getName('ket_konsentrasi','IDKonsentrasi',$lRow["IDKonsentrasi"],'KetKonsentrasi') ."= $jumTotal </b><br><hr color='#FF0000'>";
//echo "P Angkatan= ". $nilai . "<br>";
      //kategori
	  //$alternatif=getName('ket_konsentrasi','IDKonsentrasi',$lRow["IDKonsentrasi"],'KetKonsentrasi');
	  	//$kriteria[]=array($alternatif,$jumTotal);

if($jumTotal>$tertinggi){
$tertinggi=$jumTotal;
$kategori=getName('ket_konsentrasi','IDKonsentrasi',$lRow["IDKonsentrasi"],'KetKonsentrasi');
$Konsentrasi=$lRow["IDKonsentrasi"];
}}
//echo $kriteria[0][0]. " Nilainya ". $kriteria[0][1];
$nNormal1=$jumarr[1]/$totalx;
$nNormal2=$jumarr[2]/$totalx;
$nNormal3=$jumarr[3]/$totalx;
$nArr=array();
$nArr=max(array($nNormal1,$nNormal2,$nNormal3));
echo "Total Probabilitas => ".$totalx;
echo "<hr><h3>NORMALISASI </h3>";
echo "<br><b><h5> Rekayasa Perangkat Lunak => ".$nNormal1;
echo " <br><b><h5> Grafika Komputer => ".$nNormal2;
echo "<br><b><h5> Keamanan Informasi => ".$nNormal3;
//echo $kriteria[0][0]. " Nilainya ". $kriteria[0][1];
echo "<h4><br><br><br> Nilai Tertinggi adalah <b>".  $kategori ."</b> Dengan Nilai = <b>".$nArr;
// $sql5="UPDATE dokumen set keyword='".  $kategori ."' where id=". $kode ." ";
//mysql_query($sql5,$con);
			$query=$mysqli->query("INSERT INTO data_uji (`KodeUji`,`Angkatan`,`JenisKelamin`,`IPK`,`NilaiIKB411`,`NilaiIUM462`,`NilaiIKL435`,`NilaiUBA403`,`NilaiIKH413`,`NilaiIKH451`,`Konsentrasi`,`Hasil`) VALUES ('$KodeUji','$Angkatan','$JenisKelamin','$IPK','$NilaiIKB411','$NilaiIUM462','$NilaiIKL435','$NilaiUBA403','$NilaiIKH413','$NilaiIKH451','$_POST[Konsentrasi]','$Konsentrasi')");
	
$query="SELECT * FROM data_uji order by KodeUji desc limit 1";
		$result= $mysqli->query($query);
		$data=$result->fetch_assoc();
echo '<br>  <a href="?page=data_uji&aksi=simpan&KodeUji='.$data['KodeUji'].'&Konsentrasi='.$Konsentrasi.'&Hasil='.$tertinggi.'" class="btn btn-primary "><i class="fa fa-save"></i> <span class="hidden-480">
								Simpan </span></a>
							<a href="?page=data_uji" class="btn btn-success "> <span class="hidden-480">
								<i class="icon-refresh icon-white"></i> <strong> Coba Lagi</strong> </span></a>';


 		
   }
}//if cek kosong
}else {// end aksi?>
	

              <div class="pull-right box-tools">
    
 </div><br /><br />
 
           
 <form action="?page=data_uji&aksi=prosesSubmit" method="post" class="form-horizontal">
				
                    <div class="row-fluid">
					<div class="span3">
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								 <select class="" name="Angkatan">
                                    <option value="" selected> Angkatan</option>
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
						<div class="control-group">
							<div class="input-prepend">
								<span class="add-on">
									<i class="icon-flag"></i>
								</span>
								<select class="" name="NilaiIKB411">
                                    <option value="" selected="selected">Nilai IKB411</option>
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
								<select class="" name="NilaiUBA403">
                                    <option value="" selected="selected">Nilai UBA403</option>
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
								<select class="" name="NilaiIKH451">
                                    <option value="" selected="selected">Nilai IKH451</option>
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
								 <select class="" name="Konsentrasi">
                                    <option value="" selected="selected">Konsentrasi</option>
                                     <?php
										$query="SELECT * FROM ket_konsentrasi ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDKonsentrasi].">".$datax[KetKonsentrasi]."</option>
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

					</div>
                    <div class="span3">
					</div>
				</div>
			</form>
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

						  <table width="1187" class="table table-bordered table-striped table-condensed flip-content" id="mytable">
							<thead class="flip-content">
                <tr>
                   
		           <th width="10px">No</th>
		    <th>Angkatan</th>
		    <th>Jenis Kelamin</th>
		    <th>IPK</th>
		    <th>Nilai IKB411</th>
		    <th>Nilai IUM462</th>
		    <th>Nilai IKL435</th>
		    <th>Nilai UBA403</th>
		    <th>Nilai IKH413</th>
		    <th>Nilai IKH451</th>
		    <th>Konsentrasi</th>
		    <th>Hasil</th>
		    <th>Action</th>
                </tr>
            </thead>
	    <tbody>
            <?php
            $start = 0;
			 $query="SELECT * FROM data_uji order by `KodeUji` asc ";
		$result= $mysqli->query($query);
		while($data_uji=$result->fetch_assoc())
		 {
                ?>
                <tr>
		    <td><?php echo ++$start ?></td>
		    <td><?php echo $data_uji["Angkatan"]; ?></td>
		    <td><?php echo $data_uji["JenisKelamin"]; ?></td>
		    <td><?php echo getName('ket_ipk','IDIPK',$data_uji["IPK"],'KetIPK'); ?></td>
		    
            <td><?php echo getName('ket_nilai','IDNilai',$data_uji["NilaiIKB411"],'KetNilai'); ?></td>
		    <td><?php echo getName('ket_nilai','IDNilai',$data_uji["NilaiIUM462"],'KetNilai'); ?></td>
            <td><?php echo getName('ket_nilai','IDNilai',$data_uji["NilaiIKL435"],'KetNilai'); ?></td>
            <td><?php echo getName('ket_nilai','IDNilai',$data_uji["NilaiUBA403"],'KetNilai'); ?></td>
            <td><?php echo getName('ket_nilai','IDNilai',$data_uji["NilaiIKH413"],'KetNilai'); ?></td>
            <td><?php echo getName('ket_nilai','IDNilai',$data_uji["NilaiIKH451"],'KetNilai'); ?></td>
		   <td><?php echo getName('ket_konsentrasi','IDKonsentrasi',$data_uji["Konsentrasi"],'KetKonsentrasi'); ?></td>
		   <td><?php echo getName('ket_konsentrasi','IDKonsentrasi',$data_uji["Hasil"],'KetKonsentrasi'); ?></td>

		    <td style="text-align:center" width="150">
<a href="?page=data_uji&aksi=hapus&id=<?php echo $data_uji["KodeUji"];?>" class="btn btn-danger btn-xs purple" onclick="javasciprt: return confirm('Are You Sure ?')" data-toggle="tooltip" title="Hapus Data"><i class="fa fa-trash-o"></i> Delete</a>
              
		    </td>
	        </tr>
                <?php
            }
            ?>
            </tbody>
        </table>
	
      <?php }?> 
        </div>
    </div>	
    	</div>		
                		
</div>
<?php if($_GET["aksi"]=="simpan"){
    	 $query="SELECT * FROM data_uji WHERE `KodeUji`= '$_GET[KodeUji]'";
		 $result= $mysqli->query($query);
		$data=$result->fetch_assoc();
			  $Angkatan = $data['Angkatan'];
	  $JenisKelamin = $data['JenisKelamin'];
	  $IPK = $data['IPK'];
	  $NilaiIKB411 = $data['NilaiIKB411'];
	  $NilaiIUM462 = $data['NilaiIUM462'];
	  $NilaiIKL435 = $data['NilaiIKL435'];
	  $NilaiUBA403 = $data['NilaiUBA403'];
	  $NilaiUBN400 = $data['NilaiUBN400'];
	  $NilaiIKH413 = $data['NilaiIKH413'];
	  $NilaiIKH451 = $data['NilaiIKH451'];
	  $NilaiUKT102 = $data['NilaiUKT102'];
	  $Konsentrasi = $data['Konsentrasi'];
			$query=$mysqli->query("INSERT INTO data_mahasiswa (`KodeTraining`,`Angkatan`,`JenisKelamin`,`IPK`,`NilaiIKB411`,`NilaiIUM462`,`NilaiIKL435`,`NilaiUBA403`,`NilaiIKH413`,`NilaiIKH451`,`Konsentrasi`) VALUES ('$KodeTraining','$Angkatan','$JenisKelamin','$IPK','$NilaiIKB411','$NilaiIUM462','$NilaiIKL435','$NilaiUBA403','$NilaiIKH413','$NilaiIKH451','$Konsentrasi')");
				 		echo "<script>document.location='?page=data_uji';</script>";

}
?>