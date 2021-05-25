package jbr.swagger.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jbr.swagger.dao.ProductDao;
import jbr.swagger.model.ProductModel;

public class ProductServiceImplTest {

  @InjectMocks
  private ProductServiceImpl serviceMock;
  @Mock
  private ProductDao productDaoMock;

  @BeforeEach
  public void init() {
      MockitoAnnotations.initMocks(this);
  }

  @Test
  final void testAddProduct() throws Exception {
    ProductModel inputProduct = new ProductModel("100", "Dell Laptop", "Laptop", "55000");

    when(productDaoMock.addProduct(any())).thenReturn(inputProduct);

    ProductModel outputProduct = serviceMock.addProduct(inputProduct);

    Assertions.assertNotNull(outputProduct);
    Assertions.assertEquals(inputProduct.getName(), outputProduct.getName());
  }

}
