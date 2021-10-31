package br.com.unipac.protocolorestapi.web.resources;

import br.com.unipac.protocolorestapi.exception.BadResourceException;
import br.com.unipac.protocolorestapi.exception.ResourceAlreadyExistsException;
import br.com.unipac.protocolorestapi.exception.ResourceNotFoundException;
import br.com.unipac.protocolorestapi.model.domain.Protocol;
import br.com.unipac.protocolorestapi.model.service.ProtocolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/protocols")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProtocolResources {

    private final ProtocolService protocolService;

    @GetMapping
    public ResponseEntity<List<Protocol>> findAll(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                                  @RequestParam(value = "size", defaultValue = "1") int size,
                                                  @RequestParam(required = false) String name) throws ResourceNotFoundException {
        if (!StringUtils.isEmpty(name)) {
            List<Protocol> protocolListByName = protocolService.findAllByName(name, pageNumber, size);

            if (protocolListByName.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            ResponseEntity.ok(protocolListByName);
        } else {
            List<Protocol> protocolList = protocolService.findAll(pageNumber, size);

            if (protocolList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(protocolList);
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Protocol> add(@Valid @RequestBody Protocol protocol) throws URISyntaxException, BadResourceException, ResourceAlreadyExistsException {
        Protocol savedProtocol = protocolService.save(protocol);

        if (Objects.isNull(savedProtocol)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.created(new URI("/api/protocols/" + savedProtocol.getId())).body(savedProtocol);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Protocol> updateContact(@Valid @RequestBody Protocol protocol,
                                                  @PathVariable(value = "id") long id) throws BadResourceException, ResourceNotFoundException {
        Protocol updatedProtocol = protocolService.update(id, protocol);

        if (Objects.isNull(updatedProtocol)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedProtocol);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Protocol> findById(@PathVariable long id) throws ResourceNotFoundException {
        Protocol protocol = protocolService.findById(id);

        if (Objects.isNull(protocol)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(protocol);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable long id) throws ResourceNotFoundException {
        protocolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
