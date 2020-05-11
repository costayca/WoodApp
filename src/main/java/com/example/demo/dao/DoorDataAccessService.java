package com.example.demo.dao;

import com.example.demo.model.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("doorPostgres")
public class DoorDataAccessService implements DoorDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DoorDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Door> selectAllDoors() {
        final String sql = "SELECT * FROM door";
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String color = resultSet.getString("color");
            String material = resultSet.getString("material");
            String type = resultSet.getString("type");
            int width = resultSet.getInt("width");
            int height = resultSet.getInt("height");
            int price = resultSet.getInt("price");

            return new Door(id, color, width, height, material, type) {
                @Override
                public int computePrice() {
                    return price;
                }

                @Override
                public float computePriceMaterial() {
                    return price;
                }

                @Override
                public float computePriceType() {
                    return price;
                }
            };
        }));
    }

    @Override
    public Optional<Door> selectDoorById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int insertDoor(Door door) {
        return 0;
    }

    @Override
    public int deleteDoorById(UUID id) {
        return 0;
    }

    @Override
    public int updateDoorById(UUID id, Door door) {
        return 0;
    }
}
