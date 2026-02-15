package com.example.coporate_asset_registry.service;
import com.example.coporate_asset_registry.entity.Asset;
import com.example.coporate_asset_registry.repository.AssetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository){
        this.assetRepository = assetRepository;
    }

    public Asset addAsset(Asset asset){
        return assetRepository.save(asset);
    }

    public List<Asset> getAllAssets(){
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id){
        return assetRepository.findById(id).orElse(null);
    }

    public List<Asset> getAssetByCategory(String category){
        return assetRepository.findByCategory(category);
    }

    public Asset updateAsset(Long id, Asset assetDetails){
        Asset existingAsset = assetRepository.findById(id).orElse(null);

        if(existingAsset == null) return null;

        existingAsset.setAssetName(assetDetails.getAssetName());
        existingAsset.setCategory(assetDetails.getCategory());
        existingAsset.setPurchaseValue(assetDetails.getPurchaseValue());
        existingAsset.setAssignedTo(assetDetails.getAssignedTo());

        return assetRepository.save(existingAsset);
    }

    public String deleteAsset(Long id){
        if(assetRepository.existsById(id)){
            assetRepository.deleteById(id);
            return "Asset with ID " + id + " has been successfully deleted.";
        }
        else{
            return "Asset with ID " + id + " not found.";
        }
    }
}
