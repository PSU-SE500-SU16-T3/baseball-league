package com.team3.common.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.handler.RegisterUser;
import com.team3.business.models.PlayerRole;
import com.team3.business.models.Response;


public class AuthControllerTest {
	AuthController authController;
	RegisterUser registerUser;

	
	@Before  
    public void setUp() {  
		registerUser = EasyMock.createMock(RegisterUser.class);
		authController = new AuthController();
		authController.setRegisterUser(registerUser);
    }  
  
    @After  
    public void tearDown() {  
    	registerUser = null; 
    }
    
    @Test
    public void testLogin() { 
    	
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	PlayerRole mockPlayerRole = EasyMock.createMock(PlayerRole.class);
    	
    	EasyMock.expect(registerUser.getUserDetails(mockArguments)).andReturn(mockPlayerRole).anyTimes();  
        EasyMock.replay(registerUser);
        
        EasyMock.expect(mockPlayerRole.getRoleId()).andReturn("10000").anyTimes();  
        EasyMock.replay(mockPlayerRole);
        
        Response<PlayerRole> response = authController.login(mockArguments);
        
        assertEquals(response.getStatus(), "success");
        
        EasyMock.verify(registerUser);
        EasyMock.verify(mockPlayerRole);
    }
}
