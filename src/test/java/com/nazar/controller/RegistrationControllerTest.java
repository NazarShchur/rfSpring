package com.nazar.controller;

import com.nazar.dto.UserDTO;
import com.nazar.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    RegistrationController reg;
    @Test
    public void addUsualUser() {
        Mockito.when(userService.checkUser(Mockito.any(), Mockito.anyMap())).thenReturn(true);
        reg.addUsualUser(new UserDTO(), new HashMap<String, Object>());
        Mockito.verify(userService).saveNewUser(Mockito.any());

    }
}