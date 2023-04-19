
package components;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepository extends CrudRepository<UserData, Long> {
}

