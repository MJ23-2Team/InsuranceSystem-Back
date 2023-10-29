package server.api.insurance.outerActor;

import server.api.insurance.employee.dto.ContractDto;

public class OuterActor {
    public boolean collaborateUW(int incomeLevel) {
        if(incomeLevel  == 1) {
            return false;
        } else {
            return true;
        }
    }
}
