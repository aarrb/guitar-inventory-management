package edu.iu.aurabaza.Homework2.repository;

import edu.iu.aurabaza.Homework2.model.Customer;
import edu.iu.aurabaza.Homework2.model.Guitar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Guitar, String>
, QueryByExampleExecutor<Guitar> {

}
