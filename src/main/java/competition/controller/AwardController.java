package competition.controller;

import competition.entity.Award;
import competition.entity.Request;
import competition.service.AwardService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/award")
public class AwardController {
    @Resource
    private AwardService awardService;

    /**
     * 添加报名信息
     *
     * @param award
     * @return Request
     */
    @RequestMapping("/add")
    @ResponseBody
    public Request addAward(@RequestBody Award award) {
        return awardService.addAward(award);
    }

    /**
     * 查看报名信息按队伍返回
     * @param message_board（比赛id）
     * @return
     */
    @RequestMapping("/listbymessage_board")
    @ResponseBody
    public Request listAwardByCompetition(String message_board) {
        return awardService.listAwardByCompetition(message_board);
    }
}
