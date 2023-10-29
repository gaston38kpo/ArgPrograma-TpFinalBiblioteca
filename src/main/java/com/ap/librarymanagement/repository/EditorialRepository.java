package com.ap.librarymanagement.repository;

import com.ap.librarymanagement.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    Editorial findByName(String name);
}
