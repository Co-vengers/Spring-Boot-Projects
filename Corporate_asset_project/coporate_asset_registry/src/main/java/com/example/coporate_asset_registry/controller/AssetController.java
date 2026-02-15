package com.example.coporate_asset_registry.controller;
import com.example.coporate_asset_registry.entity.Asset;
import com.example.coporate_asset_registry.service.AssetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService){
        this.assetService = assetService;
    }

    @PostMapping("/add")
    public Asset addAsset(@RequestBody Asset asset){
        return assetService.addAsset(asset);
    }

    @GetMapping("/all")
    public List<Asset> getAllAssets(){
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset getAssetsById(@PathVariable Long id){
        return assetService.getAssetById(id);
    }

    @GetMapping("/category/{category}")
    public List<Asset> getAssetByCategory(@PathVariable String category){
        return assetService.getAssetByCategory(category);
    }

    @PutMapping("/update/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails){
        return assetService.updateAsset(id, assetDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id){
        return assetService.deleteAsset(id);
    }
}
