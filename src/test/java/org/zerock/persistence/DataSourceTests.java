package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.Chef;
import org.zerock.sample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = {@Autowired} ) //setter 메소드를 생성하면서 setter메소드에 자동으로 @autowired어노테이션을 추가하여 자동으로 의존성 주입이 된다.
	private DataSource dataSource;	
	
//		@Setter(onMethod_ = {@Autowired} ) 해당 방식을 사용안할 경우 
//    private DataSource dataSource;
//
//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
	
	private SqlSessionFactory sqlsessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlsessionFactory) {
		this.sqlsessionFactory = sqlsessionFactory;
	}
	
	@Test
	public void test() {
		
		try ( SqlSession session = sqlsessionFactory.openSession();
				Connection connection = dataSource.getConnection()) {
			
			log.info(session + "test");
			log.info(connection);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
