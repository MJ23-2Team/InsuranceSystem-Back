package server.api.insurance.reward;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;
}
