package com.hillel.service;

import com.hillel.dto.ClientStatusDto;
import com.hillel.dao.ClientStatusDao;
import com.hillel.entity.ClientStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {
    private final ClientStatusDao clientStatusDao;

    public ClientStatusService() {
        clientStatusDao = new ClientStatusDao();
    }

    public List<ClientStatusDto> findAllFromClientStatus() {
        List<ClientStatus> nameEmailAlias = clientStatusDao.findAllFromClientStatus();
        List<ClientStatusDto> result = new ArrayList<>();

        for (ClientStatus cs : nameEmailAlias) {
            ClientStatusDto dto = new ClientStatusDto();
            dto.setClientId(cs.getClientId());
            dto.setStatusId(cs.getStatusId());
            result.add(dto);
        }
        return result;
    }
}
