package PS.admin.tools;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PSDataInputStream extends DataInputStream {
	
	public PSDataInputStream(InputStream in) {
		super(in);
	}
	
	public static PSDataInputStream create(InputStream in, int length, boolean decode){
		try {
			byte data[];
			if(length <= 0)
				data = new byte[in.available()];
			else
				data = new byte[length];
			in.read(data);
			
			if(decode)
				data = CommonUtil.decodeBuffer(data);
			
			if(data != null){
				ByteArrayInputStream bais = new ByteArrayInputStream(data);
				PSDataInputStream dis = new PSDataInputStream(bais);
				return dis;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
