package com.driverbuddy.driverbuddy.services;

import com.driverbuddy.driverbuddy.entities.Entry;
import com.driverbuddy.driverbuddy.entities.Month;
import com.driverbuddy.driverbuddy.repositories.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    @Autowired
    private EntryRepo entryRepo;

    public List<Entry> getAll() {
        return entryRepo.findAll();
    }

    public List<Entry> getAllWithMonth(Integer year, Integer month) {
        year = year == null ? LocalDate.now().getYear() : year;
        return entryRepo.findByYearAndMonth(year, month);
    }

    public Entry save(Entry entry) {
        return this.entryRepo.save(entry);
    }

    public void delete(Integer id){
        Entry entry = entryRepo.findById(id).orElse(null);
        assert entry != null;
        this.entryRepo.delete(entry);
    }

    public Entry update(Entry entry){
        Entry toUpdate = this.entryRepo.findByDate(entry.getDate()).orElse(null);
        assert toUpdate != null;
        toUpdate.setKm(entry.getKm());
        toUpdate.setGasCons(entry.getGasCons());
        toUpdate.setGasPrice(entry.getGasPrice());
        toUpdate.setTipsIncome(entry.getTipsIncome());
        toUpdate.setRidesIncome(entry.getRidesIncome());
        toUpdate.setNoHours(entry.getNoHours());
        toUpdate.setNoRides(entry.getNoRides());
        return this.entryRepo.save(toUpdate);
    }
}
