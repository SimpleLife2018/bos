package cn.itcast.bos.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.CourierRepository;
import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.service.ICourierService;

@Service
@Transactional
public class CourierServiceImpl implements ICourierService {

	@Resource
	private CourierRepository courierRepository;

	@Override
	public void add(Courier model) {
		courierRepository.save(model);
	}

	@Override
	public Page<Courier> pageQuery(Pageable pageable) {
		return courierRepository.findAll(pageable);
	}
}
