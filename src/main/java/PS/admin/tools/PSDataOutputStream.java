package PS.admin.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PSDataOutputStream extends DataOutputStream {
	
	private ByteArrayOutputStream baos;
	private OutputStream out;
	private boolean encode;
	
	private PSDataOutputStream(OutputStream out) {
		super(out);
	}
	
	public static PSDataOutputStream create(OutputStream out, boolean encode){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PSDataOutputStream stream = new PSDataOutputStream(baos);
		stream.baos = baos;
		stream.out = out;
		stream.encode = encode;
		return stream;
	}
	
	public void close() throws IOException{
		byte data[] = toByteArray();
		out.write(data);
		super.close();
	}
	
	public byte[] toByteArray(){
		byte data[] = baos.toByteArray();
		if(encode)
			data = CommonUtil.encodeBuffer(data);
		return data;
	}
	
}
