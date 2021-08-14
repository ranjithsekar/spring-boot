package jbr.webshop.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import jbr.webshop.common.exception.ServiceException;
import jbr.webshop.user.dao.UserDaoImpl;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.service.UserServiceImpl;
import jbr.webshop.user.util.UserResponseModelImpl;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@Slf4j
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserServiceImpl userServiceMock;

  @MockBean
  private UserDaoImpl userDaoMock;

  @Test
  final void testValidate() throws ServiceException {
    UserResponseModelImpl input = new UserResponseModelImpl();

    when(userServiceMock.validate(any(LoginModel.class))).thenReturn(input);

    try {
      mockMvc.perform(post("${spring.data.rest.base-path}/user/validate").contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(input)))
          .andExpect(MockMvcResultMatchers.status()
              .isOk());
    } catch (Exception e) {
      log.error(e.getMessage());
    }

  }

}
