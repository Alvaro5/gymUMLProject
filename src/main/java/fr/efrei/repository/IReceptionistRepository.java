package fr.efrei.repository;

import fr.efrei.domain.Receptionist;

import java.util.List;

public interface IReceptionistRepository extends  IRepository<Receptionist, Integer>{
    List<Receptionist> getAll();
}
