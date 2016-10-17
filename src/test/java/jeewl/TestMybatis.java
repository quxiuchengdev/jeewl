package jeewl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatis {

	public static void main(String[] args) {
		ApplicationContext application=new ClassPathXmlApplicationContext("classpath:/spring/spring-context.xml","classpath:/spring/spring-context-db.xml"); 
//		
		//application.getBean("menuService");
		Object obj = application.getBean("sqlSessionFactory");
//		org.apache.ibatis.session.defaults.DefaultSqlSessionFactory sqlf = (DefaultSqlSessionFactory) obj;
//	//	System.out.println(obj.getClass().getName());
//		SqlSession session = sqlf.openSession();
//		
//		//Object Object = session.selectOne("com.qxcwl.jeewl.modules.sys.dao.MenuDao.get");
//		//System.out.println(Object);
//		//session.s
//		
//		List<Object> list = session.selectList("com.qxcwl.jeewl.modules.sys.dao.MenuDao.findList", new Menu());
//		for (Object object : list) {
//			System.out.println(object);
//		}
//		
//		
	}
}
