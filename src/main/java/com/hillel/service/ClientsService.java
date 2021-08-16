package com.hillel.service;

import com.hillel.dto.ClientsDto;
import com.hillel.dao.ClientsDao;
import com.hillel.entity.Clients;

import java.util.ArrayList;
import java.util.List;

public class ClientsService {
        private final ClientsDao clientDao;

    public ClientsService() {
        clientDao = new ClientsDao();
    }

    public List<ClientsDto> findAllClients() {
            List<Clients> clients = clientDao.findAllClients();
            List<ClientsDto> resultList = new ArrayList<>();

            for (Clients client : clients) {
                ClientsDto dto = new ClientsDto();
                dto.setId(client.getId());
                dto.setName(client.getName());
                dto.setEmail(client.getEmail());
                dto.setPhone(client.getPhone());
                dto.setAbout(client.getAbout());
                dto.setAge(client.getAge());

                resultList.add(dto);
            }
        return resultList;
    }
}
