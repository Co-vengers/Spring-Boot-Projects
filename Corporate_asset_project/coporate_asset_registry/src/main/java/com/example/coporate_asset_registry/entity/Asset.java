package com.example.coporate_asset_registry.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "corporate_assets")
@Getter
@Setter
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetName;
    private String category;
    private Double purchaseValue;
    private String assignedTo;

    protected Asset(){

    }

    public Asset(Long id, String assetName, String category, Double purchaseValue, String assignedTo){
        this.id = id;
        this.assetName = assetName;
        this.category = category;
        this.purchaseValue = purchaseValue;
        this.assignedTo = assignedTo;
    }
}
