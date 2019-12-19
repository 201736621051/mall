package priv.jesse.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.jesse.mall.entity.History;

/**
 * @Auther: wdd
 * @Date: 2019/12/12 20:37
 * @Description:
 */
public interface HistoryDao extends JpaRepository<History, Integer> {
}
