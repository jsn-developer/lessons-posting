package jp.co.solxyz.lessons.posting.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PostServiceTest {

	private PostService target;

	@Before
	public void setUp() {
		try {
			this.target = new PostService();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void test() {

	}

}
