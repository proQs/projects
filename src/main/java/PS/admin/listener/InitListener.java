package PS.admin.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import PS.admin.tools.CommonUtil;

import com.jfinal.kit.PathKit;

/**
 * 系统启动初始化数据
 */
public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
	}

	// 启动加载
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String path = context.getRealPath("/");
		PathKit.setWebRootPath(path);
		CommonUtil.getServerInfo(this.getClass().getClassLoader());
	}

}
