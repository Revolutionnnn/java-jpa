package com.main;

import java.util.List;

import javax.persistence.EntityManager;

import com.entity.Employee;
import com.util.UtilEntity;

public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();

        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("Listar todos");
        employees.forEach(employee -> System.out.println(employee));

        System.out.println("Buscar uno");
        int employeeID = 3;
        Employee employee = em.find(Employee.class, employeeID);
        System.out.println(employee);
        /*
         * System.out.println("Crear uno");
         * Employee newEmployee = new Employee();
         * newEmployee.setFirstName("Pepito");
         * newEmployee.setMaSurname("Borges");
         * newEmployee.setPaSurname("Perez");
         * newEmployee.setEmail("pepito@g.com");
         * newEmployee.setSalary((float) 10000);
         * em.getTransaction().begin();
         * em.persist(newEmployee);
         * em.getTransaction().commit();
         * System.out.println("Nuevo empleado creado" + newEmployee);
         */
        /*
         * System.out.println("Actualizar");
         * int employeeToUpdateId = 2;
         * Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId);
         * System.out.println(employeeToUpdate);
         * employeeToUpdate.setFirstName("Magallanes");
         * employeeToUpdate.setSalary((float) 500);
         * em.getTransaction().begin();
         * em.merge(employeeToUpdate);
         * em.getTransaction().commit();
         * System.out.println("Empleado actualizado" + employeeToUpdate);
         */
        System.out.println("Delete");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println(employeeToDelete);
        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        System.out.println("Empleado Eliminado");
        em.close();
    }
}