package server.api.insurance.reward;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @PostMapping( "/reward")
    public void add( @RequestBody RewardDto request ){
        rewardService.add( request );
    }

    @GetMapping( "/reward" )
    public RewardDto retrieve( @RequestParam int id ){
        return rewardService.retrieve( id );
    }

    @GetMapping( "/reward/getAll")
    public List<RewardDto> retrieveAll(){
        return rewardService.retrieveAll();
    }

    @PutMapping( "/reward" )
    public void update( @RequestBody RewardDto request ){
        rewardService.update( request );
    }

    @DeleteMapping( "/reward" )
    public void delete( @RequestParam int id ){
        rewardService.delete( id );
    }
}
