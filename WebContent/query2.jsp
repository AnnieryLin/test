<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,net.lgs.domain.Record"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>历史记录</title>
	<style type="text/css">
        .col_id { text-align:right; width:60px; }
		.col_devid { text-align:center; width:80px; }
		.col_devname { text-align:center; width:120px; }
		.col_code { text-align:center; width:220px; }
		.col_total { text-align:center; width:60px; }
		.col_time { text-align:center; width:240px; }
		.col_operate { text-align:center; width:160px; }
		table { border:3px; border-collapse:collapse; }
  		td, th { border:1px solid #144a74; padding:3px 7px 2px 7px; }
  		td { height:24px; background-color:#fff; }
  		th { height:30px; font-size:1.1em; background-color:#ccc; }
  		body { background-color:#baccd9; }
  		.main_div {
            position: absolute;
            top: 30%;
            left: 18%;
            margin: -150px 0 0 -150px;
            width:1000px;
            height:300px;
        }
    </style>
    
    <script type="text/javascript">
	function deleteConfirm(s) { 
		if(!confirm('确定要删除吗？')) {
			return; 
		}
		location.href = s;
	}
	</script>
</head>
<body>
<div class="main_div">
<table>
	<% ArrayList<Record> records = (ArrayList<Record>)session.getAttribute("records");
		if (records != null) { %>
			<tr>
				<th>序号</th> <th>设备编号</th> <th>设备名称</th> <th>评分情况</th> <th>总得分</th> <th>评分时间</th> <th colspan="2">操作</th>
			</tr>
		 <%	System.out.println("当前用户已评过 " + records.size() + "个设备");
			for (int i = 0; i < records.size(); i++) { %>
				<tr>
					<td class="col_id"><%=i+1%></td>
					<td class="col_devid"><%=records.get(i).getDevId()%></td>
					<td class="col_devname"><%=records.get(i).getDevName()%></td>
					<td class="col_code"><%=records.get(i).getScoreCode()%></td>
					<td class="col_total"><%=records.get(i).getTotalScore()%></td>
					<td class="col_time"><%=records.get(i).getTime()%></td>
					<td class="col_operate">
						<!-- TODO 点击完成删除操作并自动刷新页面 "delete?id=<%=records.get(i).getId()%>" -->
						<a href="javascript:deleteConfirm('delete?id=<%=records.get(i).getId()%>')">删除</a>
						<!-- TODO 点击跳转到修改页面 -->
						<!-- <a href="">修改</a> 放出来点击会报错，懒得找了 -->
					</td>
				</tr>
		 <% }
		} %>
</table>
</div>

</body>
</html>