package com.demo.tennistournament.repository.jdbc;

import com.demo.tennistournament.entity.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourtJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Court> findAll(){
        return jdbcTemplate.query("SELECT * FROM COURT;",
                new BeanPropertyRowMapper<Court>(Court.class));
    }

    public Court findById(short id){
        return jdbcTemplate.queryForObject
                ("select * from court where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Court>(Court.class));
    }

    public List<Court> findByName(String name) {
        return jdbcTemplate.query("select * from court where name=?", new Object[]{name},
                new BeanPropertyRowMapper<Court>(Court.class));
    }

    public List<Court> findWhereCapacityIsLessThan(Short capacity) {
        return jdbcTemplate.query("select * from court where capacity < ?", new Object[]{capacity},
                new BeanPropertyRowMapper<Court>(Court.class));
    }

    public List<Court> findWhereCapacityIsGreaterThanOrEqual(Short capacity) {
        return jdbcTemplate.query("select * from court where capacity >= ?", new Object[]{capacity},
                new BeanPropertyRowMapper<Court>(Court.class));
    }
}
