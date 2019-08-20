<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,net.lgs.domain.Device"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>录入结果</title>
	<style type="text/css">
		.col_id { text-align:right; width:60px; }
		.col_des { text-align:left; width:600px; }
		.col_radio { text-align:center; width:80px; }
  		table { border:3px; border-collapse:collapse; }
  		td, th { border:1px solid #144a74; padding:3px 7px 2px 7px; }
  		td { height:24px; background-color:#fff; }
  		th { height:30px; font-size:1.1em; background-color:#ccc; }
  		tr.alt td { color:#000; background-color:#eee; }
		body { background-color:#baccd9; }
        .main_div {
            position: absolute;
            top: 26%;
            left: 22%;
            margin: -150px 0 0 -150px;
            width:1000px;
            height:300px;
        }
    </style>
    
    <script type="text/javascript">
	function selectDev() { 
		if(document.getElementById("devId").value == 0) {
			alert("请选择设备！");
			return false;
		}
	}
	</script>
</head>
<body>
<div class="main_div">
  <form action="fill" method="post" onsubmit="return selectDev();">
    <!-- TODO 从数据库查询dev_info表后显示设备列表供用户选择 -->
    设备名称: <select name="devId" id="devId">
    <option value=0>--请选择设备--</option>
    <% ArrayList<Device> devs = (ArrayList<Device>)session.getAttribute("devs");
    if (devs != null) {
    	for (int i = 0; i < devs.size(); i++) { %>
    		<option value=<%=i+1%>><%=devs.get(i).getName()%></option>
    	<% }
    } %>
    </select><br/><br/>
  
    <div><table>
    <tr>
      <th>序号</th> <th>检测项</th> <th>是</th> <th>否</th>
    </tr>
    <tr>
      <td class="col_id">1.</td> <td class="col_des">上传的数据是否加密</td>
      <td class="col_radio"><label><input id="yes1" type="radio" name="q1" value=1>是</label></td>
      <td class="col_radio"><label><input id="no1" type="radio" name="q1" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">2.</td> <td class="col_des">数据后是否附加了数字签名</td>
      <td class="col_radio"><label><input id="yes2" type="radio" name="q2" value=1>是</label></td>
      <td class="col_radio"><label><input id="no2" type="radio" name="q2" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">3.</td> <td class="col_des">安全芯片是否具有唯一的标识ID</td>
      <td class="col_radio"><label><input id="yes3" type="radio" name="q3" value=1>是</label></td>
      <td class="col_radio"><label><input id="no3" type="radio" name="q3" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">4.</td> <td class="col_des">安全芯片中存储的私钥是否不可读不可改</td>
      <td class="col_radio"><label><input id="yes4" type="radio" name="q4" value=1>是</label></td>
      <td class="col_radio"><label><input id="no4" type="radio" name="q4" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">5.</td> <td class="col_des">安全芯片生产厂家是否通过认证</td>
      <td class="col_radio"><label><input id="yes5" type="radio" name="q5" value=1>是</label></td>
      <td class="col_radio"><label><input id="no5" type="radio" name="q5" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">6.</td> <td class="col_des">安全芯片安全保证级别是否不低于EAL4+级</td>
      <td class="col_radio"><label><input id="yes6" type="radio" name="q6" value=1>是</label></td>
      <td class="col_radio"><label><input id="no6" type="radio" name="q6" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">7.</td> <td class="col_des">是否具备商用密码产品型号证书</td>
      <td class="col_radio"><label><input id="yes7" type="radio" name="q7" value=1>是</label>
      <td class="col_radio"><label><input id="no7" type="radio" name="q7" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">8.</td> <td class="col_des">安全芯片密钥长度是否为256bit</td>
      <td class="col_radio"><label><input id="yes8" type="radio" name="q8" value=1>是</label></td>
      <td class="col_radio"><label><input id="no8" type="radio" name="q8" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">9.</td> <td class="col_des">通过公钥进行数字签名的速度是否不小于100次/秒</td>
      <td class="col_radio"><label><input id="yes9" type="radio" name="q9" value=1>是</label></td>
      <td class="col_radio"><label><input id="no9" type="radio" name="q9" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">10.</td> <td class="col_des">是否对从管理平台接收的操作指令进行安全检测</td>
      <td class="col_radio"><label><input id="yes10" type="radio" name="q10" value=1>是</label></td>
      <td class="col_radio"><label><input id="no10" type="radio" name="q10" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">11.</td> <td class="col_des">是否对异常操作指令提供相应的防护措施</td>
      <td class="col_radio"><label><input id="yes11" type="radio" name="q11" value=1>是</label></td>
      <td class="col_radio"><label><input id="no11" type="radio" name="q11" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">12.</td> <td class="col_des">是否具有识别应用层攻击的能力</td>
      <td class="col_radio"><label><input id="yes12" type="radio" name="q12" value=1>是</label></td>
      <td class="col_radio"><label><input id="no12" type="radio" name="q12" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">13.</td> <td class="col_des">是否具有识别非应用层攻击的能力</td>
      <td class="col_radio"><label><input id="yes13" type="radio" name="q13" value=1>是</label></td>
      <td class="col_radio"><label><input id="no13" type="radio" name="q13" value=0 checked="checked">否</label></td>
    </tr>
    <tr class="alt">
      <td class="col_id">14.</td> <td class="col_des">GPS模块是否具有抗干扰性</td>
      <td class="col_radio"><label><input id="yes14" type="radio" name="q14" value=1>是</label></td>
      <td class="col_radio"><label><input id="no14" type="radio" name="q14" value=0 checked="checked">否</label></td>
    </tr>
    <tr>
      <td class="col_id">15.</td> <td class="col_des">是否能抵御GPS欺骗攻击</td>
      <td class="col_radio"><label><input id="yes15" type="radio" name="q15" value=1>是</label></td>
      <td class="col_radio"><label><input id="no15" type="radio" name="q15" value=0 checked="checked">否</label></td>
    </tr>
    </table></div>
    <br/>
    <div>
    	<button type="reset">重置</button>
    	<button type="submit">确认</button>
    </div>
  </form>
</div>

</body>
</html>