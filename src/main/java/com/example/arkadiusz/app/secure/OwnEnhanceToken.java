package com.example.arkadiusz.app.secure;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;


public class OwnEnhanceToken implements TokenEnhancer
    {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication)
        {
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(new HashMap<String, Object>()
            {{
            put("extra", authentication.getName());
            }});
        return accessToken;
        }
    }
