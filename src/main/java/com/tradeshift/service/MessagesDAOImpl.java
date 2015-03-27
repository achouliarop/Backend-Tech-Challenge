package com.tradeshift.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tradeshift.model.Message;
import com.tradeshift.model.ResultModel;

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
    public List<ResultModel> getMessages(int amount) {


        String sql = "WITH t AS " +
                        "(SELECT * FROM message ORDER BY date DESC LIMIT 10) " +
                    "SELECT * FROM t ORDER BY date ASC";
        List<ResultModel> listMessage = jdbcTemplate.query(sql, new RowMapper<ResultModel>() {

            @Override
            public ResultModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                Message aMessage = new Message();

                aMessage.setContent(rs.getString("name"));

                ResultModel output = new ResultModel();
                output.setMessage(aMessage);

                return output;
            }

        });

        return listMessage;
    }
}