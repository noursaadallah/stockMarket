package com.example.javaproject.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.javaproject.model.Admin;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {
	
	@Autowired
	private AdminRepository adminRepository;
//    @Before
//    public void setUp() throws Exception {
//        Admin admin= new Admin("admin", "admin");
//        //save admin, verify has ID value after save
//        assertNull(admin.getId());//null before save
//        adminRepository.save(admin);
//        assertNotNull(admin.getId());
//    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Admin admin = adminRepository.findByLogin("admin");
        assertNotNull(admin);
        assertEquals("admin", admin.getPwd());
        /*Get all products, list should only have two*/
        Iterable<Admin> admins = adminRepository.findAll();
        int count = 0;
        for(Admin a : admins){
            count++;
        }
        assertEquals(count, 1);
    }
}