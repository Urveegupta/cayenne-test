package org.apache.cayenne.tutorial;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.cayenne.tutorial.persistent.Employees;
import org.apache.cayenne.tutorial.persistent.Titles;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .dataSource(DataSourceBuilder
                        .url("jdbc:mysql://127.0.0.1:3306/employees")
                        .driver("com.mysql.cj.jdbc.Driver")
                        .userName("root") // TODO: change to your actual username and password
                        .password("habitat2001").build())
                .addConfig("cayenne/cayenne-project.xml")
                .build();
        ObjectContext context = cayenneRuntime.newContext();

        Employees title = context.newObject(Employees.class);
        title.setFirstName("Picasso");
        title.setGender("M");
        LocalDate birthDate = LocalDate.of(2001,3,29);
        title.setBirthDate(birthDate);
        title.setLastName("Gupta");
        title.setHireDate(birthDate);

        context.commitChanges();
    }
}