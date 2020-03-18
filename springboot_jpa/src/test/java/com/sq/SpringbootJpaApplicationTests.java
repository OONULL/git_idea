package com.sq;

import com.sq.pojo.Customer;
import com.sq.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
class SpringbootJpaApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
   public void test () {

        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
