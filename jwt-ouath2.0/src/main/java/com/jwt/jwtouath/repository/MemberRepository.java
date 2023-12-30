package com.jwt.jwtouath.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.entity.Member;

public interface MemberRepository extends JpaRepository<Member, UUID> {
	Optional<Member> findByAccount(String account);
	List<Member> findAllByType(MemberType type);
}
