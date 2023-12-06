package server.app.insurance.user.employee.controller;

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
    public void createReward( @RequestBody RewardDto request ){
        rewardList.createReward( request );
    }

    @GetMapping( "/getByRewardId" )
    public RewardDto retrieveReward( @RequestParam int id ){
        return rewardList.retrieveReward( id );
    }

    @GetMapping( "/getByCustomerId" )
    public List<RewardDto> retrieveRewardByCustomerId( @RequestParam int id ) { return rewardList.retrieveRewardByCustomerId( id ); }
    @GetMapping( "/getAll")
    public List<RewardDto> retrieveAllReward(){
        return rewardList.retrieveAllReward();
    }

    @PutMapping( "/update" )
    public void updateReward( @RequestBody RewardDto request ){
        rewardList.updateReward( request );
    }

    @DeleteMapping( "/delete" )
    public void deleteReward( @RequestParam int id ){
        rewardList.deleteReward( id );
    }

    @GetMapping( "/approve")
    public void approveReward( @RequestParam int id, @RequestParam boolean flag ){
        System.out.println( id );
        System.out.println( flag );
        rewardList.approveReward( id, flag ); }
}
