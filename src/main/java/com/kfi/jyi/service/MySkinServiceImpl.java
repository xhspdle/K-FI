package com.kfi.jyi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.xml.sax.InputSource;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.MySkinCoverDao;
import com.kfi.jyi.dao.MySkinDao;
import com.kfi.jyi.dao.MySkinProfileDao;
import com.kfi.jyi.dao.MySkinViewDao;
import com.kfi.jyi.vo.MySkinCoverVo;
import com.kfi.jyi.vo.MySkinProfileVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.jyi.vo.MySkinVo;
import com.kfi.ldk.service.CommonService;

@Service
public class MySkinServiceImpl implements CommonService {
	@Autowired
	private MembersDao mdao;
	@Autowired
	private MySkinDao msdao;
	@Autowired
	private MySkinCoverDao mscdao;
	@Autowired
	private MySkinProfileDao mspdao;
	@Autowired
	private MySkinViewDao msvdao;

	@Override
	public int getMaxNum() {
		return 0;
	}

	@Override
	public int getCount(Object data) {
		// where user_num=#{user_num} and ms_name like '%��Ų%'
		int user_num = (Integer) data;
		return msdao.getCount_like_Skin(user_num);
	}

	@Override
	@Transactional
	public int insert(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) hm.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		MultipartFile ms_profile = (MultipartFile) hm.get("ms_profile");
		MultipartFile ms_cover = (MultipartFile) hm.get("ms_cover");
		String ms_name = (String) hm.get("ms_name");
		String ms_color = (String) hm.get("ms_color");
		String ms_msg = (String) hm.get("ms_msg");

		if (ms_name == null || ms_name.equals(""))
			ms_name = "��Ų";
		if (ms_color == null || ms_color.equals(""))
			ms_color = "#00cee8";
		if (ms_msg == null || ms_msg.equals(""))
			ms_msg = "";

