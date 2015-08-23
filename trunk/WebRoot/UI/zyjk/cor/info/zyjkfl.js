var actionurl;
function formsubmit(){
 		
  		 if(!validator(document.forms[0])){
		        return;
		    }
  		var sysno=document.getElementById("sysno").value;
  		var zongfen=document.getElementById("zongfen").value;
  		var level="A";
  		if(sysno!=null&&sysno!=""&&sysno!="null"){
  		
  			if(zongfen>=85){
  				level="a";		
  			}else if(zongfen<85&&zongfen>=60){
  				level="b";
  			}else{
  				level="c";
  			}
  			var ches=document.getElementsByName("zyjkflfjBean.wsgldj");
  			for(var i=0;i<ches.length;i++){
  				if(ches[i].value==level){
  					//alert(ches[i].value);
  					ches[i].checked=true;
  				}
  			}
  			//document.getElementById("form1").action="<%=path %>/UI/action/zyjk/ZyjkflfjAction_update.action";
  		}else{
  			
  			if(zongfen>=85){
  				level="a";		
  			}else if(zongfen<85&&zongfen>=60){
  				level="b";
  			}else{
  				level="c";
  			}
  			var ches=document.getElementsByName("zyjkflfjBean.wsgldj");
  			for(var i=0;i<ches.length;i++){
  				if(ches[i].value==level){
  					//alert(ches[i].value);
  					ches[i].checked=true;
  				}
  			}
  			//document.getElementById("form1").action="<%=path %>/UI/action/zyjk/ZyjkflfjAction_insert.action";
  		}
  		var whlb=document.getElementsByName("zyjkflfjBean.whlb");
  		var whlbval;
  		var hdlevel="一";
  		for(var i=0;i<whlb.length;i++){
  				if(whlb[i].checked){
  					whlbval=whlb[i].value;
  				}
  			}
  		if(whlbval=="A"){
  			if(level=="a"){
  				hdlevel="2";
  			}else if(level=="b"){
  				hdlevel="3";
  			}else if(level=="c"){
  				hdlevel="4";
  			}
  		}else if(whlbval=="B"){
  			if(level=="a"){
  				hdlevel="1";
  			}else if(level=="b"){
  				hdlevel="2";
  			}else if(level=="c"){
  				hdlevel="3";
  			}
  		}	
  		//document.getElementById("jdgldj").value=hdlevel;
  		var jdches=document.getElementsByName("zyjkflfjBean.jdgldj");
  			for(var i=0;i<jdches.length;i++){
  				if(jdches[i].value==hdlevel){
  					//alert(jdches[i].value);
  					jdches[i].checked=true;
  				}
  			}
  		if(confirm("职业卫生管理等级为："+level+"监督管理等级为："+hdlevel+"级")){
  			//document.getElementById("form1").submit();
  			var method = $("#method").val();
  			actionurl=webpath+"/UI/action/zyjk/ZyjkflfjAction_insert.action";
  			if(method=="add"){
              actionurl=webpath+"/UI/action/zyjk/ZyjkflfjAction_insert.action";
            }else if(method=="look"){
			  $("#subButton").hide();
			  $("#colButton").hide();
			}else if(method=="update"){
			   actionurl=webpath+"/UI/action/zyjk/ZyjkflfjAction_update.action";
			} 
			$.post(actionurl,$("form:first").serialize(),function(data){
		      if(data.checkFlag==MSG_SUCCESS)
			  {
			      
			       $.ligerDialog.success(data.checkMessage);
			   }else{
			       	$.ligerDialog.error(data.checkMessage);
			   }
				},"json").error(function() { 
					$.ligerDialog.error(MSG_LOAD_FALL);
				});
  		}
  		
  	}

function getCompare(data){
	var state=false;
	var datas=['N-甲基苯胺',
			   'N-异丙基苯胺',
			   '氨气',
			   '苯',
			   '苯胺',
			   '丙烯酰胺',
			   '丙烯腈',
			   '对硝基苯胺',
			   '对硝基氯苯/二硝基氯苯',
			   '二苯胺',
			   '二甲基苯胺',
			   '二硫化碳',
			   '二氯代乙炔',
			   '二硝基苯(全部异构体)',
			   '二硝基甲苯',
			   '二氧化氮',
			   '甲苯-2',
			   '4-二异氰酸酯',
			   '氟化氢',
			   '氟及其化合物(不含氟化氢)',
			   '镉及其化合物',
			   '铬及其化合物',
			   '汞及其化合物',
			   '碳酰氯（光气）',
			   '黄磷',
			   '肼类化合物（含肼）',
			   '甲醛',
			   '焦炉逸散物',
			   '镍及其化物（不含羰基镍）',
			   '磷化氢（膦）',
			   '硫化氢',
			   '硫酸二甲酯',
			   '氯化萘',
			   '氯甲醚',
			   '氯气',
			   '氯乙烯',
			   '锰及其化合物',
			   '铍及其化合物',
			   '铅及其化合物（不含四乙基铅）',
			   '氰化氢',
			   '氰化钠、氰化钾',
			   '三硝基甲苯',
			   '砷化三氢（胂）',
			   '砷及其化合物（不含砷化氢）',
			   '铊及其可溶性化合物',
			   '羰基镍',
			   '锑及其化合物',
			   '五氧化二钒烟尘',
			   '硝基苯',
			   '一氧化碳',
			   '石棉尘',
			   '矽尘',
			   '电离辐射（α、β、γ、χ射线等,包括放射性物质可能产生的各种射线）'];
	var comdatas=data.split(",");
	for(var i=0;i<comdatas.length;i++){
		if(contains(datas,comdatas[i])){
			state=true;
			return state;
			//break;
		}
	}	
	
	return state;  
}

function compareF(data){
	if(data<5){
			isWhlbChecked(true);
	}else{
		isWhlbChecked(false);
	}
}

function isWhlbChecked(isCheck){
//判断是否已经存在否定项，如果有，则选中
	var ches=document.getElementsByName("zyjkflfjBean.whlb");
	var whysmc=document.getElementById("whysmc").value;
	var jcrs=document.getElementById("jcrs").value;
	var doc17=document.getElementById("doc17").value;
	if(getCompare(whysmc)||jcrs>50||doc17<5){
		for(var i=0;i<ches.length;i++){
			if(ches[i].value=="A"){
				if(ches[i].checked){
					return ;
				}
			}
  		}
	}
	
	if(isCheck){
		for(var i=0;i<ches.length;i++){
			if(ches[i].value=="A"){
				if(ches[i].checked){
					return ;
				}else if(!ches[i].checked){
					ches[i].checked=true;
				}
			}else{
				ches[i].checked=false;
			}	
  		}
	}else{
		for(var i=0;i<ches.length;i++){
			if(ches[i].value=="B"){
				if(!ches[i].checked){
					ches[i].checked=true;
				}
			}else{
				ches[i].checked=false;
			}	
  		}
	}
	
}
//判断arr数组是否包含str字符串
function contains(arr, str) {
    var i = arr.length;
    while (i--) {
           if (arr[i] === str) {
           return true;
           }   
    }   
    return false;
}
//判断分数是否高于该项的上限
function compareFS(total,value,obj){
	if(value>total){
		alert("填入的分数不能大于该项"+total+"的上限！");
		obj.value="";
		obj.focus();
		return;
	}
}
//如果人数超过50，则为重点
 function compareRs(value){
 	if(value>=50){
			isWhlbChecked(true);
		}else{
			isWhlbChecked(false);
		}
 }


