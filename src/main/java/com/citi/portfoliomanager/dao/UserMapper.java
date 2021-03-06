package com.citi.portfoliomanager.dao;

import com.citi.portfoliomanager.entity.User;
import com.citi.portfoliomanager.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_user
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByPrimaryKey(User record);
}