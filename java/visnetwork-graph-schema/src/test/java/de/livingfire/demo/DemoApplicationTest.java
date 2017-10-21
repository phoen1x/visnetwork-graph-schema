package de.livingfire.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.JsonPath;

import de.livingfire.demo.documentation.constant.RequestConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
        classes = DemoApplication.class)
public class DemoApplicationTest implements RequestConstant {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void pathHealthStatusShouldReturnUp() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity(REQUEST_MANAGEMENT_HEALTH, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        String actual = JsonPath.parse(response.getBody())
                                .read("$.status", String.class);
        assertThat(actual).startsWith("UP");
    }

}