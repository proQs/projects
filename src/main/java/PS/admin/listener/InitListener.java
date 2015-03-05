package PS.admin.listener;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

		DataInputStream in = null;
		URL realUrl;
		try {
			InputStream proIn = getClass().getClassLoader().getResourceAsStream("/serverList.properties");
			Properties pro = new Properties();
			pro.load(proIn);
			String url = pro.getProperty("url_serverList") + "/GetIP.do";
			realUrl = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection)realUrl.openConnection();
			httpConnection.setRequestMethod("POST");
			httpConnection.setDoOutput(true);
			
			OutputStream os = httpConnection.getOutputStream();
			System.err.println(httpConnection.getResponseCode());
			os.write(new byte[2]);
			os.flush();
			os.close();
			in = new DataInputStream(httpConnection.getInputStream());
			PSDataInputStream dis = PSDataInputStream.create(in, -1, CommonUtil.decodeKey());
			int length = dis.readShort();
			for (int i = 0; i < length; i++) {
				int id = dis.read();
				String name = dis.readUTF();
				byte state = dis.readByte();
				String address = dis.readUTF();
				ServerInfo.addServer(new ServerInfo(id, name, state, address));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
