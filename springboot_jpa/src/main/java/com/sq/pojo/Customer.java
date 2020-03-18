package com.sq.pojo;

import javax.persistence.*;

/**
 * 客户实体类
 *      配置映射关系
 *          实体类和表
 *          实体类中属性和表中字段
 *
 *
 *   @Entity:声明实体类
 *   @Table：配置实体类和表的映射关系
 *      name:配置数据库表的名称
 *   实体类中属性和表中字段的映射关系
 *          IDENTITY:主键由数据库自动生成（主要是自动增长型）（mysql）
 *          SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列（oracle）
 *          AUTO：主键由程序控制（了解即可）
 *          TABLE：使用一个特定的数据库表格来保存主键（了解即可）
 *
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    @Id //声明主键的配置
    @GeneratedValue(strategy = GenerationType.IDENTITY) //配置主键的生成策略(自增)
    @Column(name = "cust_id")   //配置属性和字段的映射关系  name:表中属性对应的数据库字段的名称
    private Long custId;//客户的主键
    @Column(name = "cust_name")
    private String custName;//客户的名称
    @Column(name = "cust_source")
    private String custSource;//客户来源
    @Column(name = "cust_level")
    private String custLevel;//客户级别
    @Column(name = "cust_industry")
    private String custIndustry;//客户所属行业
    @Column(name = "cust_phone")
    private String custPhone;//客户的联系方式
    @Column(name = "cust_address")
    private String custAddress;//客户地址

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}
