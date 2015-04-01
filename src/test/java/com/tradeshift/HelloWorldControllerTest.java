package com.tradeshift;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.tradeshift.controller.HelloWorldController;

public class HelloWorldControllerTest {

    @Test
    public void checkIfViewIsReturnedCorrectly() {
        ModelAndView modelAndView = new HelloWorldController().Index();
        Assert.assertEquals("index", modelAndView.getViewName());
    }
}
