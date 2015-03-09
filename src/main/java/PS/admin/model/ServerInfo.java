package PS.admin.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ServerInfo {
	private final int id;
	private final String name;
	private final byte state;
	private final String address;
	private static final List<ServerInfo> serverInfo = new ArrayList<ServerInfo>();
	private static final ConcurrentHashMap<Integer, ServerDBInfo> serverDBInfo = new ConcurrentHashMap<Integer, ServerDBInfo>();
	
	public ServerInfo(int id, String name, byte state, String address) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.address = address;
	}
	
	public static void addServer(ServerInfo sif) {
		serverInfo.add(sif);
	}
	public static List<ServerInfo> getServerInfoList() {
		return Collections.unmodifiableList(serverInfo);
	}
	public static ServerInfo getServerInfo(int id) {
		return serverInfo.get(id-1);
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public byte getState() {
		return state;
	}
	public String getAddress() {
		return address;
	}

	public static void addServerDBInfo(int id, ServerDBInfo sdb) {
		serverDBInfo.putIfAbsent(id, sdb);
	}
	
	public static ConcurrentHashMap<Integer, ServerDBInfo> getServerDBInfo() {
		return  serverDBInfo;
	}
}
