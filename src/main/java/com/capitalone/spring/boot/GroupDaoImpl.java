package com.capitalone.spring.boot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    private final String DEFAULT_INSERT_SQL = "INSERT INTO gcount(GroupName,GroupCount,GroupStartPercent , GroupCompltdPercent , LatestTimeStamp) values(?,?,?,?,?)";

    private final String UPDATE_SQL = "UPDATE gcount SET  GroupCount = ? , GroupStartPercent = ? , GroupCompltdPercent = ? , LatestTimeStamp = ? WHERE GroupName = ?";

    private final String DELETE_SQL = "DELETE FROM gcount";

   /* private final String FETCHALL_SQL = "SELECT GroupName , GroupCount , GroupStartPercent  , GroupCompltdPercent , LatestTimeStamp from gcount";*/

    private final String FETCHALL_SQL = "SELECT * from gcount";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Group InsertWithDefaults(final Group group) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(DEFAULT_INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, group.getGroupName());
                ps.setString(2, group.getGroupCount());
                ps.setString(3, group.getGroupStartPercent());
                ps.setString(4, group.getGroupCompltdPercent());
                ps.setString(5, group.getLatestTimeStamp());
                return ps;
            }
        }, holder);

        System.out.println("##########Default Records Inserted############");

        return group;
    }

    public void update(String GroupName , String GroupCount , String GroupStartPercent ,String GroupCompltdPercent , String LatestTimeStamp) {

        jdbcTemplate.update(UPDATE_SQL,GroupCount,GroupStartPercent,GroupCompltdPercent,LatestTimeStamp,GroupName);
        System.out.println("##########Records Updated##########");

    }

    public void delete() {

        jdbcTemplate.update(DELETE_SQL);
        System.out.println("##########Records Deleted##########");

    }

    public List<Group> findAll() {
        return jdbcTemplate.query(FETCHALL_SQL, new GroupMapper());
    }
}



class GroupMapper implements RowMapper<Group> {


    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {

        Group group = new Group(rs.getString("GroupName"),rs.getString("GroupCount"),rs.getString("GroupStartPercent"),rs.getString("GroupCompltdPercent"),rs.getString("LatestTimeStamp"));



        return group;
    }

}
