package com.kfi.dgl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.util.Key;
import com.kfi.dgl.util.MailUtil;
import com.kfi.dgl.vo.MembersVo;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	MembersDao dao;

	@Transactional
	public void insert(MembersVo vo) throws Exception {
		dao.insert(vo);

		String key = new Key().getKey(50, false); // 인증키 생성

		dao.createKey(vo.getUser_email()); // 인증키 DB 저장

		com.kfi.dgl.util.MailUtil sendMail = new MailUtil(mailSender);

		sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
				.append("<a href='http://localhost:9090/kfi/mailcert?user_email=" + vo.getUser_email())
				.append("' target='_blenk'>이메일 인증 확인</a>").toString());

		sendMail.setFrom("donkr24@gmail.com", "인증인증~!");
		sendMail.setTo(vo.getUser_email());
		sendMail.send();
	}
}
