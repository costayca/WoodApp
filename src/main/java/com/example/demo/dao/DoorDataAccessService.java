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
                    return price / 2.0f;
                }

                @Override
                public float computePriceType() {
                    return price / 2.0f;
                }
            };
        }));
    }

    @Override
    public Optional<Door> selectDoorById(UUID id) {
        final String sql = "SELECT * FROM door";
        Door door = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID uuid = UUID.fromString(resultSet.getString("id"));
            String color = resultSet.getString("color");
            String material = resultSet.getString("material");
            String type = resultSet.getString("type");
            int width = resultSet.getInt("width");
            int height = resultSet.getInt("height");
            int price = resultSet.getInt("price");

            return new Door(uuid, color, width, height, material, type) {
                @Override
                public int computePrice() {
                    return price;
                }

                @Override
                public float computePriceMaterial() {
                    return price / 2.0f;
                }

                @Override
                public float computePriceType() {
                    return price / 2.0f;
                }
            };
        }));
        return Optional.ofNullable(door);
    }

    @Override
    public int insertDoor(Door door) {
        final String sql = "INSERT INTO door (id, color, material, type, width, height, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, door.getId(), door.getColor(), door.getMaterial(), door.getType(), door.getWidth(), door.getHeight(), door.getPrice());
    }

    @Override
    public int deleteDoorById(UUID id) {
        final String sql = "DELETE FROM door WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateDoorById(UUID id, Door door) {
        final String sql = "UPDATE door SET color = ?, material = ?, type = ?, width = ?, height = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, door.getColor(), door.getMaterial(), door.getType(), door.getWidth(), door.getHeight(), door.getPrice(), id);
    }
}
