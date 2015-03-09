package PS.admin.service;

import java.io.IOException;
import java.util.Map;

import PS.admin.model.ServerDBInfo;
import PS.admin.model.ServerInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.PSDataInputStream;

public class SelectSvService extends BaseService {

	public static final SelectSvService service = new SelectSvService();

	public void getDBInfo(Integer serverId) {
		Map<Integer, ServerDBInfo> sdb = ServerInfo.getServerDBInfo();
		if (sdb.containsKey(serverId)) {
			return;
		}

		ServerInfo serverInfo = ServerInfo.getServerInfo(serverId);
		String url = "http://" + serverInfo.getAddress() + "/PSServer/GetIP.do";
		PSDataInputStream dis = CommonUtil.getPSDataStream(url);
		if (dis == null) {
			return;
		}
		try {
			String logAddress = dis.readUTF();
			String logUser = dis.readUTF();
			String logPassWord = dis.readUTF();
			String dbAddress = dis.readUTF();
			String dbUser = dis.readUTF();
			String dbPassWord = dis.readUTF();
			ServerDBInfo db = new ServerDBInfo(logAddress, logUser, logPassWord, dbAddress, dbUser, dbPassWord);
			ServerInfo.addServerDBInfo(serverId, db);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

}
