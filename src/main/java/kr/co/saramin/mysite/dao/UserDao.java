package kr.co.saramin.mysite.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.saramin.mysite.exception.UserDaoException;
import kr.co.saramin.mysite.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	SqlSession sqlSession;
	
	public UserVo get(UserVo vo) {
		return sqlSession.selectOne("user.getByEmailAndPassword", vo);
	}
	
	public UserVo get(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}

	public void insert(UserVo vo) throws UserDaoException {
		sqlSession.insert("user.insert", vo);
	}
	
	public void update(UserVo vo) {
		sqlSession.update("user.update", vo);
	}
}