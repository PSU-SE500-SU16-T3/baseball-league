package com.team3.dao;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.team3.business.models.User;

public class DaoImplTest {
	
	DaoImpl daoImpl;
	//Dao mockDaoImpl;
	JdbcTemplate mockJdbcTemplate;
	
	@Before  
    public void setUp() {  
		daoImpl = new DaoImpl();
		mockJdbcTemplate = EasyMock.createMock(JdbcTemplate.class);
		daoImpl.setDbTemplate(mockJdbcTemplate);
    }  
  
    @After  
    public void tearDown() {  
    	//mockDaoImpl = null; 
    	mockJdbcTemplate = null;
    }
    
    //@Test
    public void testInsertUser() throws Exception {
    	
    	String sql = "select * from t1";
        Object[] params = new Object[] { 1001 };
        RowMapper<Integer> rm = EasyMock.createMock(RowMapper.class);
        
    	User mockUser = EasyMock.createMock(User.class);
    	EasyMock.expect(mockUser.getUserName()).andReturn("abc").anyTimes();
    	EasyMock.expect(mockUser.getUserPassword()).andReturn("Password").anyTimes();
    	EasyMock.expect(mockUser.getUserEmail()).andReturn("abc@gmail.com").anyTimes();
    	EasyMock.expect(mockUser.getPersonID()).andReturn(10001).anyTimes();
    	EasyMock.expect(mockUser.getUserRole()).andReturn(10002).anyTimes();
    	EasyMock.replay(mockUser);
    	
    	EasyMock.expect(mockJdbcTemplate.update(EasyMock.isA(String.class), EasyMock.isA(Object[].class))).andReturn(1).anyTimes();
    	EasyMock.expect(mockJdbcTemplate.queryForObject(sql, params, rm)).andReturn(10001).anyTimes();
    	EasyMock.replay(mockJdbcTemplate);
    	
    	int response = daoImpl.insertUser(mockUser);
    	
    	assertEquals(10001, response);
    	
    	EasyMock.verify(mockUser);
    	//EasyMock.verify(mockDaoImpl);
    	EasyMock.verify(mockJdbcTemplate);
    }
}