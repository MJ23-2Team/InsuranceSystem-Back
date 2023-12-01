package server.app.insurance.user.employee.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.app.insurance.user.employee.entity.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @Query( "SELECT a FROM Contract a WHERE a.customer.customerID=:customerId" )
    List<Contract> findByCustomerId( @Param("customerId") int customerID );

}
