package server.api.insurance.outerActor;


import org.springframework.stereotype.Service;

@Service
public class OuterActor {
    public boolean collaborateUW(int incomeLevel) {
        if(incomeLevel  == 1) {
            return false;
        } else {
            return true;
        }
    }
}
