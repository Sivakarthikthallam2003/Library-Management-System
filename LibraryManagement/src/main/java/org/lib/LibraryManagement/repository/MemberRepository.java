package org.lib.LibraryManagement.repository;

import org.lib.LibraryManagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
