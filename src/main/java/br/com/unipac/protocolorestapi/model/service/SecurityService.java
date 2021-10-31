package br.com.unipac.protocolorestapi.model.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
    String getCurrentLogin();
    void logoff();
}
