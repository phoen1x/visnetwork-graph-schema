package de.livingfire.demo.documentation;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.UriConfigurer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.livingfire.demo.documentation.service.ApiDocumentation;
import de.livingfire.demo.documentation.util.DoNothingResultHandler;
import de.livingfire.demo.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDocumentationTest {

    private static final String RUN_DOCUMENT_API_ERROR = "RUN_DOCUMENTATION_API_ERROR";
    private static final String RUN_DOCUMENT_API_INDEX = "RUN_DOCUMENTATION_API_INDEX";

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Mock
    private PersonRepository personRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ResultHandler printDebug;

    @Before
    public void setUp() throws IOException {

        printDebug = new DoNothingResultHandler();
        // DEBUG:
        // printDebug = print();

        MockitoAnnotations.initMocks(this);

        UriConfigurer documentationConfiguration = documentationConfiguration(this.restDocumentation).uris()
                                                                                                     .withScheme("http")
                                                                                                     .withHost(
                                                                                                             "demo.livingfire.local")
                                                                                                     .withPort(80);

        mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                                 .apply(documentationConfiguration)
                                 .build();

    }

    @Test
    public void document() throws IOException {
        documentApi();
    }

    private void documentApi() {
        Stream.of(RUN_DOCUMENT_API_INDEX, RUN_DOCUMENT_API_ERROR)
              .sequential()
              .forEach(task -> {
                  switch (task) {
                  case RUN_DOCUMENT_API_INDEX:
                      ApiDocumentation.apiIndex(mockMvc, printDebug);
                      break;

                  case RUN_DOCUMENT_API_ERROR:
                      ApiDocumentation.apiError(mockMvc, printDebug);
                      break;

                  default:
                      throw new RuntimeException("unknown documentation task: " + task);
                  }
              });
    }

}
