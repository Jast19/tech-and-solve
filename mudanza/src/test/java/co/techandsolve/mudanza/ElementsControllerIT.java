package co.techandsolve.mudanza;

import co.techandsolve.mudanza.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

@SpringBootTest
@ContextConfiguration(classes = {MudanzaApplication.class})
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ElementsControllerIT {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void validateApplicationContext() {
        ServletContext servletContext = wac.getServletContext();

        Assertions.assertNotNull(servletContext);
        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(wac.getBean("elementsController"));
    }

    @Test
    void downloadFileSuccess() throws Exception {

        String clientId = "1091668755";

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.multipart("/elements/upload/{id}", clientId)
                .file(new MockMultipartFile("file", DataUtil.home().getBytes())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assertions.assertEquals(DataUtil.RES, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void downloadFileFail() throws Exception {

        String clientId = "1091668755";

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.multipart("/elements/upload/{id}", clientId)
                .file(new MockMultipartFile("file", "fail".getBytes())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());

    }
}
