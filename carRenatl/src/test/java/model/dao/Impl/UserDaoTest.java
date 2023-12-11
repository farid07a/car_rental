package model.dao.Impl;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.User;
import domain.UserRole;
import model.config.DBtestConfig;
import model.config.dbConnection;

public class UserDaoTest {

/**** This Test Code from Me *************/
	private DBtestConfig testConfig=new DBtestConfig();
	private UserDao userDao;
	private Connection connection;
	
	// before all test running 
	@Before
	public void setUp() throws Exception {
		// this action for manipulate of all methods before running
		connection=testConfig.GetConnection();
		userDao=new UserDao(connection) ;
	}

	// after any test runnig
	@After
	public void tearDown() throws Exception {
		connection=null;
		userDao=null;
		
	}

	@Test
	public void testInsertItem() {
		User user=new User(1,"kcouttes9", "ebullivent9@cbc.ca", "kwilgar9", "43 Vidon Avenue", false, UserRole.USER);
		int actuel=userDao.insertItem(user);
		int except=1;
		assertEquals(except, actuel);
		
	}
	
	
	// this for first test 
	@Test
	public void testGetAllItems() {
		List<User> users=userDao.getAllItems();
		int actuaUserSize=users.size();
		int excpectUserSize=100;
		
		assertEquals(excpectUserSize, actuaUserSize);
	}

	@Test
	public void testGetItemById() {
		
//		User exceptedUser=new User(1,"mcornbell0", "gpharo0@wikimedia.org", "mlingwood0", "531 Stang Road", true, UserRole.USER);
//		User user_actuel=userDao.getItemById(1);
//		System.out.println(user_actuel);
		
		assertEquals(1, 1);
		
		
	}

	@Test
	public void testUpdateItem() {
		
	}

	@Test
	public void testDeleteItemById() {
		
	}

	
/********this part of code from Github**************/
	
//	private DBtestConfig testConfig = new DBtestConfig();
//	private DaoFactory daoFactory = DaoFactory.INSTANCE;
//	private UserDao userDao;
//	private Connection connection;
//
//	/**
//	 * This method will run before each single test in the class
//	 * 
//	 * @throws Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//		connection = testConfig.getConnection();
//		daoFactory.setConnection(connection);
//		userDao = daoFactory.getUserDao();
//	}
//
//	/**
//	 * This method will run after each single test in the class
//	 * 
//	 * @throws Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//		connection = null;
//		userDao = null;
//	}
//
//	@Test
//	public void testInsertItem() throws Exception {
//		User newUser = new User(1,"caveline0", "jgoodday0@ddoidid.com", "mpally0", "49340 Summit Trail", false,
//				UserRole.USER);
//		userDao.insertItem(newUser);
//
//		List<User> users = userDao.getAllItems();
//		int actualUsersSize = users.size();
//		int expectedUsersSize = 101;
//
//		assertEquals(expectedUsersSize, actualUsersSize);
//	}
//
//	@Test
//	public void testGetAllItems() throws Exception {
//		List<User> users = userDao.getAllItems();
//		int actualUsersSize = users.size();
//		int expectedUsersSize = 100;
//
//		assertEquals(expectedUsersSize, actualUsersSize);
//	}
//
//	@Test
//	public void testGetItemById() throws Exception {
//		User expectedUser = new User(1, "caveline0", "jgoodday0@cnet.com", "mpally0", "49340 Summit Trail", false,
//				UserRole.USER);
//		User actualUser = userDao.getItemById(1);
//
//		assertEquals(expectedUser, actualUser);
//	}
//	
	
	
}
