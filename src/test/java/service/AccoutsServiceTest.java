package service;

import com.hillel.dao.AccountsDao;
import com.hillel.dto.AccountsDto;
import com.hillel.entity.Accounts;
import com.hillel.service.AccountsService;
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
class AccoutsServiceTest {

    @InjectMocks
    private AccountsService accountService;

    @Mock
    private AccountsDao accountDao;

    private Accounts account = new Accounts();

    @BeforeEach
    private void accountInitialization() {
        account.setId(1);
        account.setClientId(1);
        account.setNumber("1237 8890 8765 1123");
        account.setValue(1043.88);
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
    }

    @Test
    public void findAllAccountsListCheckBySizeCorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertTrue(actualList.size() == 1);
    }

    @Test
    public void findAllAccountsMethodCheckBySizeIncorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertNotEquals(5, actualList.size());
        assertTrue(actualList.size() != 3);
        assertNotSame(10, actualList.size());
    }

    @Test
    public void findAllAccountsMethodCheckByClientIdCorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertSame(1, actualList.get(0).getClientId());
    }

    @Test
    public void findAllAccountsMethodCheckByClientIdIncorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertFalse(actualList.get(0).getClientId() == 0);
    }

    @Test
    public void findAllAccountsMethodCheckByAccountIdCorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertEquals(1, actualList.get(0).getId());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountIdIncorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertNotSame(10998, actualList.get(0).getId());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountNumberCorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertEquals("1237 8890 8765 1123", actualList.get(0).getNumber());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountNumberIncorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertFalse(actualList.get(0).getNumber() == "9999 8890");
    }

    @Test
    public void findAllAccountsMethodCheckByAccountValueCorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertEquals(1043.88, actualList.get(0).getValue());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountValueIncorrectValueTest() {
        List<AccountsDto> actualList = accountService.findAllAccounts();

        assertNotEquals(104388, actualList.get(0).getValue());
    }
}

