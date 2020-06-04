package tacos;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // Inject(注入) MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // 发起 get 请求
                .andExpect(status().isOk()) // 期望请求状态为 200
                .andExpect(view().name("Home")) // 期望请求视图为 Home
                .andExpect(content().string(
                        containsString("Welcome to..."))); // 期望内容包含 Welcome to ...

    }
}
