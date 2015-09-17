package eventmaker.repository;

import eventmaker.data.User;
import eventmaker.repository.shared.IRepository;

public interface IUserRepository extends IRepository<User> {
    User getUserByLogin(String name);
}
