<!--
/*********************************************************************
 *<p>处理内容：WEB 平台</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.portal.action.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
<title>新一代安全生产综合监管系统</title>
<link href="<%=webpath%>/js/desktop/skins/desktop.css"  	            rel="stylesheet" type="text/css" />
<link href="<%=webpath%>/js/desktop/skins/jquery-ui-1.8.18.custom.css"  rel="stylesheet" type="text/css" />
<link href="<%=webpath%>/js/desktop/skins/smartMenu.css"  	            rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=webpath%>/js/desktop/myLib.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/desktop/jquery-ui-1.8.18.custom.min.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/desktop/jquery.winResize.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/desktop/jquery-smartMenu-min.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/desktop/desktop.js"></script>
<script type="text/javascript">
		
$(function(){
	myLib.progressBar();
});

var myWindow= null;
$.include(['', '', '']);
$(window).load(function(){
		   myLib.stopProgress();
		   var lrBarIconData={
			   'app0':{
					   'title':'WEB DESKTOP',
					   'url':'http://www.jsfoot.com/',
					   'winWidth':1100,
					   'winHeight':650
					   },
				'app1':{
					   'title':'jQuery特效',
					   'url':'http://www.jsfoot.com/jquery/',
					   'winWidth':1100,
					   'winHeight':650
					   },
				'app2':{
					   'title':'javascript特效',
					   'url':'http://www.jsfoot.com/js/',
					   'winWidth':1100,
					   'winHeight':650
					   },
				'app3':{
					   'title':'资源分享',
					   'url':'ziyuan.html',
					   'winWidth':1100,
					   'winHeight':650
					   }
					   };
		  var deskIconData={
			        'kuwoMusic':{
					   'title':'酷我音乐盒',
					   'url':'http://mbox.kuwo.cn/',
					   'winWidth':950,
					   'winHeight':500
						},
					'hudong':{
					   'title':'互动百科',
					   'url':'http://lab.hudong.com/webqq/index.html',
					   'winWidth':950,
					   'winHeight':500
						},
					'dubianFim':{
					   'title':'豆瓣FIM',
					   'url':'http://douban.fm/partner/qq_plus',
					   'winWidth':550,
					   'winHeight':480
						},
					'Pixlr':{
					   'title':'Pixlr',
					   'url':'http://pixlr.com/editor/?loc=zh-cn',
					   'winWidth':942,
					   'winHeight':547
						},
					'qidian':{
					   'title':'起点中文',
					   'url':'http://webqq.qidian.com',
					   'winWidth':942,
					   'winHeight':547
						},
					'leshiwang':{
					   'title':'乐视网',
					   'url':'http://www.letv.com/cooperation/qq.html',
					   'winWidth':842,
					   'winHeight':547
						},
					'qianqianMusic':{
					   'title':'千千音乐',
					   'url':'http://www.qianqian.com/paihang.html',
					   'winWidth':930,
					   'winHeight':500
						},
					'zfMeishi':{
					   'title':'主妇美食',
					   'url':'http://www.zhms.cn/',
					   'winWidth':930,
					   'winHeight':500
						},
					'mglvyou':{
						'title':'芒果旅游',
					   'url':'http://www.mangocity.com/webqq/bookFlight.html',
					   'winWidth':930,
					   'winHeight':500
						},	
					'taobao':{
						'title':'淘宝网',
					   'url':'http://marketing.taobao.com/home/webqq/index.htm',
					   'winWidth':930,
					   'winHeight':500
						},	
					'qingshu':{
						'title':'情书',
					   'url':'http://www.qingshu8.net/',
					   'winWidth':930,
					   'winHeight':500
						},
					'fenghuang':{
						'title':'凤凰网',
					   'url':'http://www.ifeng.com/',
					   'winWidth':930,
					   'winHeight':500
						},	
					'zhongguancun':{
						'title':'中关村在线',
					   'url':'http://www.zol.com.cn/',
					   'winWidth':930,
					   'winHeight':500
						},
					'win35':{
						'title':'搜狐汽车',
					   'url':'http://auto.sohu.com/',
					   'winWidth':930,
					   'winHeight':500
						},	
					'win36':{
						'title':'布丁电影票',
					   'url':'http://piao.buding.cn/',
					   'winWidth':900,
					   'winHeight':500
						},	
					'win37':{
						'title':'中国数学资源网',
					   'url':'http://www.mathrs.net/',
					   'winWidth':930,
					   'winHeight':500
						},
					'win38':{
						'title':'火影忍者漫画动画',
					   'url':'http://www.manmankan.com/',
					   'winWidth':930,
					   'winHeight':500
						},	
					'win39':{
						'title':'潇湘书院',
					   'url':'http://www.xxsy.net/',
					   'winWidth':930,
					   'winHeight':500
						}  
			  };			   
 		   
		  //存储桌面布局元素的jquery对象
		   myLib.desktop.desktopPanel();
 		   
		   //初始化桌面背景
		   myLib.desktop.wallpaper.init("<%=webpath%>/js/desktop/deskimg/9.jpg");
		   
		   //初始化任务栏
		   myLib.desktop.taskBar.init();
		   
		   //初始化桌面图标
		   myLib.desktop.deskIcon.init(deskIconData);
		   
		   //初始化桌面导航栏
		   myLib.desktop.navBar.init();
		   
		   //初始化侧边栏
		   myLib.desktop.lrBar.init(lrBarIconData);
		   
		   //欢迎窗口
		   //myLib.desktop.win.newWin({
			// WindowTitle:'欢迎窗口',
			// WindowsId:"welcome",
			// WindowAnimation:'none', 
			// WindowWidth:740,
			// WindowHeight:520
			// });
  		  
  		  
  		   //初始化桌面右键菜单
		 var data=[
					[{
					text:"显示桌面",
					func:function(){}
						}]
					,[{
					text:"系统设置",
				 	func:function(){}
					  },{
					text:"主题设置",
					func:function(){
				       //myLib.desktop.wallpaper.init(webpath+"/js/desktop/deskimg/2.jpg");
				         myWindow = $.ligerDialog.open({url: webpath+"/UI/desktop/imgwall/imgwall.jsp", width: 550,height:500, title: '主题设置',
			             showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
					}
						  }]
					,[{
					  text:"退出系统",
					  func:function(){} 
					  }]
					,[{
					  text:"关于fleiCms",
					  func:function(){} 
					  }]
					];
		 myLib.desktop.contextMenu($(document.body),data,"body",10);
		 
		 
		
		 
		  });
		  
		  
		 function changeback(url){
		 	myLib.desktop.wallpaper.init(url);
		 	myWindow.close();
		 } 		

</script>
</head>
<body style="padding: 0px;margin: 0px;width: 100%;height: 100%;border: 0">

<div id="wallpapers"></div>

<div id="navBar"><a href="#" class="currTab" title="桌面1"></a><a href="#"  title="桌面2"></a><a href="#"  title="桌面3"></a><a href="#"  title="桌面4"></a></div>

<div id="desktopPanel">
	<div id="desktopInnerPanel">
		<ul class="deskIcon currDesktop">
			<li class="desktop_icon" id="leshiwang"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon4.png"/></span><div class="text">行政审批<s></s></div></li>
			<li class="desktop_icon" id="Pixlr"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon6.png"/></span><div class="text">生产单位信息<s></s></div></li>
			<li class="desktop_icon" id="dubianFim"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon7.png"/></span><div class="text">执法检查<s></s></div></li>
			<li class="desktop_icon" id="kuwoMusic"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon8.png"/></span><div class="text">执法复查<s></s></div></li>
			<li class="desktop_icon" id="qidian"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon9.png"/></span><div class="text">行政处罚<s></s></div></li>
			<li class="desktop_icon add_icon"><span class="icon"><img src="<%=webpath%>/js/desktop/images/add_icon.png"/></span><div class="text">添加<s></s></div></li>
		</ul>
		<ul class="deskIcon">
			<li class="desktop_icon" id="zfMeishi"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon13.png"/></span><div class="text">重大危险源管理<s></s></div></li>
			<li class="desktop_icon" id="mglvyou"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon12.png"/></span><div class="text">职业危害信息<s></s></div></li>
			<li class="desktop_icon" id="taobao"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon14.png"/></span><div class="text">安全评价信息<s></s></div></li>
			<li class="desktop_icon" id="qingshu"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon15.png"/></span><div class="text">应急处理<s></s></div></li>
			<li class="desktop_icon" id="fenghuang"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon16.png"/></span><div class="text">预案管理<s></s></div></li>
			<li class="desktop_icon" id="zhongguancun"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon17.png"/></span><div class="text">培训考核<s></s></div></li>
			<li class="desktop_icon add_icon"><span class="icon"><img src="<%=webpath%>/js/desktop/images/add_icon.png"/></span><div class="text">添加<s></s></div></li>
		</ul>
		<ul class="deskIcon">
			<li class="desktop_icon" id="win35"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon18.png"/></span><div class="text">安全隐患管理<s></s></div></li>
			<li class="desktop_icon" id="win36"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon19.png"/></span><div class="text">标准化建设<s></s></div></li>
			<li class="desktop_icon" id="win37"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon8.png"/></span><div class="text">隐患自查<s></s></div></li>
			<li class="desktop_icon add_icon"><span class="icon"><img src="<%=webpath%>/js/desktop/images/add_icon.png"/></span><div class="text">添加<s></s></div></li>
		</ul>
		<ul class="deskIcon">
			<li class="desktop_icon" id="win38"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon20.png"/></span><div class="text">安全动态<s></s></div></li>
			<li class="desktop_icon" id="win39"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon21.png"/></span><div class="text">法律法规<s></s></div></li>
			<li class="desktop_icon" id="win39"><span class="icon"><img src="<%=webpath%>/js/desktop/icon/icon22.png"/></span><div class="text">危险化学品<s></s></div></li>
			<li class="desktop_icon add_icon"><span class="icon"><img src="<%=webpath%>/js/desktop/images/add_icon.png"/></span><div class="text">添加<s></s></div></li>
		</ul>
	</div>
</div><!--desktopPanel end-->

<div id="taskBarWrap">
	<div id="taskBar">
		<div id="leftBtn"><a href="#" class="upBtn"></a></div>
		<div id="rightBtn"><a href="#" class="downBtn"></a></div>
		<div id="task_lb_wrap"><div id="task_lb"></div></div>
	</div>
</div><!--taskBarWrap end-->

<div id="lr_bar">
	<ul id="default_app">
		<li id="app0"><span><img src="<%=webpath%>/js/desktop/icon/icon1.png" title="我的工作"/></span><div class="text">我的工作<s></s></div></li>
		<li id="app1"><span><img src="<%=webpath%>/js/desktop/icon/icon2.png" title="个人信息"/></span><div class="text">个人信息<s></s></div></li>
		<li id="app2"><span><img src="<%=webpath%>/js/desktop/icon/icon3.png" title="收藏资料"/></span><div class="text">收藏资料<s></s></div></li>
		<li id="app3"><span><img src="<%=webpath%>/js/desktop/icon/icon11.png" title="SYSTEM"/></span><div class="text"><s>SYSTEM</s></div></li>
	</ul>
	
	<div id="default_tools"><span id="showZm_btn" title="全屏"></span><span id="shizhong_btn" title="时钟"></span><span id="weather_btn" title="天气"></span><span id="them_btn" title="主题"></span></div>
	
	<div id="start_block">
		<a title="开始" id="start_btn"></a>
		<div id="start_item">
			<ul class="item admin">
				<li><span class="adminImg"></span>用户：ADMIN</li>
			</ul>
			<ul class="item">
				<li><span class="sitting_btn"></span>系统设置</li>
				<li><span class="help_btn"></span>使用指南 <b></b></li>
				<li><span class="about_btn"></span>关于我们</li>
				<li><span class="logout_btn"></span>退出系统</li>
			</ul>
		</div>
	</div>
	
</div>
	

</body>
</html>
