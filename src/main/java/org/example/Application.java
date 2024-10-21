package org.example;


import org.example.model.Employee;
import org.example.model.Project;
import org.example.model.Timesheet;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.ProjectRepository;
import org.example.repositories.TimesheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Application {

    private static final String[] firstNames = {"Ivan", "Semen", "Roman", "Oleg", "Sergei"};
    private static final String[] lastNames = {"Ivanov", "Petrov", "Sidorov", "Putin", "Gorbachev"};

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        ProjectRepository projectRepository = ctx.getBean(ProjectRepository.class);

        for (int i = 1; i <= 5; i++) {
            Project project = new Project();
            project.setProjectName("Project #" + i);
            projectRepository.save(project);
        }

        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
        for (int i = 1; i <= 5; i++) {
            Employee employee = new Employee();
            employee.setFirstName(firstNames[i-1]);
            employee.setLastName(lastNames[i-1]);
            employeeRepository.save(employee);
        }

        TimesheetRepository timesheetRepository = ctx.getBean(TimesheetRepository.class);

        LocalDate createdAt = LocalDate.now();

        for (int i = 1; i <= 10; i++) {
            createdAt = createdAt.plusDays(1);

            Timesheet timesheet = new Timesheet();
            timesheet.setProjectId(ThreadLocalRandom.current().nextLong(1, 6));
            timesheet.setCreatedAt(createdAt);
            timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));
            timesheet.setEmployeeId(ThreadLocalRandom.current().nextLong(1, 6));

            timesheetRepository.save(timesheet);
        }
    }

}