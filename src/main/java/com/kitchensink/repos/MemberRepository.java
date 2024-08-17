package com.kitchensink.repos;

import com.kitchensink.models.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, Long> {
    boolean existsByEmail(String email);
}
