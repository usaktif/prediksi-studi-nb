<div class="row-fluid">
    <div class="span12">
        <div class="main_content">
            <h3 class="title"><span class="pull-left"><i class="icon-briefcase"></i> DATA TRAINING</span><span class="pull-right"></span></h3>
            <div class="container-fluid">
			<?php
// proses hapus data
if (isset($_GET['aksi'])) {
    if ($_GET['aksi'] == 'hapus') {
        // baca ID dari parameter ID  yang akan dihapus
		$id = $_GET['id'];
        // proses hapus data berdasarkan ID
        $sql=$mysqli->query("DELETE FROM data_mahasiswa WHERE `KodeTraining`= '$id'");
		echo "<script>document.location='?page=data_mahasiswa';</script>";
	 } elseif ($_GET['aksi'] == 'tambah' || $_GET['aksi'] == 'edit') {
		 $id = $_GET['id'];
		if($id==''){$button="Save";}else{$button='Update';}
		 $query="SELECT * FROM data_mahasiswa WHERE `KodeTraining`= '$id'";
		$result= $mysqli->query($query);
		$data=$result->fetch_assoc();
		?>


        <form action="?page=data_mahasiswa&aksi=prosesSubmit" method="post" class="form-horizontal">
		 <div class="form-body">
	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Angkatan </label>
          <div class="span4"> 
           <select class="" name="Angkatan">
                                    <option value="<?php echo $data["Angkatan"]; ?>"><?php echo $data["Angkatan"]; ?></option>
                                    <?php for($x=2010;$x<=2020;$x++){?>
                                    <option value="<?php echo $x;?>"><?php echo $x;?></option>
                                    <?php }?>
                                 
                                </select>	
        </div>
		</div>
	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Jenis Kelamin </label>
          <div class="span4"> 
          <select class="" name="JenisKelamin">
                                    <option value="<?php echo $data["JenisKelamin"]; ?>"><?php echo $data["JenisKelamin"]; ?></option>
                                    <option value="Perempuan">Perempuan</option>
                                    <option value="Laki-laki">Laki-laki</option>
                                </select>	
        </div>
		</div>
	    <div class="control-group">
            <label for="varchar" class="span3 control-label">IPK </label>
          <div class="span4"> 
									<select class="" name="IPK">
                                    <option value="<?php echo $data["IPK"]; ?>"><?php echo getName('ket_ipk','IDIPK',$data["IPK"],'KetIPK'); ?></option>
                                    <?php
										$query="SELECT * FROM ket_ipk ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDIPK].">".$datax[KetIPK]."</option>
									";
										}
										?>
                                </select>        </div>
		</div>
        
          <div class="control-group">
            <label for="varchar" class="span3 control-label">Nilai IKH413 </label>
          <div class="span4"> 
  <select class="" name="NilaiIKH413">
                                    <option value="<?php echo $data["NilaiIKH413"]; ?>"><?php echo getName('ket_nilai','IDNilai',$data["NilaiIKH413"],'KetNilai'); ?></option>
                                    <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDNilai].">".$datax[KetNilai]."</option>
									";
										}
										?>
                </select>        </div>
		</div>
        	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Nilai IKL435 </label>
          <div class="span4"> 
 <select class="" name="NilaiIKL435">
                                    <option value="<?php echo $data["NilaiIKL435"]; ?>"><?php echo getName('ket_nilai','IDNilai',$data["NilaiIKL435"],'KetNilai'); ?></option>
                                    <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDNilai].">".$datax[KetNilai]."</option>
									";
										}
										?>
                </select>        </div>
		</div>
	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Nilai IUM462 </label>
          <div class="span4"> 
