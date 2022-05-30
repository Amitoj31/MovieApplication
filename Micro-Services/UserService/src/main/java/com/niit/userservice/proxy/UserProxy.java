package com.niit.userservice.proxy;

import com.niit.userservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="favouite-service", url="localhost:9001")
public interface UserProxy {
    @PostMapping("/movieapp/user-fav/adduser")
    public ResponseEntity<?> registeruser(@RequestBody User user);
}
