<?php
$conn="";
$trainA="mugalsarai";//$_REQUEST['trainA'];
$trainB="dehradun";//$_REQUEST['trainB'];
$conn=mysqli_connect("localhost","root","","indianrailways");


$ssid=" ";


function cidfinder($con,$train)
{
$query="select cid from city where cname='$train'";

$run=mysqli_query($con,$query);
while($r=mysqli_fetch_array($run))
{
$sourcecid=$r[0];
}

return $sourcecid;
}







function cityFinder($co,$c)
{

$query="select cname from city where cid='$c'";
$ss="";
$run=mysqli_query($co,$query);
while($r=mysqli_fetch_array($run))
{
$ss=$r[0];

}

return $ss;


}




function infofinder($sourcid,$destcid,$conne)
{

$query="select * from traininfo where sourcecid='$sourcid' && destcid='$destcid'";
$ss="";$trname=" ";
$response['res']=array();
$run=mysqli_query($conne,$query);
while($r=mysqli_fetch_array($run))
{
$res=array();

$ss="$r[0]"."$r[1]"."$r[4]"."$r[5]"."$r[6]"."$r[7]";
$trname=$trname.$r[1];
$res['tname']=$r[1];
$res['tnumber']=$r[0];
$res['rdays']=$r[2];
$res['status']=$r[3];
$res['arrtime']=$r[4];
$res['dept']=$r[5];
array_push($response['res'],$res);
}
die(json_encode($response));
return $trname;





}






$sourcecid=cidfinder($conn,$trainB);


$destcid=cidFinder($conn,$trainA);


$sourcity=cityFinder($conn,$sourcecid);



$destcity=cityFinder($conn,$destcid);




$tinfo=infofinder($sourcecid,$destcid,$conn);


?>