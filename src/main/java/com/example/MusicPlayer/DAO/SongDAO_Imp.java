package com.example.MusicPlayer.DAO;

import com.example.MusicPlayer.Model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SongDAO_Imp implements SongDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Song findById(Float Id) {
        String sql = "SELECT * FROM SONG WHERE id =?";
        return jdbcTemplate.queryForObject(sql,new SongRowMapper(),Id);
    }

    class SongRowMapper implements RowMapper<Song> {
        @Override
        public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
            Song song = new Song();
            song.setName(rs.getString("name"));
            song.setLength(rs.getInt("length"));

            return song;
        }
    }
}
