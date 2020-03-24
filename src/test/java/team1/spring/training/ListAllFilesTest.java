package team1.spring.training;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(FileController.class)
public class ListAllFilesTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FileServiceInterface fileService;

    String fileLoction = "C:\\Uploads";

    @Test
    public void testControllerGetRequestForGivenFileAndReturnJsoArrayForAllFiles() throws Exception {

        File firstFile = new File(fileLoction, new java.util.Date().toString(),"firstFile");
        File secondFile = new File(fileLoction, new java.util.Date().toString(),"secondFile");
        File thirdFile = new File(fileLoction, new java.util.Date().toString(),"thirdFile");
        
        List<File> allFiles = Arrays.asList(firstFile,secondFile,thirdFile);
        given(fileService.getAllFiles()).willReturn(allFiles);

        mvc.perform(get("/user/files")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is((int)firstFile.getId())))
                .andExpect(jsonPath("$[0].name", is(firstFile.getName())))
                .andExpect(jsonPath("$[1].id", is((int)secondFile.getId())))
                .andExpect(jsonPath("$[1].name", is(secondFile.getName())))
                .andExpect(jsonPath("$[2].id", is((int)thirdFile.getId())))
                .andExpect(jsonPath("$[2].name", is(thirdFile.getName())));
        verify(fileService, VerificationModeFactory.times(1)).getAllFiles();
        reset(fileService);
    }
}