package com.example.practicadocker.Servicio;

import com.example.practicadocker.Entidad.Formulario;
import com.example.practicadocker.Entidad.Rol;
import com.example.practicadocker.Entidad.Usuario;
import com.example.practicadocker.Repositorio.FormRepo;
import com.example.practicadocker.Repositorio.RolRepository;
import com.example.practicadocker.Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeguridadServices implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FormRepo formRepo;

    @Autowired
    private RolRepository rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //cualquier cosa...

    /**
     * Creando el usuario por defecto y su rol.
     */
    public void crearUsuarioAdmin(){
        System.out.println("Creación del usuario y rol en la base de datos");
        Rol rolAdmin = new Rol("ROLE_ADMIN");
        //rolRepository.save(rolAdmin);

        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setName("Administrador");
        admin.setActivo(true);
        admin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));
        usuarioRepository.save(admin);

    }
    public void crearUsuarioUser(){
        System.out.println("Creación del usuario y rol en la base de datos");
        Rol rolUser = new Rol("ROLE_USER");
        //rolRepository.save(rolAdmin);

        Usuario user = new Usuario();
        user.setUsername("user");
        user.setPassword(bCryptPasswordEncoder.encode("1234"));
        user.setName("Guest");
        user.setActivo(true);
        user.setRoles(new HashSet<>(Arrays.asList(rolUser)));
        usuarioRepository.save(user);

    }
    /*public void crearFormularioTest(){
        Formulario formulario = new Formulario(1,2,3,"no");
        formRepo.save(formulario);
    }
*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActivo(), true, true, true, grantedAuthorities);
    }
}