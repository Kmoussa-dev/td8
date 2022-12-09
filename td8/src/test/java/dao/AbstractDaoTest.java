package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-test.xml"})
@Transactional
public abstract class AbstractDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    DataSource dataSource;
    @PersistenceContext
    private EntityManager em;

    @Before
    public void beforeTest() {
        setDataSource(dataSource);
        super.executeSqlScript("classpath:integration.sql", false);
    }

    protected void flush() {
        em.flush();
    }
    public DataSource getDataSrc() {
        return dataSource;
    }
    public void setDataSrc(DataSource dataSrc) {
        this.dataSource = dataSrc;
    }
}