<!--
/*********************************************************************
 *<p>处理内容：图片墙</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.14---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>

<link rel="stylesheet" type="text/css" href="<%=webpath%>/js/jmFullWall/res/css/jmFullWall.css" />
<script type="text/javascript" src="<%=webpath%>/js/jmFullWall/res/js/lib/jquery.imgpreload.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/jmFullWall/res/js/lib/jquery.imagepanner.js"></script>
<script type="text/javascript" src="<%=webpath%>/js/jmFullWall/res/js/lib/jquery.jmFullWall.js"></script>

<script type="text/javascript">
$(function(){
	$('#wall').jmFullWall({
		itemsForRow : 5	
	});	
});
</script>

</head>

<body style="margin: 0px;padding: 0px">

<div id="wall-top"></div>

<div id="wall-container">
	<div id="wall-loading"></div>
	
	<div id="wall-detail"></div>
	
	<div id="wall">
		<div id="wall-items">	
			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/1.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/1.jpg</span>
				<span class="tooltip hide">Audi Locus</span>
				<a href="#"><span class="title">Audi Locus</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/2.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/2.jpg</span>
				<span class="tooltip hide">Porsche Supercar</span>
				<a href="#"><span class="title">Porsche Supercar</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/3.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/3.jpg</span>
				<span class="tooltip hide">Ford GT</span>
				<a href="#"><span class="title">Ford GT</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/4.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/4.jpg</span>
				<span class="tooltip hide">Lamborghini Murcielago</span>
				<a href="#"><span class="title">Lamborghini Murcielago</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/5.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/5.jpg</span>
				<span class="tooltip hide">Nissan R390 GT1</span>
				<a href="#"><span class="title">Nissan R390 GT1</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/6.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/6.jpg</span>
				<span class="tooltip hide">Porsche 911 GT3 RS</span>
				<a href="#"><span class="title">Porsche 911 GT3 RS</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/7.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/7.jpg</span>
				<span class="tooltip hide">Pagani Zonda F</span>
				<a href="#"><span class="title">Pagani Zonda F</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/8.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/8.jpg</span>
				<span class="tooltip hide">Maybach Exelero</span>
				<a href="#"><span class="title">Maybach Exelero</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/9.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/9.jpg</span>
				<span class="tooltip hide">Dodge Challenger</span>
				<a href="#"><span class="title">Dodge Challenger</span></a>
			</div>

			<div class="wall-item">
				<span class="bg hide"><%=webpath%>/js/jmFullWall/res/img/slide/10.jpg</span>
				<span class="img_detail hide"><%=webpath%>/js/jmFullWall/res/img/slide/10.jpg</span>
				<span class="tooltip hide">Porsche 918 Spyder</span>
				<a href="#"><span class="title">Porsche 918 Spyder</span></a>
			</div>


		</div>
	</div>
</div>

</body>
</html>
