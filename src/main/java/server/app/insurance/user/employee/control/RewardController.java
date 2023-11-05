package server.app.insurance.user.employee.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.service.RewardList;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RewardController {
    private final RewardList rewardList;

    @PostMapping( "/reward")
    public void add( @RequestBody RewardDto request ){
        rewardList.add( request );
    }

    @GetMapping( "/reward" )
    public RewardDto retrieve( @RequestParam int id ){
        return rewardList.retrieve( id );
    }

    @GetMapping( "/reward/getAll")
    public List<RewardDto> retrieveAll(){
        return rewardList.retrieveAll();
    }

    @PutMapping( "/reward" )
    public void update( @RequestBody RewardDto request ){
        rewardList.update( request );
    }

    @DeleteMapping( "/reward" )
    public void delete( @RequestParam int id ){
        rewardList.delete( id );
    }
}
