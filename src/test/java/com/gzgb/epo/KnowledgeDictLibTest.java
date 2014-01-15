package com.gzgb.epo;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.entity.KnowledgeDictLib;
import com.gzgb.epo.service.knowledgeDictLib.KnowledgeDictLibService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" ,"classpath:application-dispatcher.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional  
public class KnowledgeDictLibTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private KnowledgeDictLibService kdlService;

	@Before
	public  void setUpBeforeClass() throws Exception {
		
	}

	@After
	public  void tearDownAfterClass() throws Exception {
		
	}

	@Test    //测试
	@Rollback(true)  
	public void testA(){
		KnowledgeDictLib parent = kdlService.findById(Long.parseLong("1"), KnowledgeDictLib.class);
		System.out.println(parent);
	}

	
	public static void main(String[] args) {

	}

}
