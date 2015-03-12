package PS.admin.service;

import java.io.IOException;
import java.util.Map;

import PS.admin.model.ServerDBInfo;
import PS.admin.model.ServerInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.PSDataInputStream;

public class SelectSvService extends BaseService {

	public static final SelectSvService service = new SelectSvService();

	public boolean getDBInfo(Integer serverId) {
		Map<Integer, ServerDBInfo> sdb = ServerInfo.getServerDBInfo();
		if (sdb.containsKey(serverId)) {
			return true;
		}

		ServerInfo serverInfo = ServerInfo.getServerInfo(serverId);
		String url = "http://" + serverInfo.getAddress() + "/GetIP.do";
		log.info(url);
		PSDataInputStream dis = CommonUtil.getPSDataStream(url);
		if (dis == null) {
			log.info("dis = null");
			return false;
		}
		try {
			String logAddress = dis.readUTF();
			String logUser = dis.readUTF();
			String logPassWord = dis.readUTF();
			String dbAddress = dis.readUTF();
			String dbUser = dis.readUTF();
			String dbPassWord = dis.readUTF();
			ServerDBInfo db = new ServerDBInfo(logAddress, logUser, logPassWord, dbAddress, dbUser, dbPassWord);
			log.info(logAddress + "-----------" + dbAddress);
			ServerInfo.addServerDBInfo(serverId, db);
			return true;
		}  catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
