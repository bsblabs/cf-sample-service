package com.bsb.showcase.cf.dashboard.security;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.bsb.showcase.cf.dashboard.AbstractDashboardTest;

/**
 * @author Sebastien Gerard
 */
public class UaaLogoutRedirectStrategyTest extends AbstractDashboardTest {

    @Test
    public void sendRedirect() throws IOException {
        final UaaLogoutRedirectStrategy strategy = new UaaLogoutRedirectStrategy("http://uaa.domain.com");

        final MockHttpServletResponse response = new MockHttpServletResponse();
        strategy.sendRedirect(new MockHttpServletRequest(), response, "http://myApp.domain.com");

        assertEquals("http://uaa.domain.com?redirect=http://myApp.domain.com", response.getRedirectedUrl());
    }
}