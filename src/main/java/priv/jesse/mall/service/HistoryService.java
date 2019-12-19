package priv.jesse.mall.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import priv.jesse.mall.entity.History;

/**
 * @Auther: wdd
 * @Date: 2019/12/12 20:35
 * @Description:
 */
public interface HistoryService  {
    Page<History> findAll(Pageable pageable);

    void add(int id, Integer userId);

}
