package server.app.insurance.intra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.app.insurance.intra.entity.OperationPolicy;

import java.util.List;

public interface OperationPolicyRepository extends JpaRepository<OperationPolicy,Integer> {
    @Query( nativeQuery = true, value = "select * from operation_policy where pass =0")
    List<OperationPolicy> findNotPass ();

    @Query( nativeQuery = true, value = "select * from operation_policy where pass >0")
    List<OperationPolicy> findPass ();
}
