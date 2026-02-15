package com.example.coporate_asset_registry.repository;
import com.example.coporate_asset_registry.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{
    List<Asset> findByCategory(String category);
}
