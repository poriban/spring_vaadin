package com.example.application.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Security Service
 */
@Component
public class SecurityService {

    // メンバー変数
    private final AuthenticationContext authenticationContext;

    // コンストラクタ
    public SecurityService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    // ユーザー情報取得
    public UserDetails getAuthenticatedUser() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class).get();
    }

    // ログアウト
    public void logout() {
        authenticationContext.logout();
    }
}