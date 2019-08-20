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
            top: 40%;
            left: 28%;
            margin: -150px 0 0 -150px;
            width:1200px;
            height:300px;
        }
        h2 { color: #fff; text-shadow: 0 0 10px rgba(0,0,0,0.3); letter-spacing:1px; text-align:center; }
    </style>
    
    <script type="text/javascript">
	// 在score_table和tmp_record中删除此条id对应的记录
	function delete() {
		//此处填写要处理的逻辑代码
		window.opener.location.reload(); // 刷新页面
	}
	</script>
</head>
<body>
<br/><h2>历史检测记录</h2>
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
					<td class="col_id"><%= i+1 %></td>
					<td class="col_devid"><%= records.get(i).getDevId() %></td>
					<td class="col_devname"><%= records.get(i).getDevName() %></td>
					<td class="col_code"><%= records.get(i).getScoreCode() %></td>
					<td class="col_total"><%= records.get(i).getTotalScore() %></td>
					<td class="col_time"><%= records.get(i).getTime() %></td>
					<td class="col_operate">
						<!-- TODO 点击完成删除操作并自动刷新页面 -->
						<input type="button" value="删除" onclick="delete(<%= records.get(i).getId() %>)"/>
						<!-- TODO 点击跳转到修改页面 -->
						<a href="">修改</a>
					</td>
				</tr>
		 <% }
		} %>
</table>
<br/><p align="center">
	<a href="entry1.jsp">返回</a>
</p>
</div>

</body>
</html>