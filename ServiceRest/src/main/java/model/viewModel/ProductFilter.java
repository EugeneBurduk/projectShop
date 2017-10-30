package model.viewModel;


public class ProductFilter {
   private String brand;
   private Integer minDiameter;
    private Integer maxDiameter;

    public ProductFilter() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getMinDiameter() {
        return minDiameter;
    }

    public void setMinDiameter(Integer minDiameter) {
        this.minDiameter = minDiameter;
    }

    public Integer getMaxDiameter() {
        return maxDiameter;
    }

    public void setMaxDiameter(Integer maxDiameter) {
        this.maxDiameter = maxDiameter;
    }

    @Override
    public String toString() {
        return "ProductFilter{" +
                "brand='" + brand + '\'' +
                ", minDiameter=" + minDiameter +
                ", maxDiameter=" + maxDiameter +
                '}';
    }
}
