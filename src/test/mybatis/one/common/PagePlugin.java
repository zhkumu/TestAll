package test.mybatis.one.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import ch.qos.cal10n.Cal10nConstants;

@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PagePlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("拦截器主要处理逻辑");
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation
				.getTarget();

		BaseStatementHandler delegate = (BaseStatementHandler) ClassUtil.getFieldValue(
				handler, "delegate");

		BoundSql boundSql = delegate.getBoundSql();

		
		Object params = boundSql.getParameterObject();

		if (params != null && params instanceof PagedList) {
			Connection connection = (Connection) invocation.getArgs()[0];

			PagedList pagedList=(PagedList)params;
			
			String sql = boundSql.getSql();

			sql += " limit 1 , 20";

			ClassUtil.setFieldValue(boundSql, "sql", sql);
		}

		

		return invocation.proceed();
	}

	/**
	 * 对目标对象进行处理
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("此处没有对目标对象进行任何处理");
		return Plugin.wrap(target, this);
	}

	/***
	 * 获取配置文件中插件的属性值
	 */
	@Override
	public void setProperties(Properties properties) {
		String result = properties.getProperty("info");
		System.out.println("配置文件中的info属性的值为：" + result);
	}

	private int getTotalCount(Connection connection,BaseStatementHandler baseStatementHandler, String sql){

//		int index=sql.indexOf(" form ");
//		 sql+="select (1) "+sql.substring(index);
//		 PreparedStatement countStmt = connection.prepareStatement(sql); 
//		 BoundSql boundSql = baseStatementHandler.getBoundSql();
//		 MappedStatement mappedStatement= (MappedStatement)ClassUtil.getFieldValue(baseStatementHandler, "mappedStatement");
//	
//		 BoundSql countSql=new BoundSql(mappedStatement.getConfiguration(), sql,boundSql.getParameterMappings(), boundSql.getParameterObject());
		return 0;

	}
	
}
