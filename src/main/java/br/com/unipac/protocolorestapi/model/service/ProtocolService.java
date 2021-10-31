package br.com.unipac.protocolorestapi.model.service;

import br.com.unipac.protocolorestapi.model.domain.Protocol;

import java.util.List;

public interface ProtocolService extends CrudService<Protocol, Long> {
    List<Protocol> findAllByName(String name, int pageNumber, int size);
}
