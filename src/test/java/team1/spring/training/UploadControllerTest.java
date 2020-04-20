package team1.spring.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import team1.spring.training.controller.MyWebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

@WebAppConfiguration
@ContextConfiguration(classes = MyWebConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UploadControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void test() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "filename.txt", "text/plain", "some xml".getBytes());

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/user/file")
                .file(file)
                .accept(MediaType.APPLICATION_JSON));
    }
}


