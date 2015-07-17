package test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

import test.mybatis.bean.Role;
import test.mybatis.bean.SystemUser;
import test.mybatis.mapper.SystemUserMapper;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("java.class.path" ));
		InputStream input=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=SqlSessionManager.newInstance(input);
		SqlSession session=factory.openSession();
		SystemUserMapper mapper= session.getMapper(SystemUserMapper.class);
		SystemUser user=mapper.getUserInof(1);
		System.out.println(user.getRole().getPermissions().size());
		//Role role=mapper.getRolePermission(1);
		//System.out.println(role.getPermissions().size());
	}

}
