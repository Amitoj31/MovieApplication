package com.niit.userservice;



import com.niit.userservice.controller.UserController;
import com.niit.userservice.model.User;
import com.niit.userservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

     @Mock
    private UserService userService;

     @InjectMocks
    private UserController userController;

     private User user;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup()
    {

      user=new User(1,"raj","karthi","raj@gmail.com","987456321","1122","hgchchgchcj",22,new String[]{"fgfgf"});
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }

    @AfterEach
    public void destroy()
    {
        user=null;
    }

    @Test
    public void addUser() throws Exception{
    when(userService.saveUser(any())).thenReturn(user);


        mockMvc.perform(
                        post("/movie/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJson(user)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }


    @Test
    public void updateUser() throws Exception{
        when(userService.updateUser(any())).thenReturn(user);

        mockMvc.perform(
                        put("/movie/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJson(user)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }



    public static String convertToJson(final Object obj) throws Exception {
        String result="";
        System.out.println(obj);

        try{
            ObjectMapper mapper=new ObjectMapper();
            result=mapper.writeValueAsString(obj);
        }
        catch(JsonProcessingException ex){
            ex.printStackTrace();
            result="JsonProcessingException";
        }

        return result;
    }
}
