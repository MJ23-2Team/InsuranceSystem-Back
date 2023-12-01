package server.app.insurance.user.employee.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.app.insurance.user.employee.dto.RewardDto;
import server.app.insurance.user.employee.service.RewardList;

import java.util.List;

@Tag(name = "Reward 컨트롤러", description = "Reward API입니다.")
@RestController
@RequestMapping( "/reward" )
@RequiredArgsConstructor
public class RewardController {
    private final RewardList rewardList;

    @PostMapping( "/add")
    public void add( @RequestBody RewardDto request ){
        rewardList.add( request );
    }

    @GetMapping( "/getByRewardId" )
    public RewardDto retrieve( @RequestParam int id ){
        return rewardList.retrieve( id );
    }

    @GetMapping( "/getByCustomerId" )
    public List<RewardDto> retrieveByCustomerId( @RequestParam int customerId ) { return rewardList.retrieveByCustomerId( customerId ); }
    @GetMapping( "/getAll")
    public List<RewardDto> retrieveAll(){
        return rewardList.retrieveAll();
    }

    @PutMapping( "/update" )
    public void update( @RequestBody RewardDto request ){
        rewardList.update( request );
    }

    @DeleteMapping( "/delete" )
    public void delete( @RequestParam int id ){
        rewardList.delete( id );
    }
}
