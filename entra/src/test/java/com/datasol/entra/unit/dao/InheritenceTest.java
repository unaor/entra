package com.datasol.entra.unit.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.datasol.entra.domain.Child;
import com.datasol.entra.domain.Father;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class InheritenceTest {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Test
	public void createInheritence(){
		
		Session session = sessionFactory.getCurrentSession();
		Father father1 = new Father();
		father1.setName("kobi");
		Father father2 = new Father();
		father1.setName("leonel");
		session.save(father1);
		session.save(father2);
		session.flush();
		Father dbFather = (Father)session.createQuery("from Father").list().get(0);
		assertNotNull(dbFather);
		Child child = new Child();
		child.setName(dbFather.getName());
		child.setFatherId(dbFather.getFatherId());
		child.setAge(32L);
		session.save(child);
		session.flush();
		Child dbChild = (Child)session.createQuery("select age from childs where father_id=1").list().get(0);
		assertEquals("leonel", dbChild.getName());
	}

}
