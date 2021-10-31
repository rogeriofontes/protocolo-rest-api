package br.com.unipac.protocolorestapi.model.service;

import br.com.unipac.protocolorestapi.exception.BadResourceException;
import br.com.unipac.protocolorestapi.exception.ResourceAlreadyExistsException;
import br.com.unipac.protocolorestapi.exception.ResourceNotFoundException;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T, ID extends Serializable> {
    boolean existsById(ID id);
    T findById(ID id) throws ResourceNotFoundException;
    List<T> findAll(int pageNumber, int rowPerPage) throws ResourceNotFoundException;
    T save(T t) throws ResourceAlreadyExistsException, BadResourceException;
    T update(ID id, T t) throws ResourceNotFoundException, BadResourceException;
    void deleteById(ID id) throws ResourceNotFoundException;
    ID count();
}