<select class="" name="NilaiIUM462">
                                    <option value="<?php echo $data["NilaiIUM462"]; ?>"><?php echo getName('ket_nilai','IDNilai',$data["NilaiIUM462"],'KetNilai'); ?></option>
                                     <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDNilai].">".$datax[KetNilai]."</option>
									";
										}
										?>
               	</select>        </div>
		</div>

	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Nilai IKB411 </label>
          <div class="span4"> 
            <select class="" name="NilaiIKB411">
                                    <option value="<?php echo $data["NilaiIKB411"]; ?>"><?php echo getName('ket_nilai','IDNilai',$data["NilaiIKB411"],'KetNilai'); ?></option>
                                     <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDNilai].">".$datax[KetNilai]."</option>
									";
										}
										?>
                                </select>
        </div>
		</div>
	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Nilai UBA403 </label>
          <div class="span4"> 
 <select class="" name="NilaiUBA403">
                                    <option value="<?php echo $data["NilaiUBA403"]; ?>"><?php echo getName('ket_nilai','IDNilai',$data["NilaiUBA403"],'KetNilai'); ?></option>
                                    <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDNilai].">".$datax[KetNilai]."</option>
									";
										}
										?>
                                </select>        </div>
		</div>

	  
	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Nilai IKH451 </label>
          <div class="span4"> 
  <select class="" name="NilaiIKH451">
                                    <option value="<?php echo $data["NilaiIKH451"]; ?>"><?php echo getName('ket_nilai','IDNilai',$data["NilaiIKH451"],'KetNilai'); ?></option>
                                    <?php
										$query="SELECT * FROM ket_nilai ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDNilai].">".$datax[KetNilai]."</option>
									";
										}
										?>
                </select>        </div>
		</div>

	    <div class="control-group">
            <label for="varchar" class="span3 control-label">Konsentrasi </label>
          <div class="span4"> 
 <select class="" name="Konsentrasi">
                                    <option value="<?php echo $data["Konsentrasi"]; ?>"><?php echo  getName('ket_konsentrasi','IDKonsentrasi',$data["Konsentrasi"],'KetKonsentrasi'); ?></option>
                                     <?php
										$query="SELECT * FROM ket_konsentrasi ";
										$result= $mysqli->query($query);
										while($datax=$result->fetch_assoc()){
									echo "	
                                    <option value=".$datax[IDKonsentrasi].">".$datax[KetKonsentrasi]."</option>
									";
										}
										?>
                            	</select>        </div>
		</div>
	   </div>
        			<div class="form-actions">
					<div class="row">
					<div class="col-md-offset-3 col-md-9">
	    <input type="hidden" name="KodeTraining" value="<?php echo $data["KodeTraining"]; ?>" /> 
	    <input type="hidden" name="statusTombol" value="<?php echo $button ?>" /> 
	    <button type="submit" class="btn btn-primary"><span class='glyphicon glyphicon-save'></span> <?php echo $button ?></button> 
	    <a class='btn btn-danger' onclick=self.history.back() ><span class='glyphicon glyphicon-arrow-left'></span> Kembali</a>
	</div>
				</div>
              </div>
			  </form>
  

