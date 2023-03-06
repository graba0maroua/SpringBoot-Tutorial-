package com.gb.Springboottoturial.repository;

import com.gb.Springboottoturial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
/*this test class verifies that the DepartmentRepository can successfully
retrieve a department from the in-memory database by ID.*/
    @DataJpaTest
    /*The @DataJpaTest annotation is used at the class level to configure
    the test with an in-memory database and the necessary Spring components to test JPA repositories.*/
    class DepartmentRepositoryTest {

        @Autowired
        private DepartmentRepository departmentRepository;

        @Autowired
        private TestEntityManager entityManager;
        /*TestEntityManager is a utility provided by Spring to perform JPA operations for testing.*/

        @BeforeEach
        /*In the setUp() method, we create a new Department object and persist it to the in-memory database using the TestEntityManager. This sets up the data we need for the test case.*/
        void setUp() {
            Department department =
                    Department.builder()
                            .departmentName("Mechanical Engineering")
                            .departmentCode("ME - 011")
                            .departmentAddress("Delhi")
                            .build();

            entityManager.persist(department);
        }

        @Test
        public void whenFindById_thenReturnDepartment() {
            Department department = departmentRepository.findById(1L).get();
            assertEquals(department.getDepartmentName(), "Mechanical Engineering");
        }
}