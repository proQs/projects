<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<base href="${ctx_path}/">
<link type="text/css" href="css/jquery-ui-1.8.17.custom.css"
	rel="stylesheet" />
<link type="text/css" href="css/jquery-ui-timepicker-addon.css"
	rel="stylesheet" />
<link type="text/css" href="css/myStyle.css"
	rel="stylesheet" />
<script type="text/javascript" src="${ctx_path}/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="${ctx_path}/js/jquery-ui-1.8.17.custom.min.js"></script>
<script type="text/javascript" src="${ctx_path}/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${ctx_path}/js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript">
    $(function () {
        $(".ui_timepicker").datetimepicker({
            showOn: "button",
            buttonImage: "css/images/icon_calendar.gif",
            buttonImageOnly: true,
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        });
    });
    </script>

	
<div class="right" id="li010">
	<form id="viewmultilog" action="${ctx_path}/PSadmin/viewmultilog" method="post">
		<input type="hidden" name="serverId" value="${serverId}"/>
		<input type="hidden" name="username" value="${user.name}"/>
		<input type="hidden" name="page" value="multilogResult"/>
		
		<div class="right01">
			<img src="${ctx_path}/images/04.gif" /> Log &gt; <span>Log查询</span>&gt; <span>多人查询</span>
		</div>
		<table id="rounded-corner" summary="多人Log">
			<thead>
				<tr>
					<th scope="col" class="rounded-company">开始时间</th>
					<th scope="col" class="rounded-q4" colspan="3">
						<input type="text" name="startDate" class="ui_timepicker" value="${startDatere}"></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td class="rounded-foot-left"></td>
					<td class="rounded-foot-right" colspan="3">
						<input type="submit" name="Submit" value="查询"/></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
		        	<td>结束时间</td>
		        	<td colspan="3"><input type="text" name="endDate" class="ui_timepicker" value="${endDatere}"></td>
		        </tr>
			</tbody>
		</table>
		<table id="hor-minimalist-b" summary="Employee Pay Sheet">
		    <thead>
		    	<tr>
		        	<th scope="col" colspan="8">Log类型选择</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="0" />玩家升级</td>
		        	<td><input name="logType" type="checkbox" value="1" />玩家获得经验</td>
		        	<td><input name="logType" type="checkbox" value="2" />购买道具</td>
		        	<td><input name="logType" type="checkbox" value="3" />购买道具失败</td>
		        	<td><input name="logType" type="checkbox" value="4" />增加积分</td>
		        	<td><input name="logType" type="checkbox" value="5" />技能强化</td>
		        	<td><input name="logType" type="checkbox" value="6" />积分奖励</td>
		        	<td><input name="logType" type="checkbox" value="7" />镶嵌技能</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="8" />玩家充值</td>
		        	<td><input name="logType" type="checkbox" value="9" />任务奖励</td>
		        	<td><input name="logType" type="checkbox" value="10" />福利奖励</td>
		        	<td><input name="logType" type="checkbox" value="11" />购买VIP礼包</td>
		        	<td><input name="logType" type="checkbox" value="12" />VIP礼包介绍</td>
		        	<td><input name="logType" type="checkbox" value="13" />道具消耗</td>
		        	<td><input name="logType" type="checkbox" value="14" />货币消耗</td>
		        	<td><input name="logType" type="checkbox" value="15" />拍卖行上架</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="16" />上架失败</td>
		        	<td><input name="logType" type="checkbox" value="17" />拍卖行购买</td>
		        	<td><input name="logType" type="checkbox" value="18" />出售装备</td>
		        	<td><input name="logType" type="checkbox" value="19" />扩展背包</td>
		        	<td><input name="logType" type="checkbox" value="20" />拍卖行盈利</td>
		        	<td><input name="logType" type="checkbox" value="21" />升级阵法</td>
		        	<td><input name="logType" type="checkbox" value="22" />BOSS激励花费</td>
		        	<td><input name="logType" type="checkbox" value="23" />激励失败</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="24" />BOSS清除CD</td>
		        	<td><input name="logType" type="checkbox" value="25" />BOSS击杀</td>
		        	<td><input name="logType" type="checkbox" value="26" />碎片合成</td>
		        	<td><input name="logType" type="checkbox" value="27" />卡牌进阶</td>
		        	<td><input name="logType" type="checkbox" value="28" />PVP刷新CD</td>
		        	<td><input name="logType" type="checkbox" value="29" />传承</td>
		        	<td><input name="logType" type="checkbox" value="30" />PVP挑战</td>
		        	<td><input name="logType" type="checkbox" value="31" />添删好友</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="32" />同意好友</td>
		        	<td><input name="logType" type="checkbox" value="33" />领取好友体力</td>
		        	<td><input name="logType" type="checkbox" value="34" />赠送好友体力</td>
		        	<td><input name="logType" type="checkbox" value="35" />提升亲密度</td>
		        	<td><input name="logType" type="checkbox" value="36" />PVP战斗奖励</td>
		        	<td><input name="logType" type="checkbox" value="37" />PVP战斗升级</td>
		        	<td><input name="logType" type="checkbox" value="38" />PVP兑换</td>
		        	<td><input name="logType" type="checkbox" value="39" />抽卡</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="40" />PVP排名奖励</td>
		        	<td><input name="logType" type="checkbox" value="41" />收邮件</td>
		        	<td><input name="logType" type="checkbox" value="42" />关卡奖励</td>
		        	<td><input name="logType" type="checkbox" value="43" />装备熔炼</td>
		        	<td><input name="logType" type="checkbox" value="44" />熔炼奖励</td>
		        	<td><input name="logType" type="checkbox" value="45" />补签花费</td>
		        	<td><input name="logType" type="checkbox" value="46" />补签失败</td>
		        	<td><input name="logType" type="checkbox" value="47" />熔炼积分奖励</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="48" />特殊副本奖励</td>
		        	<td><input name="logType" type="checkbox" value="49" />无尽试炼</td>
		        	<td><input name="logType" type="checkbox" value="50" />试炼加成</td>
		        	<td><input name="logType" type="checkbox" value="51" />试炼复活</td>
		        	<td><input name="logType" type="checkbox" value="52" />试炼复活失败</td>
		        	<td><input name="logType" type="checkbox" value="53" />试炼结算奖励</td>
		        	<td><input name="logType" type="checkbox" value="54" />满汉全席</td>
		        	<td><input name="logType" type="checkbox" value="55" />使用体力道具</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="56" />使用精力道具</td>
		        	<td><input name="logType" type="checkbox" value="57" />开宝箱</td>
		        	<td><input name="logType" type="checkbox" value="58" />关卡卡牌经验</td>
		        	<td><input name="logType" type="checkbox" value="59" />重置关卡</td>
		        	<td><input name="logType" type="checkbox" value="60" />签到奖励</td>
		        	<td><input name="logType" type="checkbox" value="61" />补签奖励</td>
		        	<td><input name="logType" type="checkbox" value="62" />累计签到奖励</td>
		        	<td><input name="logType" type="checkbox" value="63" />扩充好友背包</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="64" />扩充好友背包失败</td>
		        	<td><input name="logType" type="checkbox" value="65" />扩展上架数量</td>
		        	<td><input name="logType" type="checkbox" value="66" />扩展上架数量失败</td>
		        	<td><input name="logType" type="checkbox" value="67" />好友申请</td>
		        	<td><input name="logType" type="checkbox" value="68" />元宝特权</td>
		        	<td><input name="logType" type="checkbox" value="69" />扩展龙脉</td>
		        	<td><input name="logType" type="checkbox" value="70" />兑换龙魂</td>
		        	<td><input name="logType" type="checkbox" value="71" />移除龙脉宝珠</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="72" />扫荡关卡奖励</td>
		        	<td><input name="logType" type="checkbox" value="73" />扫荡的关卡信息</td>
		        	<td><input name="logType" type="checkbox" value="74" />工会修炼后卡牌重置</td>
		        	<td><input name="logType" type="checkbox" value="75" />工会修炼选项重置</td>
		        	<td><input name="logType" type="checkbox" value="76" />创建工会</td>
		        	<td><input name="logType" type="checkbox" value="77" />工会贡献</td>
		        	<td><input name="logType" type="checkbox" value="78" />工会副本</td>
		        	<td><input name="logType" type="checkbox" value="79" />工会副本回血</td>
		        </tr>
		    	<tr>
		        	<td><input name="logType" type="checkbox" value="80" />工会副本复活</td>
		        	<td><input name="logType" type="checkbox" value="81" />工会商城道具</td>
		        	<td><input name="logType" type="checkbox" value="82" />刷新公会商城</td>
		        	<td><input name="logType" type="checkbox" value="83" />工会心魔挑战</td>
		        	<td><input name="logType" type="checkbox" value="84" />工会心魔奖励</td>
		        	<td>--</td>
		        	<td>--</td>
		        	<td><input name="all" type="checkbox" onclick="checkAll('logType')"/>全选</td>
		        </tr>
		    </tbody>
		</table>
	</form>
</div>