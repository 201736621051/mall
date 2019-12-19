package priv.jesse.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: wdd
 * @Date: 2019/12/12 20:37
 * @Description:
 */
@Entity
public class History {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    /**
     * 商品标题
     */
    @Column
    private String title;

    /**
     * 商城价
     */
    @Column
    private double price;

    @Column
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
