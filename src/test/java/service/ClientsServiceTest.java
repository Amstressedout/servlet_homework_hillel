package service;

import com.hillel.dao.ClientsDao;
import com.hillel.dto.ClientsDto;
import com.hillel.entity.Clients;
import com.hillel.service.ClientsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class ClientsServiceTest {

    @InjectMocks
    private ClientsService clientService;

    @Mock
    private ClientsDao clientDao;

    private Clients client = new Clients();

    @BeforeEach
    private void clientInitialization() {
        client.setId(1);
        client.setName("Bogdan");
        client.setAge(32);
        client.setEmail("bb@yahoo.com");
        client.setPhone(380505273349L);
        client.setAbout("Bogdan is a housekeeper and works for Julia Roberts");
        when(clientDao.findAllClients()).thenReturn(Collections.singletonList(client));
    }

    @Test
    public void findAllClientsMethodCheckBySizeCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertEquals(1, actualList.size());
    }

    @Test
    public void findAllClientsMethodCheckBySizeIncorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertNotSame(15, actualList.size());
    }

    @Test
    public void findAllClientsMethodCheckByClientIdCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertEquals(1, actualList.get(0).getId());
    }

    @Test
    public void findAllClientsMethodCheckByClientIdIncorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertNotSame(15, actualList.get(0).getId());
    }

    @Test
    public void findAllClientsMethodCheckByAgeCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertTrue(actualList.get(0).getAge() == 32);
    }

    @Test
    public void findAllClientsMethodCheckByAgeIncorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertNotEquals(18, actualList.get(0).getAge());
    }

    @Test
    public void findAllClientsMethodCheckByNameCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertSame("Bogdan", actualList.get(0).getName());
    }

    @Test
    public void findAllClientsMethodCheckByNameIncorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertNotSame(" ", actualList.get(0).getAge());
    }

    @Test
    public void findAllClientsMethodCheckByEmailCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertEquals("bb@yahoo.com", actualList.get(0).getEmail());
    }

    @Test
    public void findAllClientsMethodCheckByEmailIncorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertFalse(actualList.get(0).getEmail() == "wrong@mail.ru");
    }

    @Test
    public void findAllClientsMethodCheckByPhoneCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertTrue(actualList.get(0).getPhone() == 380505273349L);
    }

    @Test
    public void findAllClientsMethodCheckByAboutCorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertSame("Bogdan is a housekeeper and works for Julia Roberts", actualList.get(0).getAbout());
    }

    @Test
    public void findAllClientsMethodCheckByAboutIncorrectValueTest() {
        List<ClientsDto> actualList = clientService.findAllClients();

        assertTrue(actualList.get(0).getAbout() != "Brrrrrrr");
    }
}

