package Guide.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Guide.backend.entity.Guide;

public interface GuideRepository extends JpaRepository <Guide,Long>{

}
