package com.storyengine;

import java.util.Map;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQLDao {
    private static final Logger logger = LoggerFactory.getLogger(MySQLDao.class);
    private JdbcTemplate jdbcTemplate;

    public MySQLDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Map<String, Object>> executeQuery(String query) {
        logger.info("Running query:\n"+query);
        return jdbcTemplate.queryForList(query);
    }
}
