package projectApp.dao;

import org.springframework.data.repository.CrudRepository;

import projectApp.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
