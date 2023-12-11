package model.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericMapper<T> {
	// mapperItem
	T mapItem(ResultSet resultSet) throws SQLException ;
}
