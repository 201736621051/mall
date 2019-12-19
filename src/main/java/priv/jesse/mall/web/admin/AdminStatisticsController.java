package priv.jesse.mall.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.StatisticsService;

import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2019/12/13 09:07
 * @Description:
 */
@Controller
@RequestMapping("/admin/statistics")
public class AdminStatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/toList.html")
    public String toList() {
        return "admin/statistics/list";
    }

    @ResponseBody
    @RequestMapping("/getTotal")
    public ResultBean<List<Integer>> getTotal() {
        List<Integer> prices = statisticsService.queryTotalPrice();
        return new ResultBean<>(prices);
    }
}
