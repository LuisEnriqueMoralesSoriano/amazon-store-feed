package mx.com.fahorro.apiamzstorefeed.repository;

import mx.com.fahorro.apiamzstorefeed.entity.BranchEntity;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<BranchEntity, Long> {

    List<BranchEntity> findByFarmaId(String farmaId);
}
