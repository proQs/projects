package PS.admin.service;

import java.util.Collections;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import PS.admin.common.SplitPage;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

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
	protected void splitPageBase(String dataSource, SplitPage splitPage, String sql, String sqlExcept, Object param){
		// 接收返回值对象
		StringBuilder formSqlSb = new StringBuilder();
		formSqlSb.append(sqlExcept);
		LinkedList<Object> paramValue = new LinkedList<Object>();
		Collections.addAll(paramValue, param);
		
		// 排序
		String orderColunm = splitPage.getOrderColunm();
		String orderMode = splitPage.getOrderMode();
		if(null != orderColunm && !orderColunm.isEmpty() && null != orderMode && !orderMode.isEmpty()){
			formSqlSb.append(" order by ").append(orderColunm).append(" ").append(orderMode);
		}
		
		String formSql = formSqlSb.toString();

		Page<?> page = Db.use(dataSource).paginate(splitPage.getPageNumber(), splitPage.getPageSize(), sql, formSql, paramValue.toArray());
		splitPage.setTotalPage(page.getTotalPage());
		splitPage.setTotalRow(page.getTotalRow());
		if (splitPage.getList() == null) {
			splitPage.setList(page.getList());
		} else {
			splitPage.addList(page.getList());
		}
		splitPage.compute();
	}
}
