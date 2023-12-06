package server.app.insurance.user.employee.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import server.app.insurance.user.employee.dto.ContractDto;
import server.app.insurance.user.employee.dto.PaymentDto;
import server.app.insurance.user.employee.entity.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @Query( "SELECT a FROM Contract a WHERE a.customer.customerID=:customerId" )
    List<Contract> findByCustomerId(@Param("customerId") int customerId );

    @Query("select new server.app.insurance.user.employee.dto.ContractDto( ct.contractID, ct.customer.customerID, ct.insurance.insuranceID, ct.contractDate, ct.contractFile ) " +
            "from Contract ct " +
            "where ct.contractID = :id")
    ContractDto findByContractId(@Param("id") int id);

}
