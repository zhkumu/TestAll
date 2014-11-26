package test.mybatis.one.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MyTypeHandler extends BaseTypeHandler<Date> {

	@Override
	public Date getNullableResult(ResultSet set, String columnLabel) throws SQLException {
		return intToDate(set.getInt(columnLabel));
	}

	@Override
	public Date getNullableResult(ResultSet set, int columnIndex) throws SQLException {
		return intToDate(set.getInt(columnIndex));
	}

	@Override
	public Date getNullableResult(CallableStatement cs, int parameterIndex)
			throws SQLException {
		return intToDate(parameterIndex);
	}

	 /** 
	4.     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型 
	5.     * @param ps 当前的PreparedStatement对象 
	6.     * @param i 当前参数的位置 
	7.     * @param parameter 当前参数的Java对象 
	8.     * @param jdbcType 当前参数的数据库类型 
	9.     * @throws SQLException 
	10.     */  
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jt) throws SQLException {
		//由于BaseTypeHandler中已经把parameter为null的情况做了处理，所以这里我们就不用再判断parameter是否为空了，直接用就可以了  
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String result=format.format(date).replaceAll("-", "");
		ps.setInt(i, Integer.parseInt(result));     
	}
	
	private Date intToDate(int value){
		String dateStr=String.valueOf(value);
		String year=dateStr.substring(0,4);
		String month=dateStr.substring(4,6);
		String day=dateStr.substring(6);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = format.parse(year+"-"+month+"-"+day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
