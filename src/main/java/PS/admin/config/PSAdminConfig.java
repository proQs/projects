package PS.admin.config;

import PS.admin.controller.LoginController;
import PS.admin.controller.SelectServerController;
import PS.admin.controller.ViewRetentionController;
import PS.admin.controller.multiLogController;
import PS.admin.controller.retentionController;
import PS.admin.controller.singleLogController;
import PS.admin.controller.viewMultiLogController;
import PS.admin.controller.viewSingleLogController;
import PS.admin.interceptor.AuthenticationInterceptor;
import PS.admin.model.Adminaccount;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class PSAdminConfig extends JFinalConfig {
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		loadPropertyFile("sql_config.txt");				// 加载少量必要配置，随后可用getProperty(...)获取值
		me.setDevMode(getPropertyToBoolean("devMode", false));
		me.setViewType(ViewType.JSP);
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/PSadminlogin", LoginController.class, "/index");
		me.add("/PSselectSV", SelectServerController.class);
		me.add("/PSadmin/retention", retentionController.class);
		me.add("/PSadmin/viewretention", ViewRetentionController.class);
		me.add("/PSadmin/singlelog", singleLogController.class);
		me.add("/PSadmin/viewsinglelog", viewSingleLogController.class);
		me.add("/PSadmin/multilog", multiLogController.class);
		me.add("/PSadmin/viewmultilog", viewMultiLogController.class);
	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.setDialect(new MysqlDialect());
		arp.setShowSql(true);
		arp.addMapping("adminaccount", "GID", Adminaccount.class);	// 映射adminaccount 表到 Adminaccount模型
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		me.add(new AuthenticationInterceptor());
		me.add(new SessionInViewInterceptor());
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("ctx_path"));
	}
}
