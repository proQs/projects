package PS.admin.controller;

import java.util.Map;

import org.apache.log4j.Logger;

import PS.admin.common.SplitPage;
import PS.admin.model.ServerInfo;
import PS.admin.model.UserInfo;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public abstract class BaseController extends Controller{

	protected static Logger log = Logger.getLogger(BaseController.class);
	
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
	 * @param splitPage 
	 */
	protected void defaultOrder(String colunm, String mode, SplitPage<Record> splitPage){
		if(null == splitPage.getOrderColunm() || splitPage.getOrderColunm().isEmpty()){
			splitPage.setOrderColunm(colunm);
			splitPage.setOrderMode(mode);
		}
	}
	
	protected final void baseIndex() {
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
