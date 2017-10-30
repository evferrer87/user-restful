package repository;

import org.springframework.data.repository.CrudRepository;

import model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}