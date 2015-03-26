package com.tradeshift.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tradeshift.model.Message;

public class MessagesDAOImpl implements MessagesDAO {

    private JdbcTemplate jdbcTemplate;

    public MessagesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Message message) {
        String sql = "INSERT INTO message (name) VALUES (?)";
        jdbcTemplate.update(sql, message.getContent());
    }

    @Override
    public List<Message> getMessages(int amount) {

        String sql = "SELECT * FROM message";
        List<Message> listMessage = jdbcTemplate.query(sql, new RowMapper<Message>() {

            @Override
            public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
                Message aMessage = new Message();

                aMessage.setContent(rs.getString("name"));

                return aMessage;
            }

        });

        return listMessage;
    }
}