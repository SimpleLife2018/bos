package cn.itcast.bos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.bos.domain.base.Courier;

public interface CourierRepository extends JpaRepository<Courier, Integer> {

}
