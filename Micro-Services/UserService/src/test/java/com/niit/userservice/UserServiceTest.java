package com.niit.userservice;


import com.niit.userservice.exception.UserNotFoundException;
import com.niit.userservice.model.User;
import com.niit.userservice.repository.UserRepository;
import com.niit.userservice.service.UserServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userServiceImp;

    private User user;

    @BeforeEach
    public void setup()
    {
        user=new User(1,"raj","karthi","raj@gmail.com","987456321","1122","hgchchgchcj",22, new String[]{"fgfgf"});
    }

    @AfterEach
    public void destroy()
    {
        user=null;
    }

    @Test
    public void updateUser() throws UserNotFoundException {

        when(userRepository.save(user)).thenReturn(user);

       Assertions.assertEquals(user,userServiceImp.updateUser(user));

    }

    @Test
    public void deleteUser() throws UserNotFoundException {
        boolean result = userServiceImp.deleteUser(1);
        assertEquals(true,result);

    }



}
