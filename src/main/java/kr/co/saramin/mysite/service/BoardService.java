package kr.co.saramin.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.saramin.mysite.dao.BoardDao;
import kr.co.saramin.mysite.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getList(String kwd) {
		if (kwd != null) {
			return boardDao.getList(kwd);
		}
		return boardDao.getList();
	}
	
	public BoardVo view(Long no) {
		return boardDao.get(no);
	}
	
	public void write(BoardVo vo) {
		boardDao.insert(vo);
	}
	
	public void modify(BoardVo vo) {
		boardDao.update(vo);
	}
	
	public void delete(BoardVo boardVo) {
		boardDao.delete(boardVo);
	}
}
