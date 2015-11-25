
<?php
$username=$_REQUEST['train_number'];

$train__name="";
$train_number="";
$destcid=0;
$conn=mysqli_connect("localhost","root","","indianrailways");
if($conn)
{
$query="select * from traininfo where trainno='$username'";

$run=mysqli_query($conn,$query);
$response['res']=array();
while($r=mysqli_fetch_array($run))
{

$res=array();
$train_number=$r[0];
$train__name=$r[1];
$destcid=$r[3];
$sid=$r[2];
$rdays=$r[4];
$status=$r[5];
$arrtime=$r[6];
$depttime=$r[7];

$res['tnumber']=$train_number;
$res['rdays']=$rdays;
$res['status']=$status;
$res['arrtime']=$arrtime;
$res['depttime']=$depttime;
$query3="select cname from city where cid='$destcid'";
$run3=mysqli_query($conn,$query3);

while($r3=mysqli_fetch_array($run3))
{


$dest=$r3[0];

$res['dest']=$dest;
}






$query1="select cid from stations where sid='$sid'";
$run1=mysqli_query($conn,$query1);
while($r1=mysqli_fetch_array($run1))
{
$cid=$r1[0];

$query2="select cname from city where cid='$cid'";
$run2=mysqli_query($conn,$query2);

while($r2=mysqli_fetch_array($run2))
{
$city=$r2[0];
$res['source']=$city;
//

}
$res['tname']=$train__name;

}




array_push($response['res'],$res);
}

}

die(json_encode($response));




?>