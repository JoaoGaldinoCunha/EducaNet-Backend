package br.com.school.educanet.entity;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data; 

@Entity
@Table(name="Usuario")
@Data
public class User {
	@Id
	private String UsuarioEmail;
	private String UsuarioSenha;
	private Character UsuarioCpf;
	private String UsuarioStatus;
	private String UsuarioVerificacao;
	@Temporal(TemporalType.DATE)
	private Date UsuarioMatricula = new Date();
	public String getUsuarioEmail() {
		return UsuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		UsuarioEmail = usuarioEmail;
	}
	public String getUsuarioSenha() {
		return UsuarioSenha;
	}
	public void setUsuarioSenha(String usuarioSenha) {
		UsuarioSenha = usuarioSenha;
	}
	public Character getUsuarioCpf() {
		return UsuarioCpf;
	}
	public void setUsuarioCpf(Character usuarioCpf) {
		UsuarioCpf = usuarioCpf;
	}
	public String getUsuarioStatus() {
		return UsuarioStatus;
	}
	public void setUsuarioStatus(String usuarioStatus) {
		UsuarioStatus = usuarioStatus;
	}
	public String getUsuarioVerificacao() {
		return UsuarioVerificacao;
	}
	public void setUsuarioVerificacao(String usuarioVerificacao) {
		UsuarioVerificacao = usuarioVerificacao;
	}
	public Date getUsuarioMatricula() {
		return UsuarioMatricula;
	}
	public void setUsuarioMatricula(Date usuarioMatricula) {
		UsuarioMatricula = usuarioMatricula;
	}
	
	
	
	

}


