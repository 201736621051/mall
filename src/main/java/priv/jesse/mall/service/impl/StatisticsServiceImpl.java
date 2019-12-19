package priv.jesse.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.jesse.mall.dao.OrderDao;
import priv.jesse.mall.service.StatisticsService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2019/12/13 09:33
 * @Description:
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Integer> queryTotalPrice() {
        List<Integer> prices = new ArrayList<>();
        for(int i=6; i>=0; i--){
            Integer price = orderDao.findTotalPriceByDay(i);
            if(price == null){
                prices.add(0);
            }else{

                prices.add(orderDao.findTotalPriceByDay(i));
            }
        }
        return prices;
    }
}