		String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");
		String[] savimg = new String[2];
		try {
			int ms_num = msdao.getMaxNum();
			ms_num = ms_num + 1;
			msdao.insert(new MySkinVo(ms_num, user_num, ms_name, ms_color, ms_msg, 0));
			// ������ ���� ���� ��
			int msp_num = mspdao.getMaxNum();
			msp_num += 1;
			if (!ms_profile.isEmpty()) {
				// ������ �������� ���� �ٸ� ������ ���� �� �����Ƿ� ��� �� ���ε�
				String msp_orgimg = ms_profile.getOriginalFilename();
				String msp_savimg = UUID.randomUUID() + "_" + msp_orgimg;
				savimg[0] = msp_savimg;
				InputStream is = ms_profile.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msp_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				mspdao.insert(new MySkinProfileVo(msp_num, ms_num, msp_orgimg, msp_savimg));
			} else {
				mspdao.insert(new MySkinProfileVo(msp_num, ms_num, "default-profile.png", "default-profile.png"));
			}
			// Ŀ�� ���� ���� ��
			int msc_num = mscdao.getMaxNum();
			msc_num += 1;
			if (!ms_cover.isEmpty()) {
				String msc_orgimg = ms_cover.getOriginalFilename();
				String msc_savimg = UUID.randomUUID() + "_" + msc_orgimg;
				savimg[1] = msc_savimg;
				InputStream is = ms_cover.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msc_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				mscdao.insert(new MySkinCoverVo(msc_num, ms_num, msc_orgimg, msc_savimg));
			} else {
				mscdao.insert(new MySkinCoverVo(msc_num, ms_num, "logo2.png", "logo2.png"));
			}
			return 1;
		} catch (Exception e) {
			for (int i = 0; i < savimg.length; i++) {
				File file = new File(uploadPath + "\\" + savimg[i]);
				if (file.delete())
					System.out.println("���� ���� ����");
			}
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) hm.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		int ms_num = (Integer) hm.get("ms_num");
		// �⺻ �̹����� �����ϱ�
		if (ms_num == -1) {
			List<MySkinViewVo> list = msvdao.list(user_num);
			int num = 0;
			for (MySkinViewVo msvv : list) {
				// �̹� �⺻��Ų ������ ���
				if (msvv.getMs_name().equals("�⺻��Ų") 
						&& msvv.getMs_color().equals("#00cee8")
						&& msvv.getMsp_savimg().equals("default-profile.png")
						&& msvv.getMsc_savimg().equals("logo2.png") 
						&& (msvv.getMs_msg().equals(" "))) {
					++num;
					msdao.update(new MySkinVo(msvv.getMs_num(), user_num,msvv.getMs_name(),msvv.getMs_color()," ", 1));
				}
			}
			if (num == 0) {
				ms_num = msdao.getMaxNum() + 1;
				msdao.insert(new MySkinVo(ms_num, user_num, "�⺻��Ų", "#00cee8", " ", 1));
				int msp_num = mspdao.getMaxNum() + 1;
				int msc_num = mscdao.getMaxNum() + 1;
				mspdao.insert(new MySkinProfileVo(msp_num, ms_num, "default-profile.png", "default-profile.png"));
				mscdao.insert(new MySkinCoverVo(msc_num, ms_num, "logo2.png", "logo2.png"));
			}
			HashMap<String, Object> updateElse = new HashMap<>();
			updateElse.put("user_num", user_num);
			updateElse.put("ms_num", ms_num);
			msdao.update_not_using(updateElse);
			return 1;
		}
		int ms_using = (Integer) hm.get("ms_using");
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "ms_num");
		map.put("ms_num", ms_num);
		MySkinViewVo msvVo = (MySkinViewVo) select(map);
		// ������ ��Ų �����ϱ�
		if (ms_using == 2) {
			msdao.update(new MySkinVo(ms_num, user_num, msvVo.getMs_name(), msvVo.getMs_color(), msvVo.getMs_msg(), 1));
			HashMap<String, Object> updateElse = new HashMap<>();
			updateElse.put("user_num", user_num);
			updateElse.put("ms_num", ms_num);
			msdao.update_not_using(updateElse);
			return 1;
		}
		MultipartFile ms_profile = (MultipartFile) hm.get("ms_profile");
		MultipartFile ms_cover = (MultipartFile) hm.get("ms_cover");
		String ms_name = (String) hm.get("ms_name");
		String ms_color = (String) hm.get("ms_color");
		String ms_msg = (String) hm.get("ms_msg");
		if (ms_name == null) {
			ms_name = msvVo.getMs_name();
		}
		if (ms_msg == null) {
			ms_msg = "";
		}
		msdao.update(new MySkinVo(ms_num, user_num, ms_name, ms_color, ms_msg, ms_using));
		int update = 0;
		for (int i = 0; i < 2; i++) {
			// ���� ���� ���� ��
			if (!ms_profile.isEmpty())
				++update;
			if (!ms_cover.isEmpty())
				++update;
		}
		if (update == 0)
			return 1;
		try {
			String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");
			String msp_orgimg = msvVo.getMsp_orgimg();
			String msp_savimg = msvVo.getMsp_savimg();
			String msc_orgimg = msvVo.getMsc_orgimg();
			String msc_savimg = msvVo.getMsc_savimg();
			if (!ms_profile.isEmpty()) {
				if (!(msp_savimg.equals("default-profile.png"))) {
					File file = new File(uploadPath + "\\" + msp_savimg);
					if (file.delete())
						System.out.println("���� ���� ���� ����");
				}
				msp_orgimg = ms_profile.getOriginalFilename();
				msp_savimg = UUID.randomUUID() + "_" + msp_orgimg;
				InputStream is = ms_profile.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msp_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPath + " ��ο� ������ ���� �������ε� ����");
				mspdao.update(new MySkinProfileVo(msvVo.getMsp_num(), ms_num, msp_orgimg, msp_savimg));
			}
			if (!ms_cover.isEmpty()) {
				if (!(msc_savimg.equals("logo2.png"))) {
					File file = new File(uploadPath + "\\" + msc_savimg);
					if (file.delete())
						System.out.println("���� ���� ���� ����");
				}
				msc_orgimg = ms_cover.getOriginalFilename();
				msc_savimg = UUID.randomUUID() + "_" + msc_orgimg;
				InputStream is = ms_cover.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msc_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPath + " ��ο� Ŀ�� ���� �������ε� ����");
				mscdao.update(new MySkinCoverVo(msvVo.getMsc_num(), ms_num, msc_orgimg, msc_savimg));
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	@Transactional
	public int delete(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		int ms_num = (Integer) hm.get("ms_num");
		HttpSession session = (HttpSession) hm.get("session");
		String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("list", "ms_num");
			map.put("ms_num", ms_num);
			MySkinViewVo list = (MySkinViewVo) select(map);

			mspdao.delete(ms_num);
			if (!(list.getMsp_savimg().equals("default-profile.png"))) {
				File file = new File(uploadPath + "\\" + list.getMsp_savimg());
				if (file.delete())
					System.out.println("���� ���� ����");
			}
			mscdao.delete(ms_num);
			if (!(list.getMsc_savimg().equals("logo2.png"))) {
				File file = new File(uploadPath + "\\" + list.getMsc_savimg());
				if (file.delete())
					System.out.println("���� ���� ����");
			}
			msdao.delete(ms_num);

			// ��Ų ��� ������, �⺻ ��Ų �ϳ� �ֱ�
			int user_num = (Integer) session.getAttribute("user_num");
			List<MySkinViewVo> skinList = (List<MySkinViewVo>) msvdao.list(user_num);
			if (skinList.isEmpty()) {
				ms_num = msdao.getMaxNum() + 1;
				msdao.insert(new MySkinVo(ms_num, user_num, "�⺻��Ų", "#00cee8", " ", 1));
				int msp_num = mspdao.getMaxNum() + 1;
				int msc_num = mscdao.getMaxNum() + 1;
				mspdao.insert(new MySkinProfileVo(msp_num, ms_num, "default-profile.png", "default-profile.png"));
				mscdao.insert(new MySkinCoverVo(msc_num, ms_num, "logo2.png", "logo2.png"));
			}

			// ������� ��Ų�� ������ ���
			if (list.getMs_using() == 1) {
				List<MySkinViewVo> skinlist = (List<MySkinViewVo>) msvdao.list(user_num);
				MySkinViewVo skinvo = skinlist.get(0);
				msdao.update(new MySkinVo(skinvo.getMs_num(), user_num, skinvo.getMs_name(), skinvo.getMs_color(),
						skinvo.getMs_msg(), 1));
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public Object select(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		String list = (String) map.get("list");
		if (list.equals("ms_num")) {
			int ms_num = (Integer) map.get("ms_num");
			return msvdao.select(ms_num);
		} else if (list.equals("ms_using")) {
			int user_num = (Integer) map.get("user_num");
			return msvdao.select_using(user_num);
		}
		return null;
	}

	@Override
	public Object list(Object data) {
		int user_num = (Integer) data;
		return msvdao.list(user_num);
	}

}
