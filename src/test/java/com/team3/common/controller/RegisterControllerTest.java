package com.team3.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team3.business.handler.RegisterUser;

public class RegisterControllerTest {
	RegisterController registerController;
	RegisterUser registerUser;
	
	@Before  
    public void setUp() {  
		registerUser = EasyMock.createMock(RegisterUser.class);
		registerController = new RegisterController();
		registerController.setRegisterUser(registerUser);
    }  
  
    @After  
    public void tearDown() {  
    	registerUser = null; 
    }
    
    @Test
    public void testAddperson() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	registerUser.addperson(mockArguments);  
        EasyMock.expectLastCall();
        
        EasyMock.replay(registerUser);
        
        registerController.addperson(mockArguments);
        
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testAddaddress() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	registerUser.addaddress(mockArguments);  
        EasyMock.expectLastCall();
        
        EasyMock.replay(registerUser);
        
        registerController.addaddress(mockArguments);
        
        EasyMock.verify(registerUser);
    }
    
    @Test
    public void testAddpayment() { 
    	Map<String,String> mockArguments = EasyMock.createMock(HashMap.class);
    	registerUser.addpayment(mockArguments);  
        EasyMock.expectLastCall();
        
        EasyMock.replay(registerUser);
        
        registerController.addpayment(mockArguments);
        
        EasyMock.verify(registerUser);
    }
}
