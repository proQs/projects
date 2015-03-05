package PS.admin.tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;



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
			// TODO Auto-generated catch block
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
}