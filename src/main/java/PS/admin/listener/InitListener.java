package PS.admin.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import PS.admin.model.ServerInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.PSDataInputStream;

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

		try {
			InputStream proIn = getClass().getClassLoader().getResourceAsStream("/serverList.properties");
			Properties pro = new Properties();
			pro.load(proIn);
			String url = pro.getProperty("url_serverList") + "/GetIP.do";
			PSDataInputStream dis = CommonUtil.getPSDataStream(url);
			int length = dis.readShort();
			for (int i = 0; i < length; i++) {
				int id = dis.read();
				String name = dis.readUTF();
				byte state = dis.readByte();
				String address = dis.readUTF();
				ServerInfo.addServer(new ServerInfo(id, name, state, address));
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
}
