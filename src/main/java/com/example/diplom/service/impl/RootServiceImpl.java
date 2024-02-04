package com.example.diplom.service.impl;

import com.example.diplom.model.Root;
import com.example.diplom.repository.RootRepository;
import com.example.diplom.service.RootService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RootServiceImpl implements RootService {
    private final RootRepository rootRepository;

    @Override
    public Root getRoot(String numberCadastr) {
        return rootRepository.findByNumberCadastr(numberCadastr);
    }

    @Override
    @Transactional
    public Root saveOrUpdate(Root root) {
        Integer rootId = root.getId();
        if (rootId != null) {
            Root rootDb = getRootById(rootId);
            return updateRoot(root, rootDb);
        } else {
            return saveRoot(root);
        }
    }

    private Root updateRoot(Root root, Root rootDb) {
        rootDb.setFloor(root.getFloor());
        rootDb.setMeters(root.getMeters());
        rootDb.setFullAddress(root.getFullAddress());
        rootDb.setOwnership(root.getOwnership());
        rootDb.setNumberCadastr(root.getNumberCadastr());
        return rootRepository.save(rootDb);
    }

    private Root saveRoot(Root root) {
        return rootRepository.save(root);
    }


    private Root getRootById(Integer id) {
        return rootRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
