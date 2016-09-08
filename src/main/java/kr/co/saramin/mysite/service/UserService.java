package kr.co.saramin.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saramin.mysite.dao.UserDao;
import kr.co.saramin.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public UserVo getUser(Long no) {
		return userDao.get(no);
	}
	
	public UserVo getUser(String email) {
		return userDao.get(email);
	}
	
	public void join(UserVo userVo) {
		userDao.insert(userVo);
	}
	
	public UserVo login(UserVo userVo) {
		return userDao.get(userVo);
	}
	
	public void modifyUser(UserVo userVo) {
		userDao.update(userVo);
	}
}
