package jbr.webshop.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jbr.webshop.user.dao.UserDao;
import jbr.webshop.user.model.LoginEntity;
import jbr.webshop.user.model.UserResponseModel;
import jbr.webshop.user.service.UserServiceImpl;
import jbr.webshop.util.UserResponseModelImpl;

class UserServiceImplTest {

  @InjectMocks
  private UserServiceImpl userServiceMock;

  @Mock
  private UserDao userDaoMock;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  final void testValidate() throws Exception {
    UserResponseModelImpl input = new UserResponseModelImpl();

    when(userDaoMock.validate(any(LoginEntity.class))).thenReturn(input);

    UserResponseModel output = userServiceMock.validate(new LoginEntity());
    Assertions.assertNotNull(output);
    Assertions.assertEquals(input.getEmail(), output.getEmail());
  }

}

