package eventmaker.core.repository;

import eventmaker.core.repository.shared.Repository;
import eventmaker.data.User;

public class UserRepository extends Repository<User, Integer> {

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }
}
