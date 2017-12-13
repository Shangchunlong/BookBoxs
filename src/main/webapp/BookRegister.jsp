<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
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
/* a{text-decoration: none;} */
#warp{
	height: 920px; 
	}
#warp h1{
	width:640px;
	margin:0 auto;
	padding :40px  0 ;
	font-size:50px;
	color: #d40000;
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
	height:484px;
	float: left;
	font-size:12px;
	padding: 80px 0 0 80px;
	background:url(img/tu.png) 0 0 repeat-y;
}
#box #con2{
	width:1008px;
	height:514px;
	font-size:20px; 
	border-bottom:2px solid red;
	border-right:2px solid red;
	float: left;
	background-color:#abcdef;
	padding: 50px 0 0 180px;
}
h2{
	font-weight:normal;
	padding:25px 30px;
	background: url(img/icon_listlia.gif) 16px 33px no-repeat;
	}
#con2 span{
	font-size:12px; 
	margin:7px 15px ;
}
#con2 #sb{
	width:104px;
	height:28px;
	margin:15px 0 0 60px ;
}
.left li{
	margin-top:20px ;
}
.left #ck,#rd{
	width: 18px;
	height: 16px;
}
.left #name,#ah,#pm,#num{
	width: 160px;
	height:24px;
}
.left .lab{
	float:left; 
}
.left li li,ul{
	display: inline;
	
}
.left li li span{
	color: red;
}
</style>
</head>
<body>
	<div id="warp">
		<div id="head">
			<img src="img/banner.png" alt="s">
		</div>
		<div id="box">
			<div id="con1">
				<h2><a href = "index.html">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></h2>
				<h2><a href = "BookRegister.jsp">入库登记</a></h2>
				<h2><a href = "bookAction">库存列表</a></h2>
				<h2><a href = "listBookPageAction">分页展示</a></h2>
			</div>
			<div id="con2">
				<form action="addBookAction" method="post">
					<ul class="left">
						<li>
							<label for="name">书名：</label> 
							<input id="name" type="text" name="bookname" value="${param.bookname }">
							<s:fielderror>
								<s:param>bookname</s:param>
							</s:fielderror>
						</li>
						<li>
							<label for="ck">类别：</label>
							<c:set var="che" value="科学,教育,文学,生活,其他"></c:set>
							<c:forEach items="${che }" var="c">
								<span><input id="ck" type="checkbox" name="type" value="${c }"
									<c:forEach items="${param.types }" var="li">
										<c:if test="${li eq c }">checked</c:if>
									</c:forEach>
								>${c }</span>
							</c:forEach>
							<s:fielderror>
								<s:param>type</s:param>
							</s:fielderror>
						</li>
						<li>
							<label for="ah">作者：</label>
							<input id="ah" type="text" name="author" value="${param.author }">
							<s:fielderror>
								<s:param>author</s:param>
							</s:fielderror>
						</li>
						<li>
							<label for="rd">折扣：</label>
							<c:set var="rad" value="全价,九折,八折,七折,六折"></c:set>
							<c:forEach items="${rad }" var="r">
								<span><input id="rd" type="radio" name="discount" value="${r }"
								<c:if test="${param.discount eq r }">checked</c:if>
								>${r }</span>
							</c:forEach>
							<s:fielderror>
								<s:param>discount</s:param>
							</s:fielderror>
						<li>
							<label for="pm">价格：</label>
							<input id="pm" type="text" name="price" value="${param.price }">
							<s:fielderror>
								<s:param>price</s:param>
							</s:fielderror>
						</li>
						<li>
							<label for="num">数量：</label>
							<input id="num" type="text" name="num" value="${param.num }">
							<s:fielderror>
								<s:param>num</s:param>
							</s:fielderror>
						</li>
						<li>
							<label for="msg" class="lab">简介：</label>
							<textarea name="massage" id="msg" cols="30" rows="5" >${param.massage}</textarea>
							<s:fielderror>
								<s:param>massage</s:param>
							</s:fielderror>
						</li>
						<li class="foot">
							<input id="sb" type="submit" value="登记">
							<input id="sb" type="reset" value="重置"><br>
						</li>
					</ul>
				</form>
				
				
				<!-- 此方法可以获取到错误信息 -->
				<%-- <c:if test="${not empty errors }">
						<c:forEach items="${errors }" var ="error">
							<p  style ="color: red ;width:500px">  ${error } </p><br>
						</c:forEach>
				</c:if> --%>
			</div>
		</div>
	</div>
</body>
</html>