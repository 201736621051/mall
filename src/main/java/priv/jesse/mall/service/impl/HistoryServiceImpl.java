package priv.jesse.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import priv.jesse.mall.dao.HistoryDao;
import priv.jesse.mall.dao.ProductDao;
import priv.jesse.mall.entity.History;
import priv.jesse.mall.entity.Product;
import priv.jesse.mall.service.HistoryService;

/**
 * @Auther: wdd
 * @Date: 2019/12/12 20:35
 * @Description:
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private ProductDao productDao;


    @Override
    public Page<History> findAll(Pageable pageable) {
        return historyDao.findAll(pageable);
    }

    @Override
    public void add(int id, Integer userId) {
        Product product = productDao.getOne(id);
        History history = new History();
        history.setUserId(userId);
        history.setPrice(product.getMarketPrice());
        history.setTitle(product.getTitle());
        historyDao.save(history);
    }
}
