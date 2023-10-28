package server.api.insurance.insurance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.api.insurance.exception.CSaveFailException;
import server.api.insurance.exception.DaoException;
import server.api.insurance.util.Constants;
import server.api.insurance.util.Team;

@Service
@RequiredArgsConstructor
public class InsuranceDevelopmentService {

    private InsuranceRepository insuranceRepository;

    public InsuranceDevelopmentService(InsuranceRepository insuranceRepository){
        this.insuranceRepository = insuranceRepository;
    }
    public void establishPolicy(Constants.Target target, Constants.Crud crud) {
        if (target == Constants.Target.INSURANCE) {
            if (crud == Constants.Crud.CREATE) {
                //원래 형태, 프런트 생기면 고치기
//                String report = TuiReader.readInput("보고서가 올바른 형식이 아닙니다.");
                String report = "보고서";
                Insurance insurance = new Insurance();
                insurance.setPlanReport(report);
                try {
                    insuranceRepository.save(insurance);
                } catch (DaoException e) {
                    throw new CSaveFailException("보고서 저장에 실패했습니다.");
                }
            } else if (crud == Constants.Crud.UPDATE) {

            } else if (crud == Constants.Crud.DELETE) {

            }
        }
    }
}
