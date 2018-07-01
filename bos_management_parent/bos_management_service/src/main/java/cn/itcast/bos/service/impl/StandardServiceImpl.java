package cn.itcast.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.StandardRepository;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.IStandardService;

@Service
@Transactional
public class StandardServiceImpl implements IStandardService {

	@Autowired
	private StandardRepository standardRepository;

	@Override
	public void add(Standard model) {
		standardRepository.save(model);//相当于hibernateTempldate中的saveOrUpdate方法
	}

	@Override
	public Page<Standard> pageQuery(Pageable pageable) {
		return standardRepository.findAll(pageable);
	}

	@Override
	public List<Standard> findAll() {
		return standardRepository.findAll();
	}
}
