
function jian(){
	var count = parseInt(document.getElementById("count").value);
	if(count>0){
		count--;
	}
	if(count==0){
		count=1;
	}
	document.getElementById("count").value = count;
}
function jia(){
	var count = parseInt(document.getElementById("count").value);
	var stock = parseInt(document.getElementById("stock").innerHTML);
	if(count<stock){
		count++;
	}
	document.getElementById("count").value = count;
}

function checkcount(){
	var count = parseInt(document.getElementById("count").value);
	var stock = parseInt(document.getElementById("stock").innerHTML);
	if(count>stock){
		alert('库存不足');
		document.getElementById("count").value = stock;
	}
	if(count==0){
		alert('购买数量不能小于1哦');
		document.getElementById("count").value = 1;
	}
	if(count<0){
		alert('数量非法');
		document.getElementById("count").value = 1;
	}
}

/*加入购物车*/
function shopAdd2(idd){
	var id = idd;
	var count = parseInt(document.getElementById("count").value);
	location.href='AddShopCarServlet?id='+id+'&count='+count;
}

function jia1(id,count,stock){ 
	var va=count
	if(va>=stock){
		alert('库存不足');
	}else{
	location.href="UpdateCarServlet?carid="+id+"&action=jia";
	}
	
}
function jian1(id,count){
	var va=count;
	if(va<2){
		alert('数量不能小于1');
	}else{
	location.href="UpdateCarServlet?carid="+id+"&action=jian";}
	
	
}
function closeText(id,stock){
	var va=document.getElementById(id).value;
	if(va<1){
	alert('您输入的数量不能小于1！！！')
		document.getElementById(id).value=1;
		va=1;
	}
	if(va>=stock){
	alert('您输入的数量超出库存！！！');
		document.getElementById(id).value=stock;
		va=stock;
	}
	location.href="UpdateCarServlet?carid="+id+"&getvalue="+va+"&action=closeText";
}
function del(id){ 
if(confirm("确定要删除吗？")) {
	location.href="UpdateCarServlet?carid="+id+"&action=delText";
	}
}
function delco(id){ 
	if(confirm("确定要删除吗？")) {
		location.href="DeleteCommentServlet?coid="+id;
		}
	}


var fxi=0;

function qxcheck(){ 

	var op2 = document.getElementsByName("op2");
	var op =  document.getElementsByName("op");
	
	if(fxi==0){
		for(var i=0;i<op.length;i++)
		{
			op[i].checked=true;
		}
		fxi=1;
	}else{
		for(var i=0;i<op.length;i++)
		{
			op[i].checked=false;
		}
		fxi=0;
	}
	
	dxcheck();
}

function dxcheck(){ 
var sum=0;
	var op = document.getElementsByName("op");
	var price=document.getElementsByName("priceText");
	var number=document.getElementsByName("procount");
	for(var i=0;i<op.length;i++)
	{
		if(op[i].checked)
		{
			sum+=parseInt(parseInt(price[i].innerText)*parseInt(number[i].value));
		}
	}
		
	document.getElementById("zdzj").innerHTML=sum;	//总价钱
	document.getElementById("jstext").value=sum; //总价钱
	var money=document.getElementById("zdzj").innerText;
	if(money=="0"){
		document.getElementById("jsbutton").style.display='none';//结算按钮
		document.getElementById("xzText").hidden=false;//请选择
	}else{
		document.getElementById("xzText").hidden=true;
		document.getElementById("jsbutton").style.display='inline';
	}
}

