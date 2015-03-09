package PS.admin.controller;

import java.util.List;
import java.util.Map;

import PS.admin.model.ServerInfo;
import PS.admin.model.UserInfo;

import com.jfinal.core.Controller;

public abstract class BaseController extends Controller{

	/**
	 * 全局变量
	 */
	protected String ids;			// 主键
//	protected SplitPage splitPage;	// 分页封装
	protected List<?> list;			// 公共list
	
	/**
	 * 请求/WEB-INF/下的视图文件
	 */
	public void toUrl() {
		String toUrl = getPara("toUrl");
		render(toUrl);
	}
	
	/**
	 * 获取当前用户id
	 * @return
	 */
	protected String getCUserIds(){
		return getAttr("cUserIds");
	}

	/**
	 * 获取当前用户
	 * @return
	 */
	protected String getCUser(){
		return getAttr("cUser");
	}

	/**
	 * 获取ParamMap
	 * @return
	 */
	protected Map<String, String> getParamMap(){
		return getAttr("paramMap");
	}

	/**
	 * 添加值到ParamMap
	 * @return
	 */
	protected void addToParamMap(String key, String value){
		Map<String, String> map = getAttr("paramMap");
		map.put(key, value);
	}
	
	/**
	 * 设置默认排序
	 * @param colunm
	 * @param mode
	 */
	protected void defaultOrder(String colunm, String mode){
//		if(null == splitPage.getOrderColunm() || splitPage.getOrderColunm().isEmpty()){
//			splitPage.setOrderColunm(colunm);
//			splitPage.setOrderMode(mode);
//		}
	}
	
	public void index() {
		String username = getPara("username");
		Integer serverId = getParaToInt("serverId");
		if (serverId == null) {
			serverId = -1;
		}
		templateMethod(serverId);
		keepPara("serverId");
		setAttr("user", UserInfo.getUsers().get(username));
		setAttr("serverList", ServerInfo.getServerInfoList());
		render("/base/basePage.jsp");
	}

	protected abstract void templateMethod(Integer serverId);
}
