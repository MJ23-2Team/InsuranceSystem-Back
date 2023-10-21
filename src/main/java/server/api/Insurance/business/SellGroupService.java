package server.api.insurance.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.insurance.util.Constants.Target;
import server.api.insurance.util.Constants.Crud;
import server.api.insurance.util.Team;

@Service
@Transactional
@RequiredArgsConstructor
public class SellGroupService extends Team {
    @Override
    public void establishPolicy(Target target, Crud crud) {}

    @Override
    public void manage(Target target, Crud crud) {}

    @Override
    public void plan(Target target, Crud crud) {}

    @Override
    public void process(Target target, Crud crud) {}
}
