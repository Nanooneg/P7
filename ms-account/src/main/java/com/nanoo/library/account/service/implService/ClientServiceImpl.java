package com.nanoo.library.account.service.implService;

import com.nanoo.library.account.database.ClientRepository;
import com.nanoo.library.account.model.dto.ClientDto;
import com.nanoo.library.account.model.entities.Client;
import com.nanoo.library.account.model.mapper.ClientMapper;
import com.nanoo.library.account.service.contractService.ClientService;
import com.nanoo.library.commonpackage.model.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 22/11/2019 - 14:48
 */
@Service
public class ClientServiceImpl implements ClientService {

  private Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
    this.clientRepository = clientRepository;
    this.clientMapper = clientMapper;
  }

  @Override
  public List<ClientDto> getClientList() {
    List<ClientDto> clientDtos = new ArrayList<>();

    List<Client> clients = clientRepository.findAll();

    for (Client client : clients) {
      clientDtos.add(clientMapper.fromClientToDto(client));
    }

    return clientDtos;
  }

  @Override
  public ClientDto getLoggedClientInfo() {

    String email = SecurityContextHolder.getContext().getAuthentication().getName();

    return clientMapper.fromClientToDto(clientRepository.findByEmail(email));
  }

  @Override
  public ClientDto saveClient(ClientDto clientDto) {

    Client client = clientMapper.fromDtoToClient(clientDto);

    if (clientDto.getId() != null) {
      Optional<Client> oldClient = clientRepository.findById(clientDto.getId());
      if (oldClient.isPresent()) {
        Client existingClient = oldClient.get();
        client.setBirthDate(existingClient.getBirthDate());
        client.setGender(existingClient.getGender());
        client.setAddress(existingClient.getAddress());
        client.setRole(existingClient.getRole());
        client.setClientNumber(existingClient.getClientNumber());
        client.setDateOfCreation(existingClient.getDateOfCreation());
      }
    } else {
      client.setRole(Role.CLIENT);
      client.setClientNumber((long) 13556); // TODO add client number generation process
      client.setDateOfCreation(new Date());
    }

    client.setDateOfUpdate(new Date());

    try {
      return clientMapper.fromClientToDto(clientRepository.save(client));
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    }
  }
}
