//package com.example.userdemo;
//
//
//import com.example.userdemo.model.User;
//import com.example.userdemo.repository.UserRepository;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//import java.util.Date;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
////import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//@DataJpaTest
////@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
////public class UserRepositoyTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private User user;
//
//    @BeforeEach
//    public void setup()
//    {
//        user=new User(9,"raj","karthi","raj@gmail.com","987456321","1122","hgchchgchcj",22);
//    }
//
//    @AfterEach
//    public void destroy()
//    {
//        userRepository.delete(user);
//      user=null;
//    }
//
////    @Test
////    public void updateUser(){
////
////        assertEquals(user,userRepository.save(user));
////    }
//
//    @Test
//    public void deleteUser(){
//
//        userRepository.save(user);
//        System.out.println(user.getUserId());
//        userRepository.deleteById(user.getUserId());
//        assertEquals(Optional.empty(),userRepository.findById(user.getUserId()));
//    }
//
////    @Test
////    public void deleteUser(){
////        System.out.println( userRepository.save(user));
////   userRepository.save(user);
////   userRepository.deleteById(user.getUserId());
////        assertEquals(Optional.empty(),userRepository.findById(user.getUserId()));
////    }
//
//}
