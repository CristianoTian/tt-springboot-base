package com.hy.tt.util;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @auther thy
 * @date 2019/5/27
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
