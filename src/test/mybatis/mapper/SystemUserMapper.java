package test.mybatis.mapper;

import java.util.List;

import test.mybatis.bean.Role;
import test.mybatis.bean.SystemUser;



public interface SystemUserMapper {
	 SystemUser getUserInof(int uId);
	 SystemUser getUserRole(int uId);
	 
	 Role getRolePermission(int rid);
}
