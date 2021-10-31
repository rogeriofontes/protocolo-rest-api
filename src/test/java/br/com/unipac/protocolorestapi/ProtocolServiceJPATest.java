package br.com.unipac.protocolorestapi;

import br.com.unipac.protocolorestapi.model.domain.Protocol;
import br.com.unipac.protocolorestapi.model.service.ProtocolService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProtocolServiceJPATest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ProtocolService service;

    // @Rule
    // public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSaveUpdateDeleteContact() throws Exception {
        Protocol c = new Protocol();
        c.setName("Portgas D. Ace");
        c.setDocumentId(1);
        c.setEmail("ace@whitebeard.com");

        service.save(c);
        assertNotNull(c.getId());

        Protocol findContact = service.findById(c.getId());
        assertEquals("Portgas D. Ace", findContact.getName());
        assertEquals("ace@whitebeard.com", findContact.getEmail());

        // update record
        c.setEmail("ace@whitebeardpirat.es");
        service.update(1l, c);

        // test after update
        findContact = service.findById(c.getId());
        assertEquals("ace@whitebeardpirat.es", findContact.getEmail());

        // test delete
        service.deleteById(c.getId());

        // query after delete
        //exceptionRule.expect(ResourceNotFoundException.class);
        //contactService.findById(c.getId());
    }
}
