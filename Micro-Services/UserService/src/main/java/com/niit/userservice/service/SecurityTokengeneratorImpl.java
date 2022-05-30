package com.niit.userservice.service;

import com.niit.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokengeneratorImpl implements SecurityTokengenerator{


    @Override
    public Map<String, String> generateToken(User user) {
        Date cd=new Date();
        cd.setMinutes(cd.getMinutes()+40);
        String ans="";
        String jwttoken= Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date()).setExpiration(cd).signWith(SignatureAlgorithm.HS256,"mykey").compact();
        Map<String,String>map =new HashMap<>();
        ans=Integer.toString(user.getUserId());
        System.out.print(jwttoken);
        map.put("token",jwttoken);
        map.put("id",ans);
        return map;
    }

    }

