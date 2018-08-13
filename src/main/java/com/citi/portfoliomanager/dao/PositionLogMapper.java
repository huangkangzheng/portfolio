package com.citi.portfoliomanager.dao;

import com.citi.portfoliomanager.entity.PositionLog;
import com.citi.portfoliomanager.entity.PositionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int countByExample(PositionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int deleteByExample(PositionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int deleteByPrimaryKey(Integer exchangeLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int insert(PositionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int insertSelective(PositionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    List<PositionLog> selectByExample(PositionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    PositionLog selectByPrimaryKey(Integer exchangeLogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") PositionLog record, @Param("example") PositionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByExample(@Param("record") PositionLog record, @Param("example") PositionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByPrimaryKeySelective(PositionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pm_position_log
     *
     * @mbggenerated Mon Aug 13 12:02:45 CST 2018
     */
    int updateByPrimaryKey(PositionLog record);
}