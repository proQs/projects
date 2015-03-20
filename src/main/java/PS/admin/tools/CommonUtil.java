package PS.admin.tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import PS.admin.common.Config;
import PS.admin.model.ServerDBInfo;
import PS.admin.model.ServerInfo;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.mchange.v2.c3p0.ComboPooledDataSource;



public class CommonUtil {
	
	private static String accountsRegex = "[a-zA-Z0-9_]{6,20}";
	private static String passwordRegex = "[a-zA-Z0-9_~!@#$%^&*()+={}|\\[\\]:\"'<>?,./\\-]{6,20}";

	
	public static void LoadConfigMap(String file, HashMap<String,String> map, boolean clear){
		if(map != null)
		{
			if(clear)
				map.clear();
			
			InputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
			try
			{
				//fis = CommonUtil.class.getResourceAsStream(defaultPath + file);
				fis = new FileInputStream(System.getProperty("user.dir") + "/webapps/" + file);
	            isr = new InputStreamReader(fis, "UTF-8");
	            br = new BufferedReader(isr);
	            
	            String str = br.readLine();
	            while (str != null) {
	                str = str.trim();
	                String[] param = str.split(" ");
	                if(param.length > 1)
	                	map.put(param[0], param[1]);
	                str = br.readLine();
	            }
	            br.close();
	            isr.close();
	            fis.close();
	            
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
	            if (br != null) {
	                try {
	                    br.close();
	                }
	                catch (IOException ex) {}
	            }
	            if (isr != null) {
	                try {
	                    isr.close();
	                }
	                catch (IOException ex) {}
	            }
	            if (fis != null) {
	                try {
	                    fis.close();
	                } catch (IOException ex) {}
	            }
	        }
		}
	}
	
	public static void LoadConfigMap(String file, HashMap<String,String> map){
		LoadConfigMap(file, map, true);
	}
	
	public static HashMap<String,String> loadConfigMap(String file){
        HashMap<String,String> map = new HashMap<String,String>();
        LoadConfigMap(file, map, true);
        return map;
	}
	
	public static void loadConfigsMap(String file, HashMap<String,String[]> map, boolean clear){
		if(map != null)
		{
			if(clear)
				map.clear();
			
			InputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
			try
			{
				//fis = CommonUtil.class.getResourceAsStream(defaultPath + file);
				fis = new FileInputStream(System.getProperty("user.dir") + "/webapps/" + file);
	            isr = new InputStreamReader(fis, "UTF-8");
	            br = new BufferedReader(isr);
	            
	            String str = br.readLine();
	            while (str != null) {
	                str = str.trim();
	                String[] param = str.split(" ");
	                if(param.length > 1)
	                {
	                	String[] params = new String[param.length - 1];
	                	for(int i = 0; i < params.length; i++)
	                		params[i] = param[i + 1];
	                	map.put(param[0], params);
	                }
	                str = br.readLine();
	            }
	            br.close();
	            isr.close();
	            fis.close();
	            
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
	            if (br != null) {
	                try {
	                    br.close();
	                }
	                catch (IOException ex) {}
	            }
	            if (isr != null) {
	                try {
	                    isr.close();
	                }
	                catch (IOException ex) {}
	            }
	            if (fis != null) {
	                try {
	                    fis.close();
	                } catch (IOException ex) {}
	            }
	        }
		}
	}
	
	public static void loadConfigsMap(String file, HashMap<String,String[]> map){
		loadConfigsMap(file, map, true);
	}
	
	public static Vector<String[]> loadConfigVector(String file){
		Vector<String[]> vector = new Vector<String[]>();
		loadConfigVector(file, vector, true);
        return vector;
	}
	
	public static void loadConfigVector(String file, Vector<String[]> vector, boolean clear){
		if(vector != null)
		{
			if(clear)
				vector.clear();
			
			InputStream fis = null;
	        InputStreamReader isr = null;
	        BufferedReader br = null;
			try
			{
				//fis = CommonUtil.class.getResourceAsStream(defaultPath + file);
				fis = new FileInputStream(System.getProperty("user.dir") + "/webapps/" + file);
	            isr = new InputStreamReader(fis, "UTF-8");
	            br = new BufferedReader(isr);
	            
	            String str = br.readLine();
	            while (str != null) {
	                str = str.trim();
	                String[] param = str.split(" ");
	                if(param.length > 0)
	                	vector.add(param);
	                str = br.readLine();
	            }
	            br.close();
	            isr.close();
	            fis.close();
	            
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
	            if (br != null) {
	                try {
	                    br.close();
	                }
	                catch (IOException ex) {}
	            }
	            if (isr != null) {
	                try {
	                    isr.close();
	                }
	                catch (IOException ex) {}
	            }
	            if (fis != null) {
	                try {
	                    fis.close();
	                } catch (IOException ex) {}
	            }
	        }
		}
	}
	
	public static void loadConfigVector(String file, Vector<String[]> vector){
		loadConfigVector(file, vector, true);
	}
	
	private static byte[] key;
	private static byte[] keyiv;
	
