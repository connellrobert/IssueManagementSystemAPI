package dev.connellrobert.ims.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.connellrobert.ims.model.UserProjectMap;

@Repository
public interface UserProjectJunctionRepository extends CrudRepository<UserProjectMap, Long>{

}
