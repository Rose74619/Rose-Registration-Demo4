package com.registration.service;

import com.registration.payload.RegistrationDto;

import java.util.List;

public interface RegistrationService {
    public RegistrationDto createRegistration(RegistrationDto registrationDto);

    void deleteRegistration(long id);

    RegistrationDto updateRegistration(RegistrationDto registrationDto, long id);

    List<RegistrationDto> getRegistration(int pageNo, int pageSize, String sortBy, String sortDir);

    RegistrationDto getRegistrationById(long id);
}
