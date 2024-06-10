package br.com.school.educanet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.school.educanet.model.TbUser;


@Repository
public interface UserRepository extends JpaRepository<TbUser,Integer>{
	
	 TbUser findByEmail(String email);
	
	 boolean existsByPasswordAndEmail(String password,String email);
	
	@Query("select use from TbUser use where use.userCpf= :userCpf")
	TbUser findByUserCpf (@Param("userCpf") String cpf);
	
	@Query("select use from TbUser use where use.userVerification= :Type")
	TbUser findByType (@Param("Type") String userVerification);

}