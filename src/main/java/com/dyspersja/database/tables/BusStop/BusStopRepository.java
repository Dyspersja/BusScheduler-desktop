package com.dyspersja.database.tables.BusStop;

import com.dyspersja.database.DatabaseConnection;
import com.dyspersja.database.tables.TableRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BusStopRepository implements TableRepository<BusStopEntity> {

    final Connection connection;

    public BusStopRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        final String deleteQuery = "DELETE FROM bus_stops WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1,id);

            statement.executeUpdate();
        }
    }

    @Override
    public boolean existsById(int id) throws SQLException {
        final String selectQuery = "SELECT COUNT(*) FROM bus_stops WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1,id);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        }
    }

    @Override
    public List<BusStopEntity> findAll() throws SQLException {
        final String selectQuery = "SELECT * FROM bus_stops";

        List<BusStopEntity> busStops = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) busStops.add(BusStopEntity.builder()
                        .id(resultSet.getInt("id"))
                        .number(resultSet.getInt("number"))
                        .city(resultSet.getString("city"))
                        .street(resultSet.getString("street"))
                        .latitude(resultSet.getDouble("latitude"))
                        .longitude(resultSet.getDouble("longitude"))
                        .build());
        }
        return busStops;
    }

    @Override
    public Optional<BusStopEntity> findById(int id) throws SQLException {
        final String selectQuery = "SELECT * FROM bus_stops WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1,id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(BusStopEntity.builder()
                            .id(resultSet.getInt("id"))
                            .number(resultSet.getInt("number"))
                            .city(resultSet.getString("city"))
                            .street(resultSet.getString("street"))
                            .latitude(resultSet.getDouble("latitude"))
                            .longitude(resultSet.getDouble("longitude"))
                            .build());
                } else return Optional.empty();
            }
        }
    }

    @Override
    public void save(BusStopEntity entity) throws SQLException {
        final String insertQuery = "INSERT INTO bus_stops " +
                "(number, city, street, latitude, longitude) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1,entity.getNumber());
            statement.setString(2,entity.getCity());
            statement.setString(3, entity.getStreet());
            statement.setDouble(4, entity.getLatitude());
            statement.setDouble(5, entity.getLongitude());

            statement.executeUpdate();
        }
    }

    @Override
    public void update(BusStopEntity updatedEntity) throws SQLException {
        final String updateQuery = "UPDATE bus_stops SET ? WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, generateUpdateQuery(updatedEntity));
            statement.setInt(2, updatedEntity.getId());

            statement.executeUpdate();
        }
    }

    private String generateUpdateQuery(BusStopEntity updatedEntity) throws SQLException {
        BusStopEntity existingEntity = findById(updatedEntity.getId()).orElseThrow();
        StringBuilder updatedFields = new StringBuilder();

        if(existingEntity.getNumber() != updatedEntity.getNumber())
            updatedFields.append(String.format("number = %d, ", updatedEntity.getNumber()));

        if(existingEntity.getCity().equals(updatedEntity.getCity()))
            updatedFields.append(String.format("city = %s, ", updatedEntity.getCity()));

        if(existingEntity.getStreet().equals(updatedEntity.getStreet()))
            updatedFields.append(String.format("street = %s, ", updatedEntity.getStreet()));

        if(existingEntity.getLatitude() != updatedEntity.getLatitude())
            updatedFields.append(String.format("latitude = %.6f, ", updatedEntity.getLatitude()));

        if(existingEntity.getLongitude() != updatedEntity.getLongitude())
            updatedFields.append(String.format("longitude = %.6f, ", updatedEntity.getLongitude()));

        if (updatedFields.isEmpty()) return null;

        updatedFields.delete(updatedFields.length() - 2, updatedFields.length());

        return updatedFields.toString();
    }
}
