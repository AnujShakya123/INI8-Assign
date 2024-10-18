package Assign.demoAssign;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RegistrationDAO registrationDAO = new RegistrationDAO();

        // Create a new registration
        Registration registration = new Registration(0, "Anuj Shakya", "anujshakya808@gmail.com", "1999-02-18", "8171916543", "Crossings republik, Ghaziabad");
        registrationDAO.addRegistration(registration);

        // Read a registration by ID
        Registration retrievedRegistration = registrationDAO.getRegistrationById(2);
        if (retrievedRegistration != null) {
            System.out.println("Retrieved Registration: " + retrievedRegistration.getName());
        }

        // Read all registrations
        List<Registration> allRegistrations = registrationDAO.getAllRegistrations();
        for (Registration reg : allRegistrations) {
            System.out.println("ID: " + reg.getId() + ", Name: " + reg.getName());
        }

        // Update a registration
        retrievedRegistration.setName("Anuj Shakya");
        registrationDAO.updateRegistration(retrievedRegistration);

        // Delete a registration
        registrationDAO.deleteRegistration(1);
    }
}
