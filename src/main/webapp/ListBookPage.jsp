<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库存</title>
<script type="text/javascript">
	function del(id){
		var flag = window.confirm("确认删除吗?");
		if(flag){
			location.href="bookDelAction?id="+id;
		}
	}
</script>
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
	width:1187px;
	height:564px;
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
#con2 .list{
	width: 840px;
	height: 285px;
	margin: 40px auto;
}
.list caption{
	font-size: 24px;
}
#con2 table{
	border-collapse:collapse;
	font-size: 24px;
}
</style>
</head>
<body>
	<div id="warp">
	<div id="head"><img src="img/banner.png" alt="s"></div>
		<div id="box">
			<div id="con1">
				<h2><a href = "index.html">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></h2>
				<h2><a href = "BookRegister.jsp">入库登记</a></h2>
				<h2><a href = "bookAction">库存列表</a></h2>
				<h2><a href = "listBookPageAction">分页展示</a></h2>
			</div>
			<div id="con2">
				<div class="list">
					<table width="840"  border="1" cellpadding="1" cellspacing="1">
						<caption>书籍库存列表</caption>
						<tr>
							<th>编号</th>
							<th>书名</th>
							<th>作者</th>
							<th>价格</th>
							<th>数量</th>
							<th>操作</th>
							<th>操作2</th>
							<th>操作3</th>
						</tr>
						<c:forEach items="${pb.list }" var="book">
							<tr>
								<td>${ book.id}</td>
								<td>${ book.bookname}</td>
								<td>${ book.author}</td>
								<td>${ book.price}</td>
								<td>${ book.num}</td>
								<td><a href="detailsBookAction?id=${book.id }">详情</a></td>
								<td><a href="javascript:void(0)" onclick="del('${book.id}')">删除</a></td>
								<td><a href="UpdateBook.jsp?id=${book.id }&bookname=${book.bookname}&type=${book.type}&author=${book.author}&discount=${book.discount}&price=${book.price}&num=${book.num}&massage=${book.massage}">修改</a></td>
							</tr>
						</c:forEach>
					</table>	
				</div>
				<center>
					<c:if test="${pb.currentPage != 1 }">
						<a href="listBookPageAction?currentPage=1">首页</a>&nbsp;&nbsp;
					</c:if>
					
					<c:if test="${pb.currentPage == 1 }">
						首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
					</c:if>
					<c:if test="${pb.currentPage != 1 }">
						<a href="listBookPageAction?currentPage=${pb.currentPage-1 }">上一页</a>&nbsp;&nbsp;
					</c:if>
					
					<c:if test="${pb.currentPage == pb.totalPage }">
						下一页&nbsp;&nbsp;
					</c:if>
					<c:if test="${pb.currentPage != pb.totalPage }">
						<a href="listBookPageAction?currentPage=${pb.currentPage+1 }">下一页</a>&nbsp;&nbsp;
					</c:if>
					
					<a href="listBookPageAction?currentPage=${pb.totalPage }">尾页</a><br/><br/>
				</center>	
			</div>
		</div>
	</div>
</body>
</html>