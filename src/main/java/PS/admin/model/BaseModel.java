package PS.admin.model;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public abstract class BaseModel <M extends Model<M>> extends Model<M>{

	protected static Logger log = Logger.getLogger(BaseModel.class);
}
