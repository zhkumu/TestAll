package test.spring.jdbc.transaction;

import org.springframework.expression.AccessException;
import org.springframework.transaction.annotation.Transactional;

//默认情况下只有RuntimeException才会回滚，方法标注覆盖类上
@Transactional(noRollbackFor=RuntimeException.class)
public class TestService {
	private TestDao testDao;

	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
	public int getStudent(String  name) throws AccessException{
		int id = testDao.getStudent(name);
		throw new AccessException("hehe");
		//return id;
	}
}
