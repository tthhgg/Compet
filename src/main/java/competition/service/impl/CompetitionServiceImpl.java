package competition.service.impl;

import competition.dao.CompetitionDao;
import competition.entity.Competition;
import competition.entity.Page;
import competition.entity.Request;
import competition.service.CompetitionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("competitionService")
@Transactional
public class CompetitionServiceImpl implements CompetitionService {
    @Resource
    private CompetitionDao competitionDao;

    @Override
    public Request addCompetition(Competition competition) {
        Request request = new Request();
        try {
            competitionDao.addCompetition(competition);
            request.setMsg("成功");
        } catch (Exception e) {
            request.setData("失败");
        }
        return request;
    }

    @Override
    public Request updateCompetition(Competition competition) {
        Request request = new Request();
        try {
            competitionDao.updateCompetition(competition);
            request.setMsg("成功");
        } catch (Exception e) {
            request.setMsg("失败");
        }
        return request;
    }

    @Override
    public Request delCompetition(Competition competition) {
        Request request = new Request();
        try {
            competitionDao.delCompetition(competition);
            request.setMsg("成功");
            request.setData(competition);
        } catch (Exception e) {
            request.setMsg("失败");
        }
        return request;
    }

    @Override
    public Request findAllCompetition() {
        Request request = new Request();
        try {
            List list = competitionDao.findAllCompetition();
            request.setData(list);
            request.setMsg("成功");
        } catch (Exception e) {
            request.setMsg("失败");
        }
        return request;
    }

    @Override
    public Request getCompetition_way(String competition) {
        Request request = new Request();
        try {
            Integer num = competitionDao.getCompetition_way(competition);
            request.setData(num);
            request.setMsg("成功");
        } catch (Exception e) {
            request.setMsg("失败");
        }
        return request;
    }

    @Override
    public Request findCompetitionByPage(Page page) {
        Request request = new Request();
        try {
            List list = competitionDao.findCompetitionByPage(page);
            request.setData(list);
            request.setMsg("成功");
        } catch (Exception e) {
            request.setMsg("失败");
        }
        return request;
    }

    @Override
    public Request findCountCompetition() {
        Request request = new Request();
        try {
            request.setData(competitionDao.findCountCompetition());
            request.setMsg("成功");
        } catch (Exception e) {
            request.setMsg("失败");
        }
        return request;
    }
}
