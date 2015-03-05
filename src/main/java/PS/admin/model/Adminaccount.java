package PS.admin.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Administrator model.
 * 
mysql> desc adminaccount;
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| GID     | bigint(20)   | NO   | PRI | NULL    | auto_increment |
| name    | varchar(20)  | NO   |     | NULL    |                |
| password| char(20)     | NO   |     | NULL    |                |
| permission| TINYINT(3) | NO   |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+
 */
@SuppressWarnings("serial")
public class Adminaccount extends Model<Adminaccount> {
	public static final Adminaccount me = new Adminaccount();
}
