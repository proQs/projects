package PS.admin.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import PS.admin.common.SplitPage;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public abstract class BaseService {

	protected static Logger log = Logger.getLogger(BaseService.class);
	
	/**
	 * 分页
	 * @param dataSource 数据源
	 * @param splitPage
	 * @param sql
	 * @param sqlExcept 
	 * @param param
	 */
	protected void splitPageBase(String dataSource, SplitPage<Record> splitPage, String sql, String sqlExcept, Object[] param){
		// 接收返回值对象
		StringBuilder formSqlSb = new StringBuilder();
		formSqlSb.append(sql);
		formSqlSb.append(sqlExcept);
		List<Object> paramValue = new ArrayList<Object>();
		Collections.addAll(paramValue, param);
		
		// 排序
		String orderColunm = splitPage.getOrderColunm();
		String orderMode = splitPage.getOrderMode();
		if(null != orderColunm && !orderColunm.isEmpty() && null != orderMode && !orderMode.isEmpty()){
			formSqlSb.append(" order by ").append(orderColunm).append(" ").append(orderMode);
		}
		
		String formSql = formSqlSb.toString();

		List<Record> ls = Db.use(dataSource).find(formSql, paramValue.toArray());
		if (splitPage.getList() == null) {
			splitPage.setList(ls);
		} else {
			splitPage.addList(ls);
		}
		splitPage.manualSplit();
	}
}
