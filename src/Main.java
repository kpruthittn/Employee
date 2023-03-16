import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        System.out.println("Hello world!");
        System.out.println("------------------------------");
        //Gender wie count
        Map<String, Long> noOfMaleAndFemaleEmployees=
                employeeList.stream()
                        .collect(Collectors
                                .groupingBy(Employee::getGender, Collectors.counting()));


        System.out.println(noOfMaleAndFemaleEmployees);
        System.out.println("------------------------------");

        //Different departments
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

//Age average
        Map<String, Double> averageofAge =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender , Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageofAge);
        System.out.println("------------------------------");

        //Year of joining >2015
        employeeList.stream()
                .filter(e-> e.getYearOfJoining()>2015)
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("------------------------------");

        //Each department employees count
        Map<String , Long> eachDepartment =
                employeeList.stream()

                        .collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));

        System.out.println(eachDepartment);

        System.out.println("------------------------------");


        //Highest salary employee details
        Optional<Employee> highestPaidEmployee =
                employeeList.stream()
                        .max(Comparator.comparing(Employee::getSalary));

        Employee highestSalary = highestPaidEmployee.get();

        System.out.println("------------------------------");
        System.out.println("Employee details are");
        System.out.println("------------------------------");
        System.out.println("Id = " + highestSalary.getId());
        System.out.println("Name = " + highestSalary.getName());
        System.out.println("Year Of Joining = " + highestSalary.getYearOfJoining());
        System.out.println("Salary= " + highestSalary.getSalary());
        System.out.println("Department = " + highestSalary.getDepartment());
        System.out.println("Age = " + highestSalary.getAge());
        System.out.println("Gender= " + highestSalary.getGender());

        System.out.println("------------------------------");

        //Average salary of each department

        Map<String , Double> averageInEachDepartment =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment , Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageInEachDepartment);

        System.out.println("------------------------------");

        Optional<Employee> minAgeEmployee =
                employeeList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));

        Employee minAge = minAgeEmployee.get();

        System.out.println("------------------------------");
        System.out.println("Employee details are");
        System.out.println("------------------------------");
        System.out.println("Id = " + minAge.getId());
        System.out.println("Name = " + minAge.getName());
        System.out.println("Year Of Joining = " + minAge.getYearOfJoining());
        System.out.println("Salary= " + minAge.getSalary());
        System.out.println("Department = " + minAge.getDepartment());
        System.out.println("Age = " + minAge.getAge());
        System.out.println("Gender= " + minAge.getGender());

        System.out.println("------------------------------");


        //Max Experience Employee

        Optional<Employee> maxExperienceEmployee =
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        Employee maxExperience = maxExperienceEmployee.get();

        System.out.println("------------------------------");
        System.out.println("Employee details are");
        System.out.println("------------------------------");
        System.out.println("Id = " + maxExperience.getId());
        System.out.println("Name = " + maxExperience.getName());
        System.out.println("Year Of Joining = " + maxExperience.getYearOfJoining());
        System.out.println("Salary= " + maxExperience.getSalary());
        System.out.println("Department = " +maxExperience.getDepartment());
        System.out.println("Age = " + maxExperience.getAge());
        System.out.println("Gender= " + maxExperience.getGender());

        System.out.println("------------------------------");

        //MAles and females in sales and marketing team

        Map<String , Long> maleandfemale =
                employeeList.stream()
                        .filter(e -> e.getDepartment()=="Sales And Marketing")
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(maleandfemale);
        System.out.println("------------------------------");

        //Average salary of male and female employees

        Map<String, Double> averageSalary =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender , Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalary);

        System.out.println("------------------------------");

        //Name of employee in each department
        Map<String, List<Employee>> employeeName =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        for(Map.Entry<String , List<Employee>> entry : employeeName.entrySet())
        {
            System.out.println("------------------------------");
            System.out.println(entry.getKey());
            System.out.println("------------------------------");
            List<Employee>ls=entry.getValue();
            for(Employee e:ls){
                System.out.println(e.getName());
            }
            System.out.println();
        }

        System.out.println("------------------------------");
        //Average salary and sum salary


        DoubleSummaryStatistics salary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(salary);

        Double averageSalaryCompany = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average salary of the company =" + averageSalaryCompany);

        Double salaryTotal = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Total salary of the company ="+salaryTotal);
        System.out.println("------------------------------");

        //Seperate age

//        Map<String , List<Employee>> ageOfEmployee =
//                employeeList.stream()
//                       .filter(e -> e.getAge() <= 25)

        //Oldest Employee in the company

        Optional<Employee> mostOldestEmployee =
                employeeList.stream()
                        .max(Comparator.comparingInt(Employee::getAge));

        Employee oldestEmployee = mostOldestEmployee.get();
        System.out.println("------------------------------");
        System.out.println("Employee details are");
        System.out.println("------------------------------");
        System.out.println("Name =" + oldestEmployee.getName());
        System.out.println("Department =" + oldestEmployee.getDepartment());
        System.out.println("Age =" + oldestEmployee.getAge());


        System.out.println("-------------------------------");
        Map<Boolean, List<Employee>> partitionEmployeesByAge=
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        Set<Map.Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

        for (Map.Entry<Boolean, List<Employee>> entry : entrySet)
        {
            System.out.println("----------------------------");

            if (entry.getKey())
            {
                System.out.println("Employees older than 25 years :");
            }
            else
            {
                System.out.println("Employees younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }





    }
}