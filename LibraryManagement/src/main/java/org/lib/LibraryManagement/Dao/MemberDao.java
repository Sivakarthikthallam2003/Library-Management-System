package org.lib.LibraryManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.lib.LibraryManagement.entity.Member;
import org.lib.LibraryManagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepository memeberRepository;
	
//	save Member
	public Member saveMem(Member member) {
		return memeberRepository.save(member);
	}
// find all Member
	public List<Member> getAll(){
		return memeberRepository.findAll();
	}
	
// find by id
	public Optional<Member> findByID(int id){
		return memeberRepository.findById(id);
	}
//  update Member
	public Member update(Member member) {
		return memeberRepository.save(member);
	}	
	
// Delete by id
	public void delete(Member member) {
		memeberRepository.delete(member);
		
	}
	

}
