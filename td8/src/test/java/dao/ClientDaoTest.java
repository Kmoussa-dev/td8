package dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ClientDaoTest extends AbstractDaoTest{

    @Autowired
    private ClientDao clientDao;

    @Test
    public void countTest(){
        assertEquals("Client Nb",3,clientDao.count());
    }

    @Test
    public void findAllTest(){
        assertEquals("nombre de personnes dans la BD",3,clientDao.findAll().size());
    }

//    @Test
//    public void createtest(){
//
//    }
//
//    @Test
//    public void edittest(){
//
//    }
//
//    @Test
//    public void removetest(){
//
//    }
//
//    @Test
//    public void findtest(Object id){
//
//    }

}