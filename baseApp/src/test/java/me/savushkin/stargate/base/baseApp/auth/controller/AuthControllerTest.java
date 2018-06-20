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
public class AuthControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AuthController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void loginTest() throws Exception {
        User user = (User) controller.login("commander", "derparol").getBody();
    }

    @Test
    public void logoutTest() throws Exception {
//        User user = (User) controller.logout().getBody();
    }
}
