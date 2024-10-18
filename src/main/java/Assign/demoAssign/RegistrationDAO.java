package Assign.demoAssign;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {

    // Create a new registration
    public void addRegistration(Registration registration) {
        String query = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, registration.getName());
            stmt.setString(2, registration.getEmail());
            stmt.setString(3, String.valueOf(registration.getDateOfBirth()));
            stmt.setString(4, registration.getPhoneNumber());
            stmt.setString(5, registration.getAddress());

            stmt.executeUpdate();
            System.out.println("Registration added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read a registration by ID
    public Registration getRegistrationById(int id) {
        String query = "SELECT * FROM Registration WHERE ID = ?";
        Registration registration = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                registration = new Registration(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("DateOfBirth"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registration;
    }

    // Read all registrations
    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        String query = "SELECT * FROM Registration";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Registration registration = new Registration(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("DateOfBirth"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Address")
                );
                registrations.add(registration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }

    // Update a registration by ID
    public void updateRegistration(Registration registration) {
        String query = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, registration.getName());
            stmt.setString(2, registration.getEmail());
            stmt.setString(3, String.valueOf(registration.getDateOfBirth()));
            stmt.setString(4, registration.getPhoneNumber());
            stmt.setString(5, registration.getAddress());
            stmt.setInt(6, registration.getId());

            stmt.executeUpdate();
            System.out.println("Registration updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a registration by ID
    public void deleteRegistration(int id) {
        String query = "DELETE FROM Registration WHERE ID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registration deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
