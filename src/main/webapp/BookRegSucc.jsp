<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功</title>
<style type="text/css">
@charset "utf-8";
/*==================Reset_start===================*/
body,h1,h2,h3,h4,h5,h6,div,p,dl,dt,dd,ol,ul,li,form,table,th,td,a,img,span,strong,var,em,input,textarea,select,option{margin: 0; padding: 0;}
html,body{font-family: "微软雅黑","宋体",Arail,Tabhoma; font-size: 14px; text-align: left;}
ul,ol{list-style: none;}
img{border: 0;}
input,select,textarea{outline:0;}
textarea{resize:none; overflow: auto;}
table{border-collapse: collapse; border-spacing: 0;}
th,strong,var,em{font-weight: normal; font-style: normal;}
a{/* text-decoration: none; */}
#warp{
	height: 920px; 
	}
#head {
	width: 1520px;
	height: 213px;
	margin:0 auto;
	border: 2px solid red;
	margin-top: 10px;
	/* background:url(banner.png) 0 0 no-repeat; */
}
#head img{
	width: 1520px;
	height: 213px;
}
#box{
	width:1524px;
	margin:0 auto;
	overflow: hidden;
	/* border-top: 1px solid  red; */
	}
#box #con1{
	border-right:2px solid red;
	border-bottom:2px solid red;
	border-left:2px solid red;
	width:250px;
	height:480px;
	float: left;
	font-size:12px;
	padding: 80px 0 0 80px;
	background:url(img/tu.png) 0 0 repeat-y;
}
#box #con2{
	width:1187px;
	height:560px;
	background-color:#abcdef;
	border-bottom:2px solid red;
	border-right:2px solid red;
	float: left;
}
h2{
	font-weight:normal;
	padding:25px 30px;
	background: url(img/icon_listlia.gif) 16px 33px no-repeat;
	}
</style>
</head>
<body>
	<div id="warp">
		<div id="head">
			<img src="img/banner.png" alt="s">
		</div>
		<!-- <h1>书籍库存登记系统（V1.0）</h1> -->
		<div id="box">
			<div id="con1">
				<h2><a href = "index.html">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></h2>
				<h2><a href = "BookRegister.jsp">入库登记</a></h2>
				<h2><a href = "bookAction">库存列表</a></h2>
				<h2><a href = "listBookPageAction">分页展示</a></h2>
			</div>
			<div id="con2">
				<h1>注册---${book.bookname }---成功</h1>
			</div>
		</div>
	</div>
</body>
</html>