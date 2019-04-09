package br.com.senior.furb.basico.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.furb.basico.WorldBaseRepository;
import br.com.senior.furb.basico.WorldEntity;

@Repository
public interface WorldRepository extends WorldBaseRepository, JpaRepository<WorldEntity, UUID> {

}
