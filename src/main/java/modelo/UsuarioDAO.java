package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Conexion;
import interfaces.CRUD;

public class UsuarioDAO implements CRUD{
	Conexion cn=new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Usuarios u=new Usuarios();
	
	@Override
	public boolean verify(String user, String passwrd) {
		String sql = "SELECT * FROM tiendagenerica.usuario WHERE Usuario=\""+user+"\" AND Password = \""+passwrd + "\";";
		
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			
		}
		return false;
	}
	
	@Override
	public boolean add(Usuarios user) {
		return false;
	}
	@Override
	public String search(String cc) {
		String sql = "SELECT * FROM tiendagenerica.usuario WHERE Cedula_usuario=\""+cc+ "\";";
		String nombre="";
		String correo="";
		String usuario="";
		String pass="";
		
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				nombre=rs.getString("Nombre_usuario");
				correo=rs.getString("Email_usuario");
				usuario=rs.getString("Usuario");
				pass=rs.getString("Password");
			}
		}catch(Exception e) {
			
		}
		return (nombre+","+correo+","+usuario+","+pass);
		
	}
	@Override
	public boolean edit(String cc) {
		return false;
	}
	@Override
	public boolean del(String cc) {
		return false;
	}

}
