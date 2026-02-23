package org.testngmetadatalibs.dao;

import org.testngmetadatalibs.model.SessionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {
    private static final String INSERT_SQL =
            "INSERT INTO sessions (session_id, session_name) VALUES (?, ?)";

    private static final String SELECT_SQL =
            "SELECT session_id, session_name FROM sessions WHERE session_id = ?";

    private static final String SELECT_ALL_SQL =
            "SELECT session_id, session_name FROM sessions";


    public boolean insertSession(String sessionId, String sessionName) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, sessionId);
            stmt.setString(2, sessionName);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SessionModel getSession(String sessionId) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_SQL)) {

            stmt.setString(1, sessionId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new SessionModel(
                        rs.getString("session_id"),
                        rs.getString("session_name")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SessionModel> getAllSessions() {
        List<SessionModel> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new SessionModel(
                        rs.getString("session_id"),
                        rs.getString("session_name")
                ));
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