	public static boolean decodeKey(){
		try {
			key = new BASE64Decoder().decodeBuffer(Config.key1);
			keyiv = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static byte[] decodeBuffer(byte buffer[]){
		try {
			return DES3.des3DecodeCBC(key, keyiv, buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] encodeBuffer(byte buffer[]){
		try {
			return DES3.des3EncodeCBC(key, keyiv, buffer);
		} catch (Exception e) {
		}
		return null;
	}
	
	public static DataInputStream getDataInputStreamFromRequest(HttpServletRequest req, boolean decode){
		ServletInputStream inputStream;
		try {
			inputStream = req.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			
			byte data[] = new byte[req.getContentLength()];
			bis.read(data);
			
			if(decode)
				data = decodeBuffer(data);
			
			if(data != null)
				return new DataInputStream(new ByteArrayInputStream(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean checkAccountsMatches(String accounts){
		return accounts.matches(accountsRegex);
	}
	
	public static boolean checkPasswordMatches(String password){
		return password.matches(passwordRegex);
	}
	
	
	public static String getCurtimeString(){
		Date date = new Date(System.currentTimeMillis());
		return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG).format(date);
	}
	
	public static PSDataInputStream getPSDataStream(String url) {
		PSDataInputStream dis = null;
		HttpURLConnection httpConnection = null;
		try {
			DataInputStream in = null;
			URL realUrl;
			realUrl = new URL(url);
			httpConnection = (HttpURLConnection) realUrl.openConnection();
			httpConnection.setConnectTimeout(2000);
			httpConnection.setReadTimeout(2000);
			httpConnection.setRequestMethod("POST");
			httpConnection.setDoOutput(true);

			OutputStream os = httpConnection.getOutputStream();
			System.err.println(httpConnection.getResponseCode());
			os.write(new byte[2]);
			os.flush();
			os.close();
			in = new DataInputStream(httpConnection.getInputStream());
			dis = PSDataInputStream.create(in, -1, CommonUtil.decodeKey());
			return dis;
		} catch (SocketTimeoutException e) {
			log.info(url + "连接超时!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			log.info(url + "服务器未启动!");
		} finally {
			if (httpConnection != null) {
				httpConnection.disconnect();
			}
		}
		return dis;
	}

	private static Logger log = Logger.getLogger(CommonUtil.class);
	
	public static boolean connectLogDB(String logdb, Integer serverId) {
		try {
			ServerDBInfo sdb = ServerInfo.getServerDBInfo().get(serverId);
			String logURL = "jdbc:mysql://" + sdb.getLogAddress();
			log.info("url="+ logURL + "user=" + sdb.getLogUser() + "psw=" +sdb.getLogPassWord());
			if (!testConnect(sdb, logURL)) {
				return false;
			}
			C3p0Plugin cp = setC3P0Config(sdb, logURL, "testpslog");
			ActiveRecordPlugin arp = new ActiveRecordPlugin(logdb, cp);
			arp.setDialect(new MysqlDialect());
			arp.setShowSql(true);
			arp.start();
			log.info("连接--"+logdb+"--成功");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param sdb
	 * @param DBURL
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static boolean testConnect(ServerDBInfo sdb, String DBURL) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBURL, sdb.getLogUser(), sdb.getLogPassWord());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return true;
	}

	/**
	 * @param sdb
	 * @param DBRUL
	 * @param testTable 
	 * @return
	 */
	private static C3p0Plugin setC3P0Config(ServerDBInfo sdb, String DBRUL, String testTable) {
		C3p0Plugin cp = new C3p0Plugin(DBRUL, sdb.getLogUser(), sdb.getLogPassWord());
		cp.setInitialPoolSize(4);
		cp.setMinPoolSize(4);
		cp.setMaxPoolSize(15);
		cp.setMaxIdleTime(60);
		cp.start();
		ComboPooledDataSource ds = (ComboPooledDataSource)cp.getDataSource();
		ds.setAcquireRetryAttempts(5);
		ds.setAutomaticTestTable(testTable);
		ds.setIdleConnectionTestPeriod(3600 * 7);
		ds.setMaxStatements(0);
		ds.setMaxStatementsPerConnection(100);
		return cp;
	}
	
	public static boolean connectGameDB(String gamedb, Integer serverId) {
		try {
			ServerDBInfo sdb = ServerInfo.getServerDBInfo().get(serverId);
			String gameURL = "jdbc:mysql://" + sdb.getDbAddress();
			log.info("url="+ gameURL);
			if (!testConnect(sdb, gameURL)) {
				return false;
			}
			C3p0Plugin cp = setC3P0Config(sdb, gameURL, "testpsworld");
			ActiveRecordPlugin arp = new ActiveRecordPlugin(gamedb, cp);
			arp.setDialect(new MysqlDialect());
			arp.setShowSql(true);
			arp.start();
			log.info("连接--"+gamedb+"--成功");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String getLogTable(Date date) {
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(date);
		String table_name = String.format("%s_%d_%d_%d", "Table_GameLog", 
					toCalendar.get(Calendar.YEAR), toCalendar.get(Calendar.MONTH) + 1, toCalendar.get(Calendar.DAY_OF_MONTH));
		log.info("table_name = " + table_name);
		return table_name;
	}
	
	public static void getServerInfo(ClassLoader classLoader) {
		try {
			InputStream proIn = classLoader.getResourceAsStream("/serverList.properties");
			Properties pro = new Properties();
			pro.load(proIn);
			String url = pro.getProperty("url_serverList") + "/GetIP.do";
			PSDataInputStream dis = CommonUtil.getPSDataStream(url);
			if (dis == null) {
				return;
			}
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
	
	public static <T> List<T> callSingleThread(Callable<List<T>> task) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<List<T>> future = executor.submit(task);
		List<T> ls = null;
		try {
			ls = future.get(5000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("futureException", e);
			future.cancel(true);
			return null;
		} finally {
			executor.shutdownNow();
		}
		return ls;
	}
	
	public static boolean runSingleThread(Runnable task) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> future = executor.submit(task);
		try {
			future.get(10000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("futureException", e);
			future.cancel(true);
			return false;
		} finally {
			executor.shutdownNow();
		}
		return true;
	}
}
