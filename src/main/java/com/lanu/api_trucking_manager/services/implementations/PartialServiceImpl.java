package com.lanu.api_trucking_manager.services.implementations;

import com.lanu.api_trucking_manager.entities.Partial;
import com.lanu.api_trucking_manager.repositories.PartialRepository;
import com.lanu.api_trucking_manager.services.PartialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartialServiceImpl implements PartialService {

    @Autowired
    private PartialRepository partialrepository;

    @Override
    public Optional<Partial> findById(Integer partialId) {
        return partialrepository.findById(partialId);
    }

    @Override
    public Page<Partial> findByFreightFreightId(Long freightId, Pageable pageable) {
        return partialrepository.findByFreightFreightId(freightId, pageable);
    }

    @Override
    public List<Partial> findAllByFreightFreightId(Long freightId) {
        return partialrepository.findAllByFreightFreightId(freightId);
    }

    @Override
    public Partial save(Partial partial) {
        return partialrepository.save(partial);
    }
}
