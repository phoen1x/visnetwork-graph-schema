package de.livingfire.demo.documentation.util;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;

public class DoNothingResultHandler implements ResultHandler {

    @Override
    public void handle(MvcResult result) throws Exception {
        // do nothing loop
    }

}
