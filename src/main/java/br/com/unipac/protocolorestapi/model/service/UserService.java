package br.com.unipac.protocolorestapi.model.service;

import br.com.unipac.protocolorestapi.model.domain.User;

import java.util.Optional;

public interface UserService {
    void save(User user);
    Optional<User> findByUsername(String username);
}
