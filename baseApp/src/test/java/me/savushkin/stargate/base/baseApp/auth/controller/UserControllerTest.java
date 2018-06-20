package me.savushkin.stargate.base.baseApp.auth.controller;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void createUserTest() throws Exception {
        User user = (User) controller.createUser(new User()).getBody();
    }

    @Test
    public void getPageUserTest() throws Exception {
        controller.getPage(0, 25).getBody();
    }

    @Test
    public void getUserTest() throws Exception {
        controller.getUser(42L).getBody();
    }


}
