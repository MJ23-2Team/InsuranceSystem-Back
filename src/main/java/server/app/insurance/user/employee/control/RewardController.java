package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.service.RewardList;

import java.util.List;

@Tag(name = "Reward 컨트롤러", description = "Reward API입니다.")
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
