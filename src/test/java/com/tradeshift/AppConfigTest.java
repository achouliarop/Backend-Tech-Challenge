package com.tradeshift;


import com.tradeshift.resources.AppConfig;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.mock;

public class AppConfigTest {

    AppConfig mockAppConfig;

    @Before
    public void setUp() {
        this.mockAppConfig = mock(AppConfig.class);
    }

    @Test
    public void checkJdbcTemplateWhenDataSourceIsNull() {
        JdbcTemplate jdbcTemplate = mockAppConfig.jdbcTemplate(null);
        Assert.assertNull(jdbcTemplate);
    }
}
