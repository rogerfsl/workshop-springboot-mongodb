package com.rogerlopes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerlopes.workshopmongo.domain.User;
import com.rogerlopes.workshopmongo.dto.UserDTO;
import com.rogerlopes.workshopmongo.repository.UserRepository;
import com.rogerlopes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserSevice {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
		
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDto (UserDTO objDto) {
		return new User (objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
