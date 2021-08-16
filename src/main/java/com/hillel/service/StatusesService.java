package com.hillel.service;

import com.hillel.dao.StatusesDao;
import com.hillel.dto.StatusesDto;
import com.hillel.entity.Statuses;

import java.util.ArrayList;
import java.util.List;

public class StatusesService {
    private final StatusesDao statusDao;

    public StatusesService() {
        statusDao = new StatusesDao();
    }


    public List<StatusesDto> findAllStatuses() {
        List<Statuses> statuses = statusDao.findAllStatuses();
        List<StatusesDto> result = new ArrayList<>();

        for (Statuses status : statuses) {
            StatusesDto dto = new StatusesDto();
            dto.setId(status.getId());
            dto.setAlias(status.getAlias());
            dto.setDescription(status.getDescription());
            result.add(dto);
        }
        return result;
    }
}
