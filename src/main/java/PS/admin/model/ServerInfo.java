package PS.admin.model;

import java.util.ArrayList;
import java.util.List;

public class ServerInfo {
	private int id;
	private String name;
	private byte state;
	private String address;
	private static List<ServerInfo> serverInfoList = new ArrayList<ServerInfo>();
	
	public ServerInfo(int id, String name, byte state, String address) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.address = address;
	}
	
	public static void addServer(ServerInfo sif) {
		serverInfoList.add(sif);
	}
	public static List<ServerInfo> getServerInfoList() {
		return serverInfoList;
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
	
}
