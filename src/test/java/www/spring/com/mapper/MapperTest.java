package www.spring.com.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import www.spring.com.party.mapper.MemberMapper;
import www.spring.com.party.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {


	
	@Autowired
	private MemberMapper memberMapper;
	
	
	@Test
	public void testRead() {
		MemberVO vo = memberMapper.read("admin90");
		System.out.println(vo);
		vo.getAuthList().forEach(authVO -> System.out.println(authVO));
		//System.out.println(board);
		//log.info(board);
	}
}











