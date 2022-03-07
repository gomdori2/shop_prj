package co.yedam.faq.service;

import java.util.List;

import co.yedam.faq.vo.faqVO;

public interface faqService {
	List<faqVO> noticeSelectList();
	faqVO noticeSelect(faqVO vo);
	int insertNotice(faqVO vo);
	int updateNotice(faqVO vo);
	int deleteNotice(faqVO vo);
	faqVO noticeSearch(faqVO vo);
}
