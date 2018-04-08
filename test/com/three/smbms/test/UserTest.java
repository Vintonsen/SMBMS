package com.three.smbms.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserTest {

	//关联日志
	private Logger logger = Logger.getLogger(UserTest.class);
	
	@Test
	public void TestCount(){
		String resource ="mybatis-config.xml";
		int count = 0;
		SqlSession session = null;
		try{
			//读取核心配置文件
			InputStream is = Resources.getResourceAsStream(resource);
			//创建SqlSessionFactory对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//创建SqlSession对象
			session = factory.openSession();
			count = session.selectOne("com.three.smbms.user.UserMapper.count");
			logger.debug("User count--->" + count);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//关闭session
			session.close();
		}

	}
}