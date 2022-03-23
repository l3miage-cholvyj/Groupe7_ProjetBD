package groupe7.bd.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public abstract class Dao {
	protected Connection conn;
	
	protected Dao(Connection conn) {
		this.conn = conn;
	}
}
