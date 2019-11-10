package cn.itcast.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "tb_user") // 表名
public class User {
    //id
    @Id //指定主键
    @KeySql(useGeneratedKeys = true) //开启自增序列
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别 1：男性 2：女性
    private Integer sex;
    //出生日期
    private Date birthday;
    //创建时间
    private Date created;
    //更新时间
    private Date updated;
    //备注
//    @Transient //瞬时：不需要持久化的字段
    private String note;
}
