package projectApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import projectApp.entities.Employee;
import projectApp.entities.business_partners;

public interface partnersRepository extends CrudRepository<business_partners, Long>{

	@Override
	public List<business_partners> findAll();

	public business_partners findByPartnerId(long partnId);
}
