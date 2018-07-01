package cn.itcast.bos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.itcast.bos.domain.base.Courier;

public interface ICourierService {

	void add(Courier model);

	Page<Courier> pageQuery(Pageable pageable);

}
