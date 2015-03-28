package com.tradeshift.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tradeshift.model.DBMessage;

public class MessagesDAOImpl implements MessagesDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MessagesDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    public MessagesDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(String name) {
        String sql = "INSERT INTO message (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public List<DBMessage> getMessages(int amount) {


        String sql = "WITH t AS " +
                        "(SELECT * FROM message ORDER BY date DESC LIMIT 10) " +
                    "SELECT * FROM t ORDER BY date ASC";

        List<DBMessage> dbMessages = jdbcTemplate.query(sql, new RowMapper<DBMessage>() {

            @Override
            public DBMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
                DBMessage aMessage = new DBMessage();

                aMessage.setName(rs.getString("name"));
                aMessage.setDate(rs.getTimestamp("date"));

                return aMessage;
            }

        });

        return  dbMessages;
    }
}