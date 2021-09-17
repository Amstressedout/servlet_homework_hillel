package service;

import com.hillel.dao.StatusesDao;
import com.hillel.dto.StatusesDto;
import com.hillel.entity.Statuses;
import com.hillel.service.StatusesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatusesServiceTest {

    @InjectMocks
    private StatusesService statusService;

    @Mock
    private StatusesDao statusDao;

    private Statuses status = new Statuses();

    @BeforeEach
    private void statusInitialization() {
        status.setId(2);
        status.setAlias("VIP");
        status.setDescription("Very Important Person");
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
    }

    @Test
    public void findAllStatusesMethodCheckBySizeCorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertEquals(1, actualList.size());
    }

    @Test
    public void findAllStatusesMethodCheckBySizeIncorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertNotSame(3, actualList.size());
    }

    @Test
    public void findAllStatusesMethodCheckByAliasCorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertSame("VIP", actualList.get(0).getAlias());
    }

    @Test
    public void findAllStatusesMethodCheckByAliasIncorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertNotSame("PREMIUM", actualList.get(0).getAlias());
        assertFalse(actualList.get(0).getAlias() == "STANDAND");
    }

    @Test
    public void findAllStatusesMethodCheckByIdCorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertEquals(2, actualList.get(0).getId());
    }

    @Test
    public void findAllStatusesMethodCheckByIdIncorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertNotSame(1, actualList.get(0).getId());
        assertNotEquals(3, actualList.get(0).getId());
    }

    @Test
    public void findAllStatusesMethodCheckByDescriptionCorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertEquals("Very Important Person", actualList.get(0).getDescription());
    }

    @Test
    public void findAllStatusesMethodCheckByDescriptionIncorrectValuesTest() {
        List<StatusesDto> actualList = statusService.findAllStatuses();

        assertNotSame("shsjsjjajak", actualList.get(0).getDescription());
        assertNotEquals("djjdjjsksks", actualList.get(0).getDescription());
    }
}

