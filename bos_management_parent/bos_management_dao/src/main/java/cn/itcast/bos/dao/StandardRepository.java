package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.base.Standard;

/**
 * <p>Title: cn.itcast.bos.daoStandardRepository.java
 * 	泛型1：实体类
 * 	泛型2：实体中主键的类型
 * </p>
 * <p>Description:</p>
 * <p>Company: www.itcast.com</p>
 * @author  传智.九纹龙
 * @date	2018年3月29日下午5:03:56
 * @version 1.0
 */
public interface StandardRepository extends JpaRepository<Standard, Integer> {

	public List<Standard> findByName(String name);

	public List<Standard> findByNameLike(String string);

	@Query("from Standard where name like ?1")
	public List<Standard> getNameLike(String string);
}
