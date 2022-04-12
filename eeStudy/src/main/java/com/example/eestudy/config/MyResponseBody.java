package com.example.eestudy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

public class MyResponseBody implements ResponseBodyAdvice {

    private objectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return false;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("status",0);
        map.put("data",body);
        map.put("msg","");
        if(body instanceof String){
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return objectMapper.writeValueAsString(map);
        }
        return map;
    }
}
