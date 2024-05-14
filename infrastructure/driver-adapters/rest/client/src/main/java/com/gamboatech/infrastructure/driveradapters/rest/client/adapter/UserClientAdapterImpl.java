package com.gamboatech.infrastructure.driveradapters.rest.client.adapter;

import com.gamboatech.application.adapters.driveradapters.restclient.UserClientAdapter;
import com.gamboatech.domain.commons.BusinessException;
import com.gamboatech.domain.commons.ErrorCodes;
import com.gamboatech.infrastructure.driveradapters.rest.client.dto.ClientDto;
import com.gamboatech.infrastructure.driveradapters.rest.client.dto.ErrorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;

@Component
public class UserClientAdapterImpl implements UserClientAdapter {

    private final String baseUrl;
    private final RestTemplate restTemplate;

    public UserClientAdapterImpl(@Value("${spring.rest-client.url.client-service}") String url, RestTemplate restTemplate) {
        this.baseUrl = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public Long getClientIdByIdentificationNumber( String identificationNumber){
        return consumeRestService(identificationNumber).getId();

    }

    private ClientDto consumeRestService(String identificationNumber) {
        String url = baseUrl.concat("/{identificationNumber}");

        try{
            ResponseEntity<ClientDto> responseEntity = restTemplate
                    .getForEntity(url, ClientDto.class, identificationNumber);
                return responseEntity.getBody();
        }catch (HttpClientErrorException ex) {
            ErrorDto response = ex.getResponseBodyAs(ErrorDto.class);
            if (response != null) {
                throw new BusinessException(response.getMessage(), ErrorCodes.valueOf(response.getCode()));
            }

            throw new BusinessException("Error " + ex.getStatusCode(), ErrorCodes.CLIENT_ERROR);
        }
    }
}
