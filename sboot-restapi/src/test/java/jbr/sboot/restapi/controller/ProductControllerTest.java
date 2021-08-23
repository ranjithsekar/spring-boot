package jbr.sboot.restapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import jbr.sboot.prod.ProductController;
import jbr.sboot.prod.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    final void testAddProduct() throws Exception {
        
    }
    
}
