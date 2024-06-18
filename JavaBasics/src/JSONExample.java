import org.json.JSONArray;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONExample {
    
    private static final Logger LOGGER = Logger.getLogger(JSONExample.class.getName());

    public static void main(String[] args) {
        // Initial JSON data
        String jsonString = """
            {
                "employees": [
                    {
                        "id": 1,
                        "name": "John Doe",
                        "position": "Software Engineer"
                    },
                    {
                        "id": 2,
                        "name": "Jane Smith",
                        "position": "Project Manager"
                    }
                ]
            }
            """;

        JSONObject data = new JSONObject(jsonString);

        // CREATE: Add new employee
        JSONObject newEmployee = new JSONObject();
        newEmployee.put("id", 3);
        newEmployee.put("name", "Sam Brown");
        newEmployee.put("position", "Designer");

        data.getJSONArray("employees").put(newEmployee);

        // READ: Print all employee names
        LOGGER.log(Level.INFO, "Employees after addition:");
        JSONArray employees = data.getJSONArray("employees");
        for (int i = 0; i < employees.length(); i++) {
            LOGGER.log(Level.INFO, employees.getJSONObject(i).getString("name"));
        }

        // UPDATE: Update position of employee with id 2
        for (int i = 0; i < employees.length(); i++) {
            JSONObject employee = employees.getJSONObject(i);
            if (employee.getInt("id") == 2) {
                employee.put("position", "Senior Project Manager");
            }
        }

        LOGGER.log(Level.INFO, "\nEmployees after update:");
        for (int i = 0; i < employees.length(); i++) {
            JSONObject employee = employees.getJSONObject(i);
            LOGGER.log(Level.INFO, employee.getString("name") + " - " + employee.getString("position"));
        }

        // DELETE: Remove employee with id 1
        for (int i = 0; i < employees.length(); i++) {
            if (employees.getJSONObject(i).getInt("id") == 1) {
                employees.remove(i);
                break;
            }
        }

        LOGGER.log(Level.INFO, "\nEmployees after deletion:");
        for (int i = 0; i < employees.length(); i++) {
            LOGGER.log(Level.INFO, employees.getJSONObject(i).getString("name"));
        }

        // Print final JSON
        LOGGER.log(Level.INFO, "\nFinal JSON data:");
        LOGGER.log(Level.INFO, data.toString(2));
    }
}
