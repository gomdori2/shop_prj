package co.yedam.faq.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;
import co.yedam.faq.service.faqService;
import co.yedam.faq.vo.faqVO;

public class faqServiceImpl extends DAO implements faqService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<faqVO> noticeSelectList() {
		List<faqVO> list = new ArrayList<faqVO>();
		faqVO vo;
		String sql = "select * from faq";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new faqVO();
				vo.setId(Integer.parseInt(rs.getString("faq_id")));
				vo.setWdate(null); 
				vo.setTitle(rs.getString("faq_title"));
				vo.setContent(rs.getString("faq_content"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public faqVO noticeSelect(faqVO vo) {
		String sql = "select * from faq where faq_id= ?";
		try {
			
			// id 시퀀스로 컬럼 하나 더 만들어야 될듯. 
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertNotice(faqVO vo) {
	
			// 등록 시퀀스 준거는 / 수정 : 순번만. id pk > 삭제, 수정, 서치.
			// 이미지 경로 관련 테이블에 컬럼추가. 
			int n = 0;
			try {
				// 시퀀스 조회
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select faq_id.nextval from dual");
				rs.next();
				int id = rs.getInt(1);
				vo.setId(id);

				// 등록
				String sql = "insert into faq(faq_id, faq_title, faq_content, wdate) values(?,?,?,sysdate)";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, vo.getId());
				psmt.setString(2, vo.getTitle());
				psmt.setString(3, vo.getContent());
				
				n = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			return n;
		}

	@Override
	public int updateNotice(faqVO vo) {
		int n = 0;
		String sql = "update faq set  faq_title=?, faq_content=? where faq_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int deleteNotice(faqVO vo) {
		int n = 0;
		String sql = "delete faq where faq_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	public List<faqVO> selectNoticeListPaging(int page) {
		String sql = "SELECT b.rn\r\n"//
				+ "      ,b.*\r\n"//
				+ "FROM   (SELECT ROWNUM rn\r\n"//
				+ "              ,a.*\r\n"//
				+ "        FROM   (SELECT *\r\n"//
				+ "                FROM   notice\r\n"//
				+ "                ORDER  BY 1) a) b\r\n"//
				+ "WHERE  b.rn BETWEEN ? AND ?";

		List<faqVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;

		firstCnt = (page - 1) * 10 + 1;
		lastCnt = (page * 10);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while (rs.next()) {
				faqVO vo = new faqVO();
				vo.setContent(rs.getString("faq_content"));
				vo.setId(rs.getInt("faq_id")); 
				vo.setTitle(rs.getString("faq_title"));

				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

