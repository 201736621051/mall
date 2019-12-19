package priv.jesse.mall.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.jesse.mall.entity.History;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.HistoryService;

import java.util.List;

@Controller
@RequestMapping("/admin/history")
public class AdminHistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/toList.html")
    public String toList() {
        return "admin/history/list";
    }


    @ResponseBody
    @RequestMapping("/list.do")
    public ResultBean<List<History>> listProduct(int pageindex,
                                                 @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        Pageable pageable = new PageRequest(pageindex, pageSize, null);
        List<History> list = historyService.findAll(pageable).getContent();
        return new ResultBean<>(list);
    }

    @ResponseBody
    @RequestMapping("/getTotal")
    public ResultBean<Integer> getTotal() {
        Pageable pageable = new PageRequest(1, 15, null);
        int total = (int) historyService.findAll(pageable).getTotalElements();
        return new ResultBean<>(total);
    }







}
