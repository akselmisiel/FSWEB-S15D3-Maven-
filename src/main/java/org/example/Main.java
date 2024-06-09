package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);


        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: ");
        for (Employee employee : duplicates) {
            System.out.println(employee.getFirstname() + " " + employee.getLastName());
        }

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: ");
        for (Map.Entry<Integer, Employee> entry : uniques.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getFirstname() + " " + entry.getValue().getLastName());
        }

        List<Employee> removedDuplicates = removeDuplicates(employees);
        System.out.println("Removed Duplicates: ");
        for (Employee employee : removedDuplicates) {
            System.out.println(employee.getFirstname() + " " + employee.getLastName());
        }

    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) continue;
            if (map.containsKey(employee.getId())) {
                duplicates.add(employee);
            } else {
                map.put(employee.getId(), employee);
            }
        }
        return duplicates;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueEmployeesMap = new HashMap<>();
        Set<Employee> set = new HashSet<>();

        for (Employee employee : list) {
            if (employee == null) continue;
            if (set.add(employee)) {
                uniqueEmployeesMap.put(employee.getId(), employee);
            }
        }

        return uniqueEmployeesMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> duplicates = findDuplicates(list);
        Map<Integer, Employee> uniques = findUniques(list);
        List<Employee> removedDuplicates = new LinkedList<>(uniques.values());

        removedDuplicates.removeAll(duplicates);

        return removedDuplicates;
    }
}