<?php } elseif ($_GET['aksi'] == 'prosesSubmit') {
	   
	  $KodeTraining = $_POST['KodeTraining'];
	  $Angkatan = $_POST['Angkatan'];
	  $JenisKelamin = $_POST['JenisKelamin'];
	  $IPK = $_POST['IPK'];
	  $NilaiIKB411 = $_POST['NilaiIKB411'];
	  $NilaiIUM462 = $_POST['NilaiIUM462'];
	  $NilaiIKL435 = $_POST['NilaiIKL435'];
	  $NilaiUBA403 = $_POST['NilaiUBA403'];
	  $NilaiUBN400 = $_POST['NilaiUBN400'];
	  $NilaiIKH413 = $_POST['NilaiIKH413'];
	  $NilaiIKH451 = $_POST['NilaiIKH451'];
	  $NilaiUKT102 = $_POST['NilaiUKT102'];
	  $Konsentrasi = $_POST['Konsentrasi'];
	   if($Angkatan=="" || $JenisKelamin=="" || $IPK=="" || $NilaiIUM462=="" || $NilaiIKL435=="" || $NilaiIKH413=="" || $Konsentrasi=="" || $NilaiIKH451=="" || $NilaiUBA403=="" || $NilaiIKB411==""){
echo "<script>alert('Data Harus Diisi Semua');document.location.href='?page=data_mahasiswa&aksi=tambah';</script>";
	  }else{
	switch($_POST['statusTombol']) {
	case 'Save':
			$query=$mysqli->query("INSERT INTO data_mahasiswa (`KodeTraining`,`Angkatan`,`JenisKelamin`,`IPK`,`NilaiIKB411`,`NilaiIUM462`,`NilaiIKL435`,`NilaiUBA403`,`NilaiIKH413`,`NilaiIKH451`,`Konsentrasi`) VALUES ('$KodeTraining','$Angkatan','$JenisKelamin','$IPK','$NilaiIKB411','$NilaiIUM462','$NilaiIKL435','$NilaiUBA403','$NilaiIKH413','$NilaiIKH451','$Konsentrasi')");
	break;
	case 'Update':
			$query=$mysqli->query("UPDATE data_mahasiswa set `KodeTraining` = '$KodeTraining',`Angkatan` = '$Angkatan',`JenisKelamin` = '$JenisKelamin',`IPK` = '$IPK',`NilaiIKB411` = '$NilaiIKB411',`NilaiIUM462` = '$NilaiIUM462',`NilaiIKL435` = '$NilaiIKL435',`NilaiUBA403` = '$NilaiUBA403',`NilaiIKH413` = '$NilaiIKH413',`NilaiIKH451` = '$NilaiIKH451',`Konsentrasi` = '$Konsentrasi' WHERE KodeTraining='$KodeTraining'");
	break;
	}
 		echo "<script>document.location='?page=data_mahasiswa';</script>";
   }
}//if cek kosong
}else {// end aksi?>
	

           
 <form action="?page=data_mahasiswa" method="post" class="form-horizontal">
				
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
						<button class="btn btn-info" type="submit" name="proses"><i class="icon-pencil icon-white"></i> <strong>CARI</strong></button>

					</div>
                    <div class="span3">
					</div>
				</div>
			</form>
              <div class="pull-right box-tools">
             <a href="?page=data_mahasiswa&aksi=tambah" class="btn btn-primary "><i class="fa fa-plus"></i> <span class="hidden-480">
								Tambah Data </span></a> 
 </div><br />
           

							<table class="table table-bordered table-striped table-condensed flip-content" id="mytable">
							<thead class="flip-content">
                <tr>
                    <th width="10px">No</th>
		    <th>Angkatan</th>
		    <th>Jenis Kelamin</th>
		    <th>IPK</th>
		    <th>Nilai IKH413</th>
		    <th>Nilai IKL435</th>
		    <th>Nilai IUM462</th>
		    <th>Nilai IKB411</th>
		    <th>Nilai UBA403</th>
		
		    <th>Nilai IKH451</th>

		    <th>Konsentrasi</th>
		    <th>Action</th>
                </tr>
            </thead>
	    <tbody>
            <?php
				  $bagianWhere = "";

if (!empty($_POST['Angkatan']))
{
   $Angkatan = $_POST['Angkatan'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "Angkatan = '$Angkatan'";
   }
}

if ($_POST['JenisKelamin']!="")
{
   $JenisKelamin = $_POST['JenisKelamin'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "JenisKelamin = '$JenisKelamin'";
   }
   else
   {
        $bagianWhere .= " AND JenisKelamin = '$JenisKelamin'";
   }
}

if (!empty($_POST['IPK']))
{
   $IPK = $_POST['IPK'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "IPK = '$IPK'";
   }
   else
   {
        $bagianWhere .= " AND IPK = '$IPK'";
   }
}

if (!empty($_POST['NilaiIUM462']))
{
   $NilaiIUM462 = $_POST['NilaiIUM462'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "NilaiIUM462 = '$NilaiIUM462'";
   }
   else
   {
        $bagianWhere .= " AND NilaiIUM462 = '$NilaiIUM462'";
   }
}

if (!empty($_POST['NilaiIKL435']))
{
   $NilaiIKL435 = $_POST['NilaiIKL435'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "NilaiIKL435 = '$NilaiIKL435'";
   }
   else
   {
        $bagianWhere .= " AND NilaiIKL435 = '$NilaiIKL435'";
   }
}

if (!empty($_POST['NilaiIKH413']))
{
   $NilaiIKH413 = $_POST['NilaiIKH413'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "NilaiIKH413 = '$NilaiIKH413'";
   }
   else
   {
        $bagianWhere .= " AND NilaiIKH413 = '$NilaiIKH413'";
   }
}

if (!empty($_POST['NilaiIKB411']))
{
   $NilaiIKB411 = $_POST['NilaiIKB411'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "NilaiIKB411 = '$NilaiIKB411'";
   }
   else
   {
        $bagianWhere .= " AND NilaiIKB411 = '$NilaiIKB411'";
   }
}


if (!empty($_POST['NilaiUBA403']))
{
   $NilaiUBA403 = $_POST['NilaiUBA403'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "NilaiUBA403 = '$NilaiUBA403'";
   }
   else
   {
        $bagianWhere .= " AND NilaiUBA403 = '$NilaiUBA403'";
   }
}

if (!empty($_POST['NilaiIKH451']))
{
   $NilaiIKH451 = $_POST['NilaiIKH451'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "NilaiIKH451 = '$NilaiIKH451'";
   }
   else
   {
        $bagianWhere .= " AND NilaiIKH451 = '$NilaiIKH451'";
   }
}

if (!empty($_POST['Konsentrasi']))
{
   $Konsentrasi = $_POST['Konsentrasi'];
   if (empty($bagianWhere))
   {
        $bagianWhere .= "Konsentrasi = '$Konsentrasi'";
   }
   else
   {
        $bagianWhere .= " AND Konsentrasi = '$Konsentrasi'";
   }
}

            $start = 0;
			if($bagianWhere!=""){
						 $query="SELECT * FROM data_mahasiswa WHERE ".$bagianWhere." order by `KodeTraining` asc ";
	
			}else{
			 $query="SELECT * FROM data_mahasiswa order by `KodeTraining` asc ";
			}
			//echo $query;

		$result= $mysqli->query($query);
		while($data_mahasiswa=$result->fetch_assoc())
		 {
                ?>
                <tr>
		    <td><?php echo ++$start ?></td>
		    <td><?php echo $data_mahasiswa["Angkatan"]; ?></td>
		    <td><?php echo $data_mahasiswa["JenisKelamin"]; ?></td>
		    <td><?php echo getName('ket_ipk','IDIPK',$data_mahasiswa["IPK"],'KetIPK'); ?></td>
		    <td><?php echo getName('ket_nilai','IDNilai',$data_mahasiswa["NilaiIKH413"],'KetNilai'); ?></td>
		    <td><?php echo getName('ket_nilai','IDNilai',$data_mahasiswa["NilaiIKL435"],'KetNilai'); ?></td>
		    <td><?php echo getName('ket_nilai','IDNilai',$data_mahasiswa["NilaiIUM462"],'KetNilai'); ?></td>
		    
            <td><?php echo getName('ket_nilai','IDNilai',$data_mahasiswa["NilaiIKB411"],'KetNilai'); ?></td>
		    <td><?php echo getName('ket_nilai','IDNilai',$data_mahasiswa["NilaiUBA403"],'KetNilai'); ?></td>
         
            <td><?php echo getName('ket_nilai','IDNilai',$data_mahasiswa["NilaiIKH451"],'KetNilai'); ?></td>
          
		   <td><?php echo getName('ket_konsentrasi','IDKonsentrasi',$data_mahasiswa["Konsentrasi"],'KetKonsentrasi'); ?></td>

		    <td style="text-align:center" width="150px">
<a href="?page=data_mahasiswa&aksi=edit&id=<?php echo $data_mahasiswa["KodeTraining"];?>" class="btn btn-warning btn-xs purple" data-toggle="tooltip" title="Edit Data"><i class="fa fa-edit"></i> Edit</a> 
<a href="?page=data_mahasiswa&aksi=hapus&id=<?php echo $data_mahasiswa["KodeTraining"];?>" class="btn btn-danger btn-xs purple" onclick="javasciprt: return confirm('Are You Sure ?')" data-toggle="tooltip" title="Hapus Data"><i class="fa fa-trash-o"></i> Delete</a>
              
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