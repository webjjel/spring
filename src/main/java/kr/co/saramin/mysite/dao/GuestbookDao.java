package kr.co.saramin.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.saramin.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	@Autowired
	SqlSession sqlSession;

	public GuestbookVo get(Long no) {
		return sqlSession.selectOne("guestbook.getByNo", no);
	}
	
	public int insert(GuestbookVo vo) {
		int count = sqlSession.insert("guestbook.insert", vo);
		System.out.println(vo.getNo());
		return count;
	}
	
	public int delete(GuestbookVo vo) {
		int count = sqlSession.delete("guestbook.delete", vo);
		return count;
	}
	
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
}