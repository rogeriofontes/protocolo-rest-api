package br.com.unipac.protocolorestapi.model.repositories;

import br.com.unipac.protocolorestapi.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
