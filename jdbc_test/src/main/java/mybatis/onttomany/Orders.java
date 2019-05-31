package mybatis.onttomany;

import java.util.Date;
import java.util.List;

public class Orders {

    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    private String note;
    //引入用户信息
    private User user;
    //引入订单明细（和上面的用户信息不同，一个是一对一，一个是一对多）
    private List<Orderdetail> orderdetails; //注意是orderdetails，一个有's',一个有's'

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }
}