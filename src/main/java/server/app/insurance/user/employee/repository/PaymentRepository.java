package server.app.insurance.user.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.app.insurance.user.employee.dto.PaymentDto;
import server.app.insurance.user.employee.entity.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query("select new server.app.insurance.user.employee.dto.PaymentDto( py.paymentID, py.contract.contractID, py.duration, py.contractDuration, py.expireDate, py.content, py.amount, py.accidentCount, py.result ) " +
            "from Payment py " +
            "where py.paymentID = :id")
    PaymentDto findByPaymentId(int id);

}
