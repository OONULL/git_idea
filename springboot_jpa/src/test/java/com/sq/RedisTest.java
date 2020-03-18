package com.sq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sq.pojo.Customer;
import com.sq.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void redisTest() throws JsonProcessingException {

        //从redis中获取数据，数据格式为json字符串
        String json = redisTemplate.boundValueOps("customer.findAll").get();
        //判断是否存在
        if(null==json){
            //不存在，从数据库获取
            List<Customer> customers = customerRepository.findAll();
            //把数据存储到redis缓存中
            //将集合转换为json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String customersjson = objectMapper.writeValueAsString(customers);

            redisTemplate.boundValueOps("customer.findAll").set(customersjson);

            System.out.println("数据库中的");

        }else {

            System.out.println("redis缓存中的");
        }



    }
}
