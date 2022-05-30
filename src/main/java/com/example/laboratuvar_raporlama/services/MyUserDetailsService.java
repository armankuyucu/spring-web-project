package com.example.laboratuvar_raporlama.services;

import com.example.laboratuvar_raporlama.domain.Laborant;
import com.example.laboratuvar_raporlama.repositories.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    LaborantRepository laborantRepository;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Laborant laborant = laborantRepository.findById(id);
        if(laborant == null)
            throw new UsernameNotFoundException("Kullanıcı Bulunamadı!");

        return new UserPrincipal(laborant);
    }
}
