/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 30, 2023
 */

package dmacc.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordEntryRepository extends JpaRepository<PasswordEntry, Long> {
}
