package com.nanGuoMM.mapper;

import com.nanGuoMM.pojo.FootballTeam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FootTeamMapper {
//    @Select("select * from tb_footballteam")
    List<FootballTeam> selectAllTeam();

    void addTeam(FootballTeam team);

    void deleteTeamById(Integer id);

    FootballTeam selectById(Integer id);

    void updateTeam(FootballTeam team);
}
