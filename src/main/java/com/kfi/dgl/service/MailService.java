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

		String key = new Key().getKey(50, false); // ����Ű ����

		dao.createKey(vo.getUser_email()); // ����Ű DB ����

		com.kfi.dgl.util.MailUtil sendMail = new MailUtil(mailSender);

		sendMail.setText(new StringBuffer().append("<h1>��������</h1>")
				.append("<a href='http://localhost:9090/kfi/mailcert?user_email=" + vo.getUser_email())
				.append("' target='_blenk'>�̸��� ���� Ȯ��</a>").toString());

		sendMail.setFrom("donkr24@gmail.com", "��������~!");
		sendMail.setTo(vo.getUser_email());
		sendMail.send();
	}
}
