package com.nanGuoMM.service;

import com.nanGuoMM.mapper.FootTeamMapper;
import com.nanGuoMM.mapper.UserMapper;
import com.nanGuoMM.pojo.FootballTeam;
import com.nanGuoMM.pojo.User;
import com.nanGuoMM.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GlobalService {
    private final SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<FootballTeam> listAllTeams(){
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        FootTeamMapper mapper = sqlSession.getMapper(FootTeamMapper.class);
        //查询
        List<FootballTeam> teams = mapper.selectAllTeam();
        //释放资源
        sqlSession.close();
        //执行查询逻辑
        return teams;
    }

    public void addTeam(FootballTeam team) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        FootTeamMapper mapper = sqlSession.getMapper(FootTeamMapper.class);
        //执行添加逻辑
        mapper.addTeam(team);
        //提交sql
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public void deleteTeam(Integer id) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        FootTeamMapper mapper = sqlSession.getMapper(FootTeamMapper.class);
        //删除球队
        mapper.deleteTeamById(id);
        //提交sql
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public FootballTeam listOneTeam(Integer id) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        FootTeamMapper mapper = sqlSession.getMapper(FootTeamMapper.class);
        //查询要修改的球队
        FootballTeam team = mapper.selectById(id);
        //释放资源
        sqlSession.close();
        return team;
    }

    public void updateTeam(FootballTeam team) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        FootTeamMapper mapper = sqlSession.getMapper(FootTeamMapper.class);
        //修改球队
        mapper.updateTeam(team);
        //提交sql
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public User login(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User reUser = mapper.selectUser(username, password);
        //释放资源
        sqlSession.close();
        //返回数据
        return reUser;
    }

    public User regist(String username) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User user = mapper.selectUserByName(username);
        //释放资源
        sqlSession.close();
        //返回数据
        return user;
    }

    public void addUser(User user) {
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //插入用户
        mapper.addUser(user);
        //提交数据
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